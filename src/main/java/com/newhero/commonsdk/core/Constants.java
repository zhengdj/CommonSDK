/*
 * Copyright 2018 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.newhero.commonsdk.core;

import java.util.ArrayList;
import java.util.List;

/**
 * ================================================
 * CommonSDK 的 Constants 可以定义公用的常量, 比如关于业务的常量或者正则表达式, 每个组件的 Constants 可以定义组件自己的私有常量
 * <p>
 * Created by JessYan on 30/03/2018 17:32
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public class Constants {
    public static String TOKEN = "";
    public static String USERID = "";
    public static String userIdentity = "";
    public static String BASEURL = "";
    public static String BASEURLFORLOGIN = "";
    /**
     * ================================================
     * 有关版本更新的内容 静态变量的声明，其中对他们的赋值放在APP组件下的AppLifecyclesImpl的onCreate()方法中
     * ================================================
     */
    public static String DOWNLOAD_APK_NAME = "onlineMonitor";
    public static String BASEURLFORVERSION = "";
    public static String URLFORVERSION = "";


    public static List<String> NOT_SET_TITLE_ACTIVITY_LIST = new ArrayList<>();

    public static int INPUT_MAX_SHORT_LENGTH =30;
    public static int INPUT_MAX_MIDDLE_LENGTH =50;
    public static int INPUT_MAX_LONG_LENGTH = 200;
}
