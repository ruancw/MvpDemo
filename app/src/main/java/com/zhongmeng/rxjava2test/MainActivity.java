package com.zhongmeng.rxjava2test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zhongmeng.rxjava2test.bean.LoginBean;
import com.zhongmeng.rxjava2test.presenter.LoginPresenter;
import com.zhongmeng.rxjava2test.presenter.LoginPresenterImpl;
import com.zhongmeng.rxjava2test.utils.LogUtils;
import com.zhongmeng.rxjava2test.utils.SaveUserInfo;
import com.zhongmeng.rxjava2test.utils.UIUtils;
import com.zhongmeng.rxjava2test.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements LoginView{

    @BindView(R.id.edit_account)
    EditText editAccount;
    @BindView(R.id.edit_password)
    EditText editPassword;
    @BindView(R.id.forget)
    TextView forget;
    @BindView(R.id.login)
    Button login;

    private String username = "";
    private String password = "";

    private LoginPresenter loginPresenter;//mvp中的中间量，协调modle和view

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenterImpl(this);//获取presenter的实例，this是view的实例
    }

    @OnClick({R.id.forget, R.id.login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.forget:
                break;
            case R.id.login:
                loginPresenter.login();//登录按钮触发presenter中的方法
                break;
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public String getUserName() {
        username = editAccount.getText().toString().trim();
        return username;
    }

    @Override
    public String getPassWord() {
        password = editPassword.getText().toString().trim();
        return password;
    }

    @Override
    public void setUserNameError() {
        UIUtils.toast("请输入手机号码");
    }

    @Override
    public void setPassWordError() {
        UIUtils.toast("请输入密码");
    }

    @Override
    public void onFail(Throwable throwable) {
        LogUtils.z(throwable.getMessage());
        UIUtils.toast("服务器连接失败");
    }


    @Override
    public void onSuccess(LoginBean loginBean) {
        //保存用户数据
        SaveUserInfo.getInstance().saveAllData(loginBean);
        LogUtils.z("loginBean:"+loginBean);
        int code = loginBean.getCode();
        if (code == 200) {
            LogUtils.z("我是:"+loginBean.getUserinfo().getUsername());
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();
        } else UIUtils.toast(loginBean.getMessage());
    }
}
