package com.gr.light.permissions;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import com.gr.light.R;
import com.gr.light.activity.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class PermissionsActivity extends BaseActivity {

    @BindView(R.id.call_permissions_btn)
    Button callPermissionsBtn;
    @BindView(R.id.call_permissionsdispatcher_btn)
    Button callPermissionsdispatcherBtn;

    private static final int PERMISSIONS_REQUEST_CALL_PHONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_permissions;
    }


    @OnClick({R.id.call_permissions_btn, R.id.call_permissionsdispatcher_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.call_permissions_btn:
                Log.i("Light","call_permissions_btn");
                call();
                break;
            case R.id.call_permissionsdispatcher_btn:
                startActivity(new Intent(PermissionsActivity.this,Permissions_DispatcherActivity.class));
                break;
        }
    }

    public void call(){
        //检查App是否有permission.CALL_PHONE的权限
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            //如果没有permission.CALL_PHONE的权限的就申请该权限
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    PERMISSIONS_REQUEST_CALL_PHONE);
        }else {
            callPhone();
        }
    }

    public void callPhone(){

        Log.i("Light","callPhone");

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        Uri data = Uri.parse("tel:10086");
        intent.setData(data);
        try {
            startActivity(intent);
            Log.i("Light","startActivity(intent)");
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_CALL_PHONE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                callPhone();
            } else {
                // 帮助开发者向用户解释权限的情况
                if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {
                    AlertDialog dialog = new AlertDialog.Builder(this)
                            .setMessage("该功能需要访问电话的权限，不开启将无法正常工作！")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            }).create();
                    dialog.show();
                }
                return;
            }
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
