package com.newhero.commonsdk.utils;

import timber.log.Timber;

public class DebugUtil {
    // 使用Log来显示调试信息,因为log在实现上每个message有4k字符长度限制
    // 所以这里使用自己分节的方式来输出足够长度的message
    public static void show(String str) {
        if(null!=str) {
            str = str.trim();
            int index = 0;
            int maxLength = 3899;
            String sub;
            while (index < str.length()) {
                // java的字符不允许指定超过总的长度end
                if (str.length() <= maxLength) {
                    sub = str.substring(index);
                } else {
                    sub = str.substring(index, maxLength);
                }

                index = maxLength;
                maxLength += 3900;
                Timber.tag("monitor_debug").i(sub.trim());
            }
        }
    }
}