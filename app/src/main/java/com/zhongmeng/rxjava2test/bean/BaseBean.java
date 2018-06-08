package com.zhongmeng.rxjava2test.bean;

/**
 * Created by rcw on 2017/7/28.
 */

public class BaseBean {

    /**
     * code : 200
     * message : 请求成功
     * “state” : 1
     */

    private int code;//200：成功 100：失败
    private String message;
    private int state; // 0：token正常 1：token失效

    public String getUpToken() {
        return upToken;
    }

    public void setUpToken(String upToken) {
        this.upToken = upToken;
    }

    private String upToken;
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
