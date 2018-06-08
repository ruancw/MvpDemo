package com.zhongmeng.rxjava2test.base;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * author :rcw.
 * date :2017/10/20 15:34.
 */

public interface BaseModle {
    <T>Disposable getObservable(Observable<T> observable);
    interface OnRegisterRequestListener<T>{
        void onRequestSuccess(T data,int which);
        void onRequestFail(Throwable throwable);
    }
}
