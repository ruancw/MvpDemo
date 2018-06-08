package com.zhongmeng.rxjava2test.modle;


import com.zhongmeng.rxjava2test.bean.Banner;
import com.zhongmeng.rxjava2test.bean.BaseBean;
import com.zhongmeng.rxjava2test.bean.Notice;
import com.zhongmeng.rxjava2test.bean.Work;
import com.zhongmeng.rxjava2test.retrofit.ApiServiceManager;
import com.zhongmeng.rxjava2test.utils.SaveUserInfo;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * author :rcw.
 * date :2017/10/12 11:12.
 */

public class HomeModleImpl implements HomeModle {

    private OnRequestListener onRequestListener;

    public HomeModleImpl(OnRequestListener onRequestListener) {
        this.onRequestListener = onRequestListener;
    }


    @Override
    public <T> Disposable getObservable(Observable<T> observable, final int which) {
        Disposable disposable=observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<T>() {
                    @Override
                    public void accept(T data) throws Exception {
                        if (onRequestListener!=null){
                            onRequestListener.onRequestSuccess(data,which);
                        }
                    }

                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (onRequestListener!=null){
                            onRequestListener.onRequestFail(throwable);
                        }
                    }
                });
        return disposable;
    }

}
