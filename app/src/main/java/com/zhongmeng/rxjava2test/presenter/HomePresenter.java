package com.zhongmeng.rxjava2test.presenter;

/**
 * author :rcw.
 * date :2017/10/12 11:20.
 */

public interface HomePresenter {
    void getBannerUrls(int which);
    void getWorkInfo(int which);
    void getNoticeInfo(int which);
    void getQiuniuToken(int which);
    void onDestory();
}
