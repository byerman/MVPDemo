package com.huaweisoft.mvplogindemo.interfaces;

/**
 * Created by baiaj on 2017/4/26.
 */

public interface IUserLoginView {

    String getUserName();
    String getPassword();
    void clearUserName();
    void clearPassword();
    void showLoading();
    void hideLoading();
    void gotoMainAct();
    void showErrorMsg(String msg);
    void showSuccesMsg(String msg);

}
