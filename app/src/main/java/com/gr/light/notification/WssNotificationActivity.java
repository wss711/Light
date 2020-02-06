package com.gr.light.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RemoteViews;
import android.widget.TextView;

import com.gr.light.R;
import com.gr.light.activity.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class WssNotificationActivity extends BaseActivity {

    @BindView(R.id.nomal_notification_tv)
    TextView nomalNotificationTv;
    @BindView(R.id.fold_notification_tv)
    TextView foldNotificationTv;
    @BindView(R.id.hang_notification_tv)
    TextView hangNotificationTv;
    @BindView(R.id.rb_public)
    RadioButton rbPublic;
    @BindView(R.id.rb_private)
    RadioButton rbPrivate;
    @BindView(R.id.rb_secret)
    RadioButton rbSecret;
    @BindView(R.id.all_rg)
    RadioGroup allRg;

    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wss_notification;
    }

    @OnClick({R.id.nomal_notification_tv, R.id.fold_notification_tv, R.id.hang_notification_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nomal_notification_tv:
                sendNormalNotification();
                break;
            case R.id.fold_notification_tv:
                sendFoldNotification();
                break;
            case R.id.hang_notification_tv:
                sendHangNotification();
                break;
        }
    }

    private void initView(){
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }
    private void sendNormalNotification(){
        Notification.Builder builder = new Notification.Builder(this);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baidu.com/"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.drawable.lanucher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.lanucher));
        builder.setAutoCancel(true);
        builder.setContentTitle("普通通知");
        selectNotofovatiomLevel(builder);
        notificationManager.notify(0,builder.build());
    }

    private void sendFoldNotification(){
        Notification.Builder builder = new Notification.Builder(this);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baidu.com/"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.drawable.foldleft);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.lanucher));
        builder.setAutoCancel(true);
        builder.setContentTitle("折叠式通知");
        selectNotofovatiomLevel(builder);
        //用RemoteViews来创建自定义Notification视图
        RemoteViews remoteViews = new RemoteViews(getPackageName(),R.layout.view_fold);
        Notification notification = builder.build();
        //指定展开时的视图
        notification.bigContentView = remoteViews;
        notificationManager.notify(1,notification);
    }

    private void sendHangNotification() {
        Notification.Builder builder = new Notification.Builder(this);
        Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baidu.com/"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, mIntent, 0);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.drawable.foldleft);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.lanucher));
        builder.setAutoCancel(true);
        builder.setContentTitle("悬挂式通知");
        selectNotofovatiomLevel(builder);
        //设置点击跳转
        Intent hangIntent = new Intent();
        hangIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        hangIntent.setClass(this, WssNotificationActivity.class);
        //如果描述的PendingIntent已经存在，则在产生新的Intent之前会先取消掉当前的
        PendingIntent hangPendingIntent = PendingIntent.getActivity(this, 0, hangIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setFullScreenIntent(hangPendingIntent, true);

        notificationManager.notify(2, builder.build());
    }
    private void selectNotofovatiomLevel(Notification.Builder builder){
        switch (allRg.getCheckedRadioButtonId()){
            case R.id.rb_public:
                builder.setVisibility(Notification.VISIBILITY_PUBLIC);
                builder.setContentText("public");
                break;
            case R.id.rb_private:
                builder.setVisibility(Notification.VISIBILITY_PRIVATE);
                builder.setContentText("private");
                break;
            case R.id.rb_secret:
                builder.setVisibility(Notification.VISIBILITY_SECRET);
                builder.setContentText("secret");
                break;
            default:
                break;
        }
    }
}
