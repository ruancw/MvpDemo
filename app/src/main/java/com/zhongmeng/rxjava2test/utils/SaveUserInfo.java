package com.zhongmeng.rxjava2test.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.zhongmeng.rxjava2test.MyApplication;
import com.zhongmeng.rxjava2test.bean.LoginBean;


/**
 * author : rcw
 * time   : 2017/7/31
 * version: 1.0
 * desc   : 保存用户信息
 */
public final class SaveUserInfo {
    private static SaveUserInfo mInstance;
    private SharedPreferences mSharedPreferences;
    //保存用户信息静态字段/sp中的key
    private final String KEY_TOKEN = "token";// Token值/操作校验值  string
    private final String KEY_ID = "id";// 用户id  string
    private final String KEY_LOGINID = "loginid";// 登陆账号  string
    private final String KEY_USERNAME = "userName";// 用户姓名 string
    private final String KEY_USER_PASSWORD = "passWord";// 用户密码 int
    private final String KEY_TYPE ="type";//  1 个人 2 企业 String
    private final String KEY_STATE ="state";//
    private final String KEY_UNIT_NAME ="unitName";// 单位名称
    private final String KEY_UNIT_CODE ="unitCode";// 单位code
    private final String KEY_AREA_CODE ="Code";// 区域编码
    private final String KEY_USE_STATE ="use_state";// 用户账号状态
    private final String KEY_OVERRID_TIME ="overridtime";// 过期时间
    private final String KEY_IMAGE_URL ="URL";// 过期时间

    //私有构造器
    private SaveUserInfo() {
        if (mSharedPreferences == null) {
            mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
        }
    }

    /**
     * 获取用户信息存储单例
     * @return 实体单例
     */
    public static SaveUserInfo getInstance() {
        if (mInstance == null) {
            synchronized (SaveUserInfo.class) {
                if (mInstance == null) {
                    mInstance = new SaveUserInfo();
                }
            }
        }
        return mInstance;
    }

    //获取保存sp的值，防止为null
    private String getValue(String value) {
        return TextUtils.isEmpty(value) ? "" : value;
    }
    /**
     * 获取id信息
     */
    public int getId() {
        return mSharedPreferences.getInt(KEY_ID, 0);
    }

    /**
     * 保存id信息
     * @param id
     */
    public void saveId(String id) {

        mSharedPreferences.edit().putString(KEY_ID, getValue(id)).apply();
    }
    /**
     * 获取token信息
     */
    public String getToken() {
        return mSharedPreferences.getString(KEY_TOKEN, "");
    }

    /**
     * 保存token信息
     * @param token 操作token
     */
    public void saveToken(String token) {

        mSharedPreferences.edit().putString(KEY_TOKEN, getValue(token)).apply();
    }

    /**
     * 获取password信息
     */
    public String getUserPassWord() {
        return mSharedPreferences.getString(KEY_USER_PASSWORD, "");
    }

    /**
     * 保存password信息
     */
    public void saveUserPassWord(String passWord) {

        mSharedPreferences.edit().putString(KEY_USER_PASSWORD, passWord).apply();
    }
    /**
     * 获取LOGINid信息
     */
    public String getLoginId() {
        return mSharedPreferences.getString(KEY_LOGINID, "");
    }

    /**
     * 保存loginid信息
     */
    public void saveLoginId(String loginId) {

        mSharedPreferences.edit().putString(KEY_LOGINID, loginId).apply();
    }

    /**
     * 获取用户姓名
     */
    public String getUserName() {
        return mSharedPreferences.getString(KEY_USERNAME, "");
    }

    /**
     * 保存用户姓名
     */
    public void saveUserName(String userName) {
        mSharedPreferences.edit().putString(KEY_USERNAME, getValue(userName)).apply();
    }
    /**
     * 获取单位名
     */
    public String getUnitName() {
        return mSharedPreferences.getString(KEY_UNIT_NAME, "");
    }

    /**
     * 保存单位名
     */
    public void saveUnitName(String unitName) {
        mSharedPreferences.edit().putString(KEY_UNIT_NAME, getValue(unitName)).apply();
    }

    /**
     * 获取单位名
     */
    public String getUnitCode() {
        return mSharedPreferences.getString(KEY_UNIT_CODE, "");
    }

    /**
     * 保存单位名
     */
    public void saveUnitCode(String unitCode) {
        mSharedPreferences.edit().putString(KEY_UNIT_CODE, getValue(unitCode)).apply();
    }

    /**
     * 获取区域码
     */
    public String getAreaCode() {
        return mSharedPreferences.getString(KEY_AREA_CODE, "");
    }

    /**
     * 保存单位名
     */
    public void saveAreaCode(String areaCode) {
        mSharedPreferences.edit().putString(KEY_AREA_CODE, getValue(areaCode)).apply();
    }

    /**
     * 保存角色type
     */
    public void saveState(int state) {
        mSharedPreferences.edit().putInt(KEY_STATE, state).apply();
    }
    /**
     * 获取角色type
     */
    public int getState() {
        return mSharedPreferences.getInt(KEY_STATE, 0);
    }

    /**
     * 保存角色type
     */
    public void saveType(String type) {
        mSharedPreferences.edit().putString(KEY_TYPE, type).apply();
    }
    /**
     * 获取角色type
     */
    public String getType() {
        return mSharedPreferences.getString(KEY_TYPE, "");
    }

    /**
     * 保存角色type
     */
    public void saveUseState(String usestate) {
        mSharedPreferences.edit().putString(KEY_USE_STATE, usestate).apply();
    }
    /**
     * 获取角色type
     */
    public String getUseState() {
        return mSharedPreferences.getString(KEY_USE_STATE, "");
    }

    /**
     * 获取过期时间type
     */
    public long getTime() {
        return mSharedPreferences.getLong(KEY_OVERRID_TIME, 0);
    }

    /**
     * 保存用户图像url
     */
    public void saveHeadImageUrl(String url) {
        mSharedPreferences.edit().putString(KEY_IMAGE_URL, url).apply();
    }
    /**
     * 获取用户图像url
     */
    public String getHeadImageUrl() {
        return mSharedPreferences.getString(KEY_IMAGE_URL, "");
    }
    /**
     * 保存用户所有信息
     */
    public void saveAllData(LoginBean loginBean) {
        if (loginBean == null) {
            return;
        }
        LogUtils.z("loginBean", "保存用户所有信息");
        mSharedPreferences.edit()
                .putInt(KEY_ID, loginBean.getUserinfo().getId())
                //.putString(KEY_ID, getValue(loginBean.getUserinfo().getId()))
                .putString(KEY_LOGINID, getValue(loginBean.getUserinfo().getLoginid()))
                .putString(KEY_USER_PASSWORD, getValue(loginBean.getUserinfo().getPassword()))
                .putString(KEY_USERNAME, getValue(loginBean.getUserinfo().getUsername()))
                .putString(KEY_UNIT_NAME, getValue(loginBean.getUserinfo().getUnitname()))
                .putString(KEY_UNIT_CODE, getValue(loginBean.getUserinfo().getUnit_code()))
                .putString(KEY_AREA_CODE, getValue(loginBean.getUserinfo().getAreacode()))
                .putString(KEY_TOKEN, getValue(loginBean.getToken()))
                .putString(KEY_TYPE, getValue(loginBean.getUserinfo().getPlat_type()))
                .putString(KEY_USE_STATE, getValue(loginBean.getUserinfo().getUse_state()))
                .putString(KEY_IMAGE_URL, getValue(loginBean.getUserinfo().getHead_url()))
                .putInt(KEY_STATE, loginBean.getState())
                .putLong(KEY_OVERRID_TIME, loginBean.getTime())
                .apply();
    }


    /**
     * 清除本地个人用户所有信息
     */
    public void clearAllData() {
        mSharedPreferences.edit().clear().apply();
    }

    //是否有效登录
    public boolean isLogin(){
        if ((!TextUtils.isEmpty(getToken())) && System.currentTimeMillis()<=getTime()){
            LogUtils.z("getOverridTime="+getTime());
            LogUtils.z("System.currentTimeMillis="+ System.currentTimeMillis());
            return true;
        }
        return false;
    }

}
