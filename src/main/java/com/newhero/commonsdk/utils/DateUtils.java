package com.newhero.commonsdk.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zdj on 2018/7/1.
 */
public class DateUtils {


    public static String getDateToString(long time, SimpleDateFormat sf) {
        Date d = new Date(time);
        return sf.format(d);
    }

    public static String getTodayDateStr(Date date,SimpleDateFormat sdf) {
        SimpleDateFormat todaySdf = new SimpleDateFormat("yyyy-MM-dd");
        String todayStr = todaySdf.format(date);
        try {
            todayStr = todayStr + " 00:00";
            Date todayDate = sdf.parse(todayStr);
            todayStr = sdf.format(todayDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return todayStr;
    }


    public static Date getStringToDate(String str,SimpleDateFormat sdf) {
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    public static long stringToLong(String str,SimpleDateFormat sdf) {
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date == null) {
            return 0;
        } else {
            long currentTime = date.getTime(); // date类型转成long类型
            return currentTime;
        }
    }


}
