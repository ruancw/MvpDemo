package com.zhongmeng.rxjava2test.view;


import com.zhongmeng.rxjava2test.base.BaseView;
import com.zhongmeng.rxjava2test.bean.LoginBean;

/**
 * 登录的用于展示信息的view
 * author :rcw.
 * date :2017/10/11 10:47.
 */

public interface LoginView extends BaseView {
    String getUserName();//获取登录名/账号
    String getPassWord();//获取登录密码
    void setUserNameError();//输入的账号为空
    void setPassWordError();//输入的密码为空
    void onFail(Throwable throwable);//请求失败
    void onSuccess(LoginBean loginBean);//请求成功（登录成功或失败）
}
