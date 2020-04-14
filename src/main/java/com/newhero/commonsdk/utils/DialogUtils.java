package com.newhero.commonsdk.utils;


import android.content.Context;

import com.newhero.commonsdk.core.CommonDialogListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @version ${VERSION}
 * @decpter
 */
public class DialogUtils {

    private volatile static DialogUtils instances;
    private CommonDialogListener mListener;
    private List<String> idList;
    private boolean cancelable;

    private DialogUtils() {

    }

    public void setListener(CommonDialogListener listener) {
        this.mListener = listener;
    }

    public static DialogUtils getInstances() {
        if (instances == null) {
            synchronized (DialogUtils.class) {
                if (instances == null) {
                    instances = new DialogUtils();
                }
            }
        }
        return instances;
    }


    public void showDialog(boolean cancelable) {
        if (mListener != null) {
            mListener.show(cancelable);
        }
    }

    public void showDialog(String id,boolean cancelable) {
        if (idList == null) {
            idList = new ArrayList<>();
        }
        idList.add(id);
        showDialog(cancelable);
    }

    public void showDialogForUpload(Context context) {
        if (mListener != null) {
            mListener.showForUpload(context);
        }
    }

    public void cancel() {
        if (mListener != null) {
            mListener.cancel();
        }
    }

    public void cancel(String id) {
        if (idList.contains(id)) {
            idList.remove(id);
        }
        if (idList != null && idList.size() == 0) {
            cancel();
            idList = new ArrayList<>();
        }
    }
}
