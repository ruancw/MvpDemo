package com.zhongmeng.rxjava2test.retrofit;


import com.zhongmeng.rxjava2test.bean.Banner;
import com.zhongmeng.rxjava2test.bean.BaseBean;
import com.zhongmeng.rxjava2test.bean.LoginBean;
import com.zhongmeng.rxjava2test.bean.Notice;
import com.zhongmeng.rxjava2test.bean.Work;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * author :rcw.
 * date :2017/10/11 11:41.
 * 网络请求接口
 */

public interface ApiService<T> {

    @GET("")
    Observable<T> getDatas();
    /**
     *
     * @param cid
     * @param username
     * @param password
     * @return 返回类型为observable的实体类
     * @GET 请求可用@Query/QueryMap
     * @POST 请求用@Filed/body(body为对象类型)*必须添加@FormUrlEncoded注解
     */
    @GET("loginController/login.do")
    Observable<LoginBean> getLoginInfo(@Query("cid") String cid, @Query("loginid") String username, @Query("password") String password);

    @GET("appHomeController/getImgLsit.do")
    Observable<Banner> getBannerUrl();

    @GET("noticeManageController/getNoticeList.do")
    Observable<Notice> getNoticeInfo(@Query("types")String types, @Query("page")String page, @Query("pagesize")String pagesize, @Query("areacode")String areacode);

    @GET("centerController/cdcBacklog.do")
    Observable<Work> getCdcWorkInfo(@Query("unitcode")String unitcode);

    @GET("superviseController/getBacklog.do")
    Observable<Work> getWorkInfo(@Query("areacode")String areacode);

    @GET("appController/returnToken.do")
    Observable<BaseBean> getQiuniuToken();

}
