package com.zhongmeng.rxjava2test.retrofit;


import com.zhongmeng.rxjava2test.bean.Banner;
import com.zhongmeng.rxjava2test.bean.BaseBean;
import com.zhongmeng.rxjava2test.bean.LoginBean;
import com.zhongmeng.rxjava2test.bean.Notice;
import com.zhongmeng.rxjava2test.bean.Work;
import com.zhongmeng.rxjava2test.utils.SaveUserInfo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * author :rcw.
 * date :2017/10/11 11:53.
 */

public class ApiServiceManager {
    private static final String token = SaveUserInfo.getInstance().getToken();
    private static final String baseurl = "http://192.168.1.68:8080/cdc_appInterface/";
    private static final int TIME_OUT = 10;

    private static ApiServiceManager apiServiceManager;

    //私有构造方法
    public ApiServiceManager() {
    }

    //创建retrofit对象实例
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())//将返回的数据转为Gson
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加Rxjava的回调
            .client(genericClient())
            .build();
    //通过retrofit获取ApiService实例
    private static ApiService apiService = retrofit.create(ApiService.class);

    public static OkHttpClient genericClient() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("token", token)
                                .build();
                        return chain.proceed(request);
                    }

                })
                .build();
        return httpClient;
    }
    //单例模式获取实例
    public static ApiServiceManager getInstance() {
        if (apiServiceManager == null) {
            synchronized (ApiServiceManager.class) {
                if (apiServiceManager == null) {
                    apiServiceManager = new ApiServiceManager();
                }
            }
        }
        return apiServiceManager;
    }

    /**
     * 登录
     *
     * @param cid      手机cid
     * @param username
     * @param password
     * @return 返回类型为Observable型的实体类
     */
    public static Observable<LoginBean> getCallBackData(String cid, String username, String password) {
        return apiService.getLoginInfo(cid, username, password);
    }

    public static Observable<Banner> getBannerUrl() {
        return apiService.getBannerUrl();
    }

    public static Observable<Notice> getNoticeInfo(String types, String page, String pagesize, String areacode) {
        return apiService.getNoticeInfo(types, page, pagesize, areacode);
    }

    public static Observable<Work> getCdcWorkInfo(String unitcode) {
        return apiService.getCdcWorkInfo(unitcode);
    }

    public static Observable<Work> getWorkInfo(String areacode) {
        return apiService.getWorkInfo(areacode);
    }

    public static Observable<BaseBean> getQiuniuToken() {
        return apiService.getQiuniuToken();
    }


}