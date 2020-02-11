package com.gr.light.network;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gr.light.R;
import com.gr.light.activity.BaseActivity;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkActivity extends BaseActivity {

    private static final String TAG="OkHttp3";

    @BindView(R.id.get_btn)
    Button getBtn;
    @BindView(R.id.post_btn)
    Button postBtn;
    @BindView(R.id.sendfile_btn)
    Button sendfileBtn;
    @BindView(R.id.downfile_btn)
    Button downfileBtn;
    @BindView(R.id.cancel_btn)
    Button cancelBtn;

    private OkHttpClient mOkHttpClient;
    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    public static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initOkHttpClient();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_network;
    }

    @OnClick({R.id.get_btn, R.id.post_btn, R.id.sendfile_btn, R.id.downfile_btn, R.id.cancel_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.get_btn:
                getAsyncHttp();
                break;
            case R.id.post_btn:
                break;
            case R.id.sendfile_btn:
                break;
            case R.id.downfile_btn:
                break;
            case R.id.cancel_btn:
                break;
        }
    }

    /**
     * TODO
     *
     * @param
     * @return
     * @author WSS
     * @time 2020-02-11 17:48
     **/
    private void initOkHttpClient(){
        File sdcache = getExternalCacheDir();
        int cacheSize = 10 * 1024 * 1024;
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .cache(new Cache(sdcache.getAbsoluteFile(),cacheSize));

        mOkHttpClient = builder.build();
    }

    /**
     * TODO GET 异步请求
     *
     * @param
     * @return
     * @author WSS
     * @time 2020-02-11 17:52
     **/
    private void getAsyncHttp(){
        Request.Builder requestBuilder = new Request.Builder().url("http://www.baidu.com");
        requestBuilder.method("GET", null);
        Request request = requestBuilder.build();
        Call mcall = mOkHttpClient.newCall(request);
        mcall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(getApplicationContext(), "请求失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                Log.i(TAG, str);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "请求成功", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }


}
