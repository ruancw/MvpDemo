package com.zhongmeng.rxjava2test.modle;



import com.zhongmeng.rxjava2test.bean.LoginBean;
import com.zhongmeng.rxjava2test.retrofit.ApiServiceManager;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.Observable;


import static io.reactivex.schedulers.Schedulers.io;

/**
 * author :rcw.
 * date :2017/10/11 11:04.
 * loginModle的实现类
 */

public class LoginModleImpl implements LoginModle {
    private OnLoginListener onLoginListener;//监听回调

    public LoginModleImpl(OnLoginListener onLoginListener) {
        this.onLoginListener = onLoginListener;
    }


    @Override
    public Disposable login(String username, String password) {
        Observable<LoginBean> observable= ApiServiceManager.getCallBackData("db9fe289c32eeda773db291f29d9d461",username,password);
        Disposable disposable=observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        if (onLoginListener!=null){
                            onLoginListener.loginSuccess(loginBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (onLoginListener!=null){
                            onLoginListener.loginFail(throwable);
                        }
                    }
                });

        return disposable;
    }
}
