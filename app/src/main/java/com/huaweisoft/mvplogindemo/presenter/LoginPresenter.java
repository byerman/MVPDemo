package com.huaweisoft.mvplogindemo.presenter;

import android.os.Handler;

import com.huaweisoft.mvplogindemo.interfaces.IUserLoginPresenter;
import com.huaweisoft.mvplogindemo.interfaces.IUserLoginView;
import com.huaweisoft.mvplogindemo.interfaces.OnLoginListener;
import com.huaweisoft.mvplogindemo.interfaces.OnRegisterListener;
import com.huaweisoft.mvplogindemo.model.User;
import com.huaweisoft.mvplogindemo.model.UserLoginModel;

/**
 * Created by baiaj on 2017/4/26.
 */

public class LoginPresenter implements IUserLoginPresenter{

    private UserLoginModel mUserLoginModel;
    private IUserLoginView loginView;
    private Handler mHandler = new Handler();

    public LoginPresenter(IUserLoginView userLoginView){
        loginView = userLoginView;
        mUserLoginModel = new UserLoginModel();
    }

    @Override
    public void login(String userName, String password) {
        mUserLoginModel.login(userName, password, new OnLoginListener() {
            @Override
            public void loginSuccess() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.hideLoading();
                        loginView.gotoMainAct();
                    }
                });

            }

            @Override
            public void loginFailed(final String msg) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.hideLoading();
                        loginView.showErrorMsg(msg);
                    }
                });
            }
        });
    }

    @Override
    public void register(String userName, String password) {
        mUserLoginModel.register(userName, password, new OnRegisterListener() {
            @Override
            public void onRegisterSuccess(final String msg) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.hideLoading();
                        loginView.showSuccesMsg(msg);
                    }
                });
            }

            @Override
            public void onRegisterFailed(final String msg) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.hideLoading();
                        loginView.showErrorMsg(msg);
                    }
                });
            }
        });
    }

}
