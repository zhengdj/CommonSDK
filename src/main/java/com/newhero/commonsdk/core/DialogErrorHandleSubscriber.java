package com.newhero.commonsdk.core;




import com.newhero.commonsdk.utils.DialogUtils;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DefaultObserver;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandlerFactory;

public abstract class DialogErrorHandleSubscriber <T> extends DefaultObserver<T> {
    private ErrorHandlerFactory mHandlerFactory;
    boolean showDialog = true;
    private String id;
    private  boolean cancelable;

    public DialogErrorHandleSubscriber(RxErrorHandler rxErrorHandler){
        this.mHandlerFactory = rxErrorHandler.getHandlerFactory();
        this.cancelable = true;
    }

    public DialogErrorHandleSubscriber(RxErrorHandler rxErrorHandler,boolean showDialog){
        this.mHandlerFactory = rxErrorHandler.getHandlerFactory();
        this.showDialog = showDialog;
        this.cancelable = true;
    }
    public DialogErrorHandleSubscriber(RxErrorHandler rxErrorHandler,boolean showDialog,boolean cancelable){
        this.mHandlerFactory = rxErrorHandler.getHandlerFactory();
        this.showDialog = showDialog;
        this.cancelable = cancelable;
    }

    @Override
    public void onNext(T t)  {

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(showDialog){
            DialogUtils.getInstances().showDialog(this.toString(),cancelable);
        }
    }

    @Override
    public void onComplete() {
        if(showDialog) {
            DialogUtils.getInstances().cancel(this.toString());
        }
    }


    @Override
    public void onError(@NonNull Throwable t) {
        DialogUtils.getInstances().cancel(this.toString());
//        DialogUtils.getInstances().cancel();
        t.printStackTrace();
        //如果你某个地方不想使用全局错误处理,则重写 onError(Throwable) 并将 super.onError(e); 删掉
        //如果你不仅想使用全局错误处理,还想加入自己的逻辑,则重写 onError(Throwable) 并在 super.onError(e); 后面加入自己的逻辑
        mHandlerFactory.handleError(t);
    }
}

