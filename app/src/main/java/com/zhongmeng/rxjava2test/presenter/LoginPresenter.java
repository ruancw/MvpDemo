package com.zhongmeng.rxjava2test.presenter;

/**
 * author :rcw.
 * date :2017/10/11 10:54.
 * presenter的接口
 */

public interface LoginPresenter {
    void login();//RxJava注册和modle数据处理
    void destory();//取消Rxjava,防止内存溢出
}
