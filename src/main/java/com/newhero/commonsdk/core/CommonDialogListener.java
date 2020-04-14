package com.newhero.commonsdk.core;

import android.content.Context;

/**
 *
 * @version ${VERSION}
 * @decpter
 */
public interface CommonDialogListener {
    void showForUpload(Context context);
    void show(boolean cancelable);
    void cancel();
}
