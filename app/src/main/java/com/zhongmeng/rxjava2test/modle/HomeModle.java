package com.zhongmeng.rxjava2test.modle;


import com.zhongmeng.rxjava2test.bean.Banner;
import com.zhongmeng.rxjava2test.bean.BaseBean;
import com.zhongmeng.rxjava2test.bean.Notice;
import com.zhongmeng.rxjava2test.bean.Work;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * author :rcw.
 * date :2017/10/12 11:10.
 */

public interface HomeModle {
    <T>Disposable getObservable(Observable<T> observable,int which);
    interface OnRequestListener<T>{
        void onRequestSuccess(T data,int which);
        void onRequestFail(Throwable throwable);
    }
}
