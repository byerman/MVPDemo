package com.huaweisoft.mvplogindemo.interfaces;

/**
 * Created by baiaj on 2017/4/26.
 */

public interface IUserLoginPresenter {

    void login(String userName,String password);
    void register(String userName,String password);
}
