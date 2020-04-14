package com.newhero.commonsdk.utils;

import android.content.Context;

/**
 * Created by dell on 2018/3/19.
 */

public class CheckTimeOutUtil {
    public static boolean isTimeOut(Context context){
        if ( System.currentTimeMillis()>Long.valueOf(SharedPreferencesUtils.getParam(context,"timeOut","0").toString()) -3600000){
            DebugUtil.show("距离超时时间小于1小时");
            return true;
        }else{
            DebugUtil.show("距离超时时间大于1小时");
            return false;
        }
    }
}
