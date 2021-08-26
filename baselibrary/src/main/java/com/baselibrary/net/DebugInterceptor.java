package com.baselibrary.net;



import android.content.Context;

import androidx.annotation.RawRes;


import com.baselibrary.utils.FileUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Debug拦截器
 */
public class DebugInterceptor implements Interceptor {

    private final String DEBUG_URL;
    private final int DEBUG_RAW_ID;
    private Context mContext;

    public DebugInterceptor(String debug_url, int debug_raw_id,Context context) {
        DEBUG_URL = debug_url;
        DEBUG_RAW_ID = debug_raw_id;
        mContext=context;
    }

    private Response getResponse(Interceptor.Chain chain, String json) {
        return new Response.Builder()
                .code(200)
                .addHeader("Content-Type", "application/json")
                .body(ResponseBody.create(MediaType.parse("application/json"), json))
                .request(chain.request())
                .message("ok")
                .protocol(Protocol.HTTP_1_1)
                .build();
    }

    private Response debugResponse(Interceptor.Chain chain, @RawRes int rawId) {
        final String json = FileUtils.getRawFile(mContext,rawId);
        return getResponse(chain, json);
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        final String url = chain.request().url().toString();
        if (url.contains(DEBUG_URL)) {
            return debugResponse(chain, DEBUG_RAW_ID);
        }
        return chain.proceed(chain.request());
    }
}

