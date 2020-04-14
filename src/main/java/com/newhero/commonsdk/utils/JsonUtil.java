package com.newhero.commonsdk.utils;

import android.content.Context;

import com.jess.arms.utils.ArmsUtils;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by zdj on 2017/2/28.
 */

public class JsonUtil {
    public static JSONObject getJSONObject(Context context, String response, boolean toast) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            boolean success = jsonObject.getBoolean("success");
            String msg = jsonObject.getString("msg");
            if (success) {
                if (toast) {
                    ArmsUtils.makeText(context, msg);
                }
                return jsonObject.getJSONObject("data");
            } else {
                ArmsUtils.makeText(context, msg);
            }
        } catch (Exception e) {

        }
        return null;
    }


    public static JSONArray getJSONArray(Context context, String response, boolean toast) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            boolean success = jsonObject.getBoolean("success");
            String msg = jsonObject.getString("msg");
            if (success) {
                if (toast) {
                    ArmsUtils.makeText(context, msg);
                }
                return jsonObject.getJSONArray("data");
            } else {
                ArmsUtils.makeText(context, msg);
            }
        } catch (Exception e) {

        }
        return null;
    }

    public static String getString(Context context, String response, boolean toast) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            boolean success = jsonObject.getBoolean("success");
            String msg = jsonObject.getString("msg");
            if (success) {
                if (toast) {
                    ArmsUtils.makeText(context, msg);
                }
                return jsonObject.getString("data");
            } else {
                ArmsUtils.makeText(context, msg);
            }
        } catch (Exception e) {

        }
        return null;
    }

    @Deprecated
    //无需建议使用getmsg( String response)
    public static String getmsg(Context context, String response) {
        String msg = "";
        try {
            JSONObject jsonObject = new JSONObject(response);
            boolean success = jsonObject.getBoolean("success");
            msg = jsonObject.getString("msg");
        } catch (Exception e) {

        }
        return msg;
    }

    public static String getmsg( String response) {
        String msg = "";
        try {
            JSONObject jsonObject = new JSONObject(response);
            boolean success = jsonObject.getBoolean("success");
            msg = jsonObject.getString("msg");
        } catch (Exception e) {

        }
        return msg;
    }

    public static int getRecordsTotal(Context context, String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            boolean success = jsonObject.getBoolean("success");
            String msg = jsonObject.getString("msg");
            if (success) {
                return jsonObject.getInt("recordsTotal");
            } else {
                ArmsUtils.makeText(context, msg);
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public static Boolean getSuccess(Context context, String response) {
        String msg = "网络异常";
        boolean success = false;
        try {
            JSONObject jsonObject = new JSONObject(response);
            success = jsonObject.getBoolean("success");
            msg = jsonObject.getString("msg");
            if (!success) {
                ArmsUtils.makeText(context, msg);
            }
        } catch (Exception e) {

        }
        return success;
    }


    public static String getmsg2(Context context, String response) {
        String msg = "请先登录";
        try {
            JSONObject jsonObject = new JSONObject(response);
            String returnCode = jsonObject.getString("returnCode");
            msg = jsonObject.getString("returnMessage");
        } catch (Exception e) {

        }
        return msg;
    }

    public static boolean getSuccess2(Context context, String response) {
        String msg = "网络异常";
        boolean success = false;
        try {
            JSONObject jsonObject = new JSONObject(response);
            String returnCode = jsonObject.getString("returnCode");
            if (returnCode.equals("1")) {
                success = true;
            }
        } catch (Exception e) {

        }
        return success;
    }

    public static String getError(Context context, String response) {
        String msg = "";
        try {
            JSONObject jsonObject = new JSONObject(response);
            msg = jsonObject.getString("error");
        } catch (Exception e) {

        }
        return msg;
    }

}
