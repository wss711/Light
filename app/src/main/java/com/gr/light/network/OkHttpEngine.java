package com.gr.light.network;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-13
 **/
public class OkHttpEngine {

    private OkHttpClient mOkHttpClient;
    private Handler mHandler;

    private OkHttpEngine(){

    }

    public static OkHttpEngine getInstance(NetworkActivity networkActivity){
        return OkHttpEngineHolder.mInstance;
    }

    private static class OkHttpEngineHolder{
        private static final OkHttpEngine mInstance = new OkHttpEngine();
    }


    /**
     * TODO OkHttpEngine异步请求
     *
     * @param
     * @return
     * @author WSS
     * @time 2020-02-13 15:48
     **/
    public void getAsyncHttp(Context context,String url,ResultCallback callback){

        File sdcache = context.getExternalCacheDir();
        int cacheSize = 10 * 1024 * 1024;
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .cache(new Cache(sdcache.getAbsoluteFile(), cacheSize));
        mOkHttpClient = builder.build();
        mHandler = new Handler();

        final Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = mOkHttpClient.newCall(request);

        dealResult(call,callback);

    }

    private void dealResult(Call call,final ResultCallback callback){
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                sendFailedCallback(call.request(),e,callback);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                sendSuccessCallback(response.body().string(),callback);
            }


            private void sendSuccessCallback(final String str,final ResultCallback callback){
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(callback != null){
                            try {
                                callback.onResponse(str);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }

            private void sendFailedCallback(final Request request,final Exception e,final ResultCallback callback){
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(callback != null){
                            callback.onError(request,e);
                        }
                    }
                });
            }

        });
    }

    /**
     * TODO 获取Http Headers
     *
     * @param
     * @return
     * @author WSS
     * @time 2020-02-13 16:07
     **/

}
