package com.zhongmeng.rxjava2test;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.zhongmeng.rxjava2test.adapter.NoticeAdapter;
import com.zhongmeng.rxjava2test.adapter.WorkNoticeAdapter;
import com.zhongmeng.rxjava2test.bean.Banner;
import com.zhongmeng.rxjava2test.bean.BaseBean;
import com.zhongmeng.rxjava2test.bean.Notice;
import com.zhongmeng.rxjava2test.bean.Work;
import com.zhongmeng.rxjava2test.presenter.HomePresenter;
import com.zhongmeng.rxjava2test.presenter.HomePresenterImpl;
import com.zhongmeng.rxjava2test.utils.LogUtils;
import com.zhongmeng.rxjava2test.utils.NetworkImageHolderView;
import com.zhongmeng.rxjava2test.utils.SaveUserInfo;
import com.zhongmeng.rxjava2test.utils.UIUtils;
import com.zhongmeng.rxjava2test.view.HomeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity implements HomeView {

    @BindView(R.id.text_title)
    TextView mTitle;
    @BindView(R.id.button_backward)
    Button buttonBackward;
    @BindView(R.id.banner)
    ConvenientBanner mBanner;
    @BindView(R.id.more)
    ImageView more;
    @BindView(R.id.notice_recyclerview)
    RecyclerView noticeRecyclerview;
    @BindView(R.id.work_rccyclerview)
    RecyclerView workRccyclerview;

    private HomePresenter homePresenter;

    private List<String> networkImages;
    //private LoadingDialog loadingDialog;

    private NoticeAdapter noticeAdapter;
    private WorkNoticeAdapter workAdapter;
    private List<Notice.NoticeListBean> noticeBean = new ArrayList<>();
    private ArrayList<Notice.NoticeListBean> noticeListBean;
    private Context context;
    private String platType;

    private final int BANNER_WHICH = 1;
    private final int NOTICE_WHICH = 2;
    private final int WORK_WHICH = 3;
    private final int QINIU_WHICH = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mTitle.setText("首页");
        buttonBackward.setVisibility(View.INVISIBLE);
        platType = SaveUserInfo.getInstance().getType();
        networkImages = new ArrayList<>();
        //loadingDialog = new LoadingDialog(context);

        homePresenter = new HomePresenterImpl(this);
        homePresenter.getNoticeInfo(NOTICE_WHICH);
        homePresenter.getBannerUrls(BANNER_WHICH);
        homePresenter.getQiuniuToken(QINIU_WHICH);


        if (!platType.equals("1")) {//不为1时，加载待办工作数据
            homePresenter.getWorkInfo(WORK_WHICH);
        }

    }

    private void initBanner() {
        //网络加载例子
        //networkImages = Arrays.asList(images);
        LogUtils.z("networkImages.size()=" + networkImages.size());
        if (networkImages.size() != 0) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mBanner
                            .setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
                                @Override
                                public NetworkImageHolderView createHolder() {
                                    return new NetworkImageHolderView();
                                }
                            }, networkImages)
                            //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                            .setPageIndicator(new int[]{R.drawable.point_select, R.drawable.point_normal})
                            //设置指示器的方向
                            .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
                }
            }, 10);
        }


    }

    // 开始自动翻页
    @Override
    public void onResume() {
        super.onResume();
        //开始自动翻页
        mBanner.startTurning(2000);
    }

    // 停止自动翻页
    @Override
    public void onPause() {
        super.onPause();
        //停止翻页
        mBanner.stopTurning();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        homePresenter.onDestory();
    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }


    @Override
    public void onSuccess(Object data, int which) {
        int code;
        switch (which) {
            case BANNER_WHICH:
                Banner banner = (Banner) data;
                code = banner.getCode();
                LogUtils.z("bannercode=" + code);
                if (code == 200 && banner != null) {
                    List<Banner.ImgListBean> bannerData = banner.getImgList();
                    LogUtils.z("bannerData=" + bannerData.size());
                    for (Banner.ImgListBean imgListBean : bannerData) {
                        LogUtils.z(imgListBean.getUrl());
                        networkImages.add(imgListBean.getUrl());
                    }
                    initBanner();
                } else UIUtils.toast(banner.getMessage());
                break;
            case NOTICE_WHICH:
                Notice notice = (Notice) data;
                code = notice.getCode();
                LogUtils.z("noticecode=" + code);
                if (code == 200) {
                    noticeListBean = notice.getNoticeList();
                    if (noticeListBean.size() > 4) {
                        more.setVisibility(View.VISIBLE);
                        for (int i = 0; i < 4; i++) {
                            noticeBean.add(noticeListBean.get(i));
                        }
                    }
                    noticeAdapter = new NoticeAdapter(this, R.layout.notice_recycler_item, noticeBean);
                    noticeRecyclerview.setLayoutManager(new LinearLayoutManager(context));
                    noticeRecyclerview.setAdapter(noticeAdapter);
                } else UIUtils.toast(notice.getMessage());
                break;
            case WORK_WHICH:
                break;
            case QINIU_WHICH:
                BaseBean baseBean = (BaseBean) data;
                LogUtils.z("code=" + baseBean.getCode());
                if (baseBean.getCode() == 200) {
                    LogUtils.z("qiniu=" + baseBean.getUpToken());
                }
                break;
        }

    }

    @Override
    public void onFail(Throwable throwable) {
        UIUtils.toast(throwable.getMessage());
        LogUtils.z(throwable.getMessage());
    }
}
