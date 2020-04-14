package com.newhero.commonsdk.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

/**
 * Created by Administrator on 2017/3/2.
 */

public class ToJsonUtil {
    public static String toJson(Object object){
        Gson gson = null;
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new DateNewAdapter());
        gson = builder.create();
        String json = gson.toJson(object);
        return json;
    }
}
