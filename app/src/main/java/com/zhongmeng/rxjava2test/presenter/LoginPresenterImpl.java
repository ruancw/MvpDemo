package com.zhongmeng.rxjava2test.presenter;


import com.zhongmeng.rxjava2test.base.BasePresenter;
import com.zhongmeng.rxjava2test.bean.LoginBean;
import com.zhongmeng.rxjava2test.modle.LoginModle;
import com.zhongmeng.rxjava2test.modle.LoginModleImpl;
import com.zhongmeng.rxjava2test.view.LoginView;

/**
 * author :rcw.
 * date :2017/10/11 10:59.
 * presenter的实现类，处理modle数据和view的数据展示
 */

public class LoginPresenterImpl extends BasePresenter implements LoginPresenter,LoginModle.OnLoginListener {

    private LoginView loginView;
    private LoginModle loginModle;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        loginModle=new LoginModleImpl(this);
    }

    /**
     * 实现父类的方法
     */
    @Override
    public void login() {
        boolean error;
        String name=loginView.getUserName();
        String password=loginView.getPassWord();
        if (name.isEmpty()){//数据校验
            loginView.setUserNameError();
            error=false;
        }else if (password.isEmpty()){
            loginView.setPassWordError();
            error=false;
        }else {//数据校验成功
            error=true;
        }
        if (error){//数据校验成功,Rxjava进行数据请求处理
            loginView.showProgress();
            //rx注册,成功后回调监听接口，view对返回数据进行展示
            addSubscription(loginModle.login(loginView.getUserName(),loginView.getPassWord()));
        }
    }

    @Override
    public void destory() {
        onUnsubscribe();
    }//rx取消注册

    @Override
    public void loginSuccess(LoginBean loginBean) {//modle监听接口的回调
        if (loginView!=null){
            loginView.hideProgress();
            loginView.onSuccess(loginBean);

        }

    }

    @Override
    public void loginFail(Throwable throwable) {//modle监听接口的回调
        loginView.hideProgress();
        loginView.onFail(throwable);

    }


}
