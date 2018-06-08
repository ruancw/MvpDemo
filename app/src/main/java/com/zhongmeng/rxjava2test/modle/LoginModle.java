package com.zhongmeng.rxjava2test.modle;


import com.zhongmeng.rxjava2test.bean.LoginBean;

import io.reactivex.disposables.Disposable;

/**
 * author :rcw.
 * date :2017/10/11 11:01.
 * 通过Rxjava获取网络数据的modle接口
 */

public interface LoginModle {
    /**
     *
     * @param username 用户账号
     * @param password 用户密码
     * @return 返回类型为RxJava的subscription
     */
    Disposable login(String username, String password);

    /**
     * 网络请求成功/失败监听的接口
     * 内部类
     */
    interface OnLoginListener{
        void loginSuccess(LoginBean loginBean);
        void loginFail(Throwable throwable);
    }
}
