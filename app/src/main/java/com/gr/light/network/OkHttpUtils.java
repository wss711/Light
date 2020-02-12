package com.gr.light.network;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-12
 **/
public final class OkHttpUtils {

//    private final static OkHttpClient mOkHttpClient = new OkHttpClient();
    private static Response mResponse;
    /**
     * TODO Synchronous Get
     *
     * Download a file, print its headers, and print its response body as a string.
     *
     * The string() method on response body is convenient and efficient for small documents.
     * But if the response body is large (greater than 1 MiB), avoid string() because it will
     * load the entire document into memory. In that case, prefer to process the body as a stream.
     * @param
     * @return
     * @author WSS
     * @time 2020-02-12 13:57
     **/
    public static void syncGet(OkHttpClient client,Request request){


        try{
            Response response = client.newCall(request).execute();
            if(response.isSuccessful()){
                mResponse = response;

            }else {
                throw new IOException("Unexpected code " + response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * TODO Asynchronous Get
     *
     *  Download a file on a worker thread, and get called back when the response is readable.
     *
     *  The callback is made after the response headers are ready.
     *  Reading the response body may still block. OkHttp doesn’t currently offer asynchronous
     *  APIs to receive a response body in parts.
     *
     * @param
     * @return 
     * @author WSS
     * @time 2020-02-12 14:45
     **/
    public static Response asyncGet(OkHttpClient client,Request request) throws Exception{

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                if(response.isSuccessful()) {
                    mResponse = response;
                }else{
                    throw new IOException("Unexpected code " + response);
                }
            }
        });

        return mResponse;
    }



}
