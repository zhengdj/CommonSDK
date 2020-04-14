package com.newhero.commonsdk.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zdj on 2018/1/30.
 */

public class MobileUtil {
    //    //使用正则表达式判断电话号码
    public static boolean isMobileNO(String tel) {
//        Pattern p = Pattern.compile("^(13[0-9]|15([0-3]|[5-9])|14[5,7,9]|17[1,3,5,6,7,8]|18[0-9])\\d{8}$");
        Pattern p = Pattern.compile("^(13|15|14|17|18|19)\\d{9}$");
        Matcher m = p.matcher(tel);
        System.out.println(m.matches() + "---");
        return m.matches();
    }
}
