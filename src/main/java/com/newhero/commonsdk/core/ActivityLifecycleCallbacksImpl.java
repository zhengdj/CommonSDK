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

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.jess.arms.utils.ArmsUtils;
import com.umeng.analytics.MobclickAgent;

import timber.log.Timber;

/**
 * ================================================
 * Created by JessYan on 02/04/2018 15:15
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public class ActivityLifecycleCallbacksImpl implements Application.ActivityLifecycleCallbacks {
    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Timber.w(activity + " - onActivityCreated");
    }

    @Override
    public void onActivityStarted(final Activity activity) {
        Timber.w(activity + " - onActivityStarted");
        if (!activity.getIntent().getBooleanExtra("isInitToolbar", false)) {
            //由于加强框架的兼容性,故将 setContentView 放到 onActivityCreated 之后,onActivityStarted 之前执行
            //而 findViewById 必须在 Activity setContentView() 后才有效,所以将以下代码从之前的 onActivityCreated 中移动到 onActivityStarted 中执行
            activity.getIntent().putExtra("isInitToolbar", true);
            //这里全局给Activity设置toolbar和title,你想象力有多丰富,这里就有多强大,以前放到BaseActivity的操作都可以放到这里
            if (ArmsUtils.findViewByName(activity.getApplicationContext(), activity, "public_toolbar") != null) {
                if (activity instanceof AppCompatActivity) {
                    ((AppCompatActivity) activity).setSupportActionBar((Toolbar) ArmsUtils.findViewByName(activity.getApplicationContext(), activity, "public_toolbar"));
                    ((AppCompatActivity) activity).getSupportActionBar().setDisplayShowTitleEnabled(false);
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        activity.setActionBar((android.widget.Toolbar) ArmsUtils.findViewByName(activity.getApplicationContext(), activity, "public_toolbar"));
                        activity.getActionBar().setDisplayShowTitleEnabled(false);
                    }
                }
            }
            if (ArmsUtils.findViewByName(activity.getApplicationContext(), activity, "public_toolbar_title") != null) {
                String contextString = activity.toString();
                String activityName = contextString.substring(contextString.lastIndexOf(".") + 1, contextString.indexOf("@"));
                boolean setTitleActivity = true;
                for(String notSetTitleActivity:Constants.NOT_SET_TITLE_ACTIVITY_LIST){
                    if(activityName.equals(notSetTitleActivity)){
                        setTitleActivity = false;
                    }
                }
                if(setTitleActivity){
                    ((TextView) ArmsUtils.findViewByName(activity.getApplicationContext(), activity, "public_toolbar_title")).setText(activity.getTitle());
                }
            }
            if (ArmsUtils.findViewByName(activity.getApplicationContext(), activity, "public_toolbar_back") != null) {
                ArmsUtils.findViewByName(activity.getApplicationContext(), activity, "public_toolbar_back").setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        activity.onBackPressed();
                    }
                });
            }
        }
    }

    @Override
    public void onActivityResumed(Activity activity) {
        Timber.w(activity + " - onActivityResumed");
        MobclickAgent.onResume(activity);
    }

    @Override
    public void onActivityPaused(Activity activity) {
        Timber.w(activity + " - onActivityPaused");
        MobclickAgent.onPause(activity);
    }

    @Override
    public void onActivityStopped(Activity activity) {
        Timber.w(activity + " - onActivityStopped");
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Timber.w(activity + " - onActivitySaveInstanceState");
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Timber.w(activity + " - onActivityDestroyed");
        //横竖屏切换或配置改变时, Activity 会被重新创建实例, 但 Bundle 中的基础数据会被保存下来,移除该数据是为了保证重新创建的实例可以正常工作
        activity.getIntent().removeExtra("isInitToolbar");
    }
}
