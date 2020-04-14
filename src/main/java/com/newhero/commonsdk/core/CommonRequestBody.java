package com.newhero.commonsdk.core;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import okio.BufferedSink;

/**
 * Created by dell on 2018/5/17.
 */

public class CommonRequestBody extends RequestBody {

    private RequestBody mRequestBody;
    private String body;
    byte[] bytes;

    public CommonRequestBody(String body) {
        this.mRequestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), body);
        this.body = body;
        bytes = body.getBytes(Util.UTF_8);
    }


    @Override
    public MediaType contentType() {
        return mRequestBody.contentType();
    }

    @Override
    public long contentLength() throws IOException {
        return mRequestBody.contentLength();
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {
        sink.write(bytes);
    }
}
