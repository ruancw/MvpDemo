package com.zhongmeng.rxjava2test.presenter;


import com.zhongmeng.rxjava2test.base.BasePresenter;
import com.zhongmeng.rxjava2test.bean.Banner;
import com.zhongmeng.rxjava2test.bean.BaseBean;
import com.zhongmeng.rxjava2test.bean.Notice;
import com.zhongmeng.rxjava2test.bean.Work;
import com.zhongmeng.rxjava2test.modle.HomeModle;
import com.zhongmeng.rxjava2test.modle.HomeModleImpl;
import com.zhongmeng.rxjava2test.retrofit.ApiServiceManager;
import com.zhongmeng.rxjava2test.utils.LogUtils;
import com.zhongmeng.rxjava2test.utils.SaveUserInfo;
import com.zhongmeng.rxjava2test.utils.UIUtils;
import com.zhongmeng.rxjava2test.view.HomeView;

/**
 * author :rcw.
 * date :2017/10/12 11:21.
 */

public class HomePresenterImpl extends BasePresenter implements HomePresenter,HomeModle.OnRequestListener {
    private String areacode= SaveUserInfo.getInstance().getAreaCode();
    private String unitcode= SaveUserInfo.getInstance().getUnitCode();
    private HomeView homeView;
    private HomeModle homeModle;
    public HomePresenterImpl(HomeView homeView) {
        this.homeView = homeView;
        homeModle=new HomeModleImpl(this);
    }

    @Override
    public void getBannerUrls(int which) {
        homeView.showProgress();
        addSubscription(homeModle.getObservable(ApiServiceManager.getInstance().getBannerUrl(),which));
    }

    @Override
    public void getWorkInfo(int which) {
        addSubscription(homeModle.getObservable(ApiServiceManager.getInstance().getWorkInfo(areacode),which));
    }

    @Override
    public void getNoticeInfo(int which) {
        //homeView.showProgress();
        addSubscription(homeModle.getObservable(ApiServiceManager.getInstance().getNoticeInfo("1","1","10",areacode),which));
    }

    @Override
    public void getQiuniuToken(int which) {
        addSubscription(homeModle.getObservable(ApiServiceManager.getInstance().getQiuniuToken(),which));
    }

    @Override
    public void onDestory() {
        onUnsubscribe();
        if (homeView!=null){
            homeView=null;
        }
    }

    @Override
    public void onRequestSuccess(Object data, int which) {
        if (homeView!=null){
            homeView.hideProgress();
            homeView.onSuccess(data,which);
        }
    }

    @Override
    public void onRequestFail(Throwable throwable) {
        if (homeView!=null){
            homeView.hideProgress();
            homeView.onFail(throwable);
        }
    }
}
