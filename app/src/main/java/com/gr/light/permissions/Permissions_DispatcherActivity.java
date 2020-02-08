package com.gr.light.permissions;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.gr.light.R;
import com.gr.light.activity.BaseActivity;

import java.io.File;
import java.security.Permission;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;


@RuntimePermissions
public class Permissions_DispatcherActivity extends BaseActivity {

    @BindView(R.id.call_permissions_dispatcher_btn)
    Button callPermissionsDispatcherBtn;
    @BindView(R.id.camera_permissions_dispatcher_btn)
    Button cameraPermissionsDispatcherBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_permissions__dispatcher;
    }

    @OnClick({R.id.call_permissions_dispatcher_btn, R.id.camera_permissions_dispatcher_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.call_permissions_dispatcher_btn:
                Permissions_DispatcherActivityPermissionsDispatcher.callWithPermissionCheck(Permissions_DispatcherActivity.this);
                break;
            case R.id.camera_permissions_dispatcher_btn:
                startActivity(new Intent(Permissions_DispatcherActivity.this,CameraPermissionsActivity.class));
                break;
        }
    }

    //在需要获取权限的地方注释
    @NeedsPermission(Manifest.permission.CALL_PHONE)
    void call() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri data = Uri.parse("tel:" + "10086");
        intent.setData(data);
        try {
            startActivity(intent);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    // 提示用户为何开启此权限
    @OnShowRationale(Manifest.permission.CALL_PHONE)
    void showWhyCall(final PermissionRequest request){
        new AlertDialog.Builder(this)
                .setMessage("提示用户为何要开启此权限")
                .setPositiveButton("知道了", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        request.proceed();
                    }})
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        request.cancel();//取消执行请求
                    }})
                .show();
    }

    //用户选择拒绝时的提示
    @OnPermissionDenied(Manifest.permission.CALL_PHONE)
    void showDeniedCall() {
        Toast.makeText(this, "用户选择拒绝时的提示", Toast.LENGTH_SHORT).show();
    }

    //用户选择不再询问后的提示
    @OnNeverAskAgain(Manifest.permission.CALL_PHONE)
    void showNotAskCall() {
        new AlertDialog.Builder(this)
                .setMessage("该功能需要访问电话的权限，不开启将无法正常工作！")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Permissions_DispatcherActivityPermissionsDispatcher.onRequestPermissionsResult(this,requestCode,grantResults);
    }




}
