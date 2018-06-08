package com.zhongmeng.rxjava2test.view;


import com.zhongmeng.rxjava2test.base.BaseView;
import com.zhongmeng.rxjava2test.bean.Banner;
import com.zhongmeng.rxjava2test.bean.Notice;
import com.zhongmeng.rxjava2test.bean.Work;

/**
 * author :rcw.
 * date :2017/10/12 11:09.
 */

public interface HomeView<T> extends BaseView {
    void onSuccess(T data,int which);
    void onFail(Throwable throwable);
}
