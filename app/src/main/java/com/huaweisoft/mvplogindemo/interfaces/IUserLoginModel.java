package com.huaweisoft.mvplogindemo.interfaces;

/**
 * Created by baiaj on 2017/4/26.
 */

public interface IUserLoginModel {
    void login(String userName, String password, OnLoginListener listener);
    void register(String userName,String password,OnRegisterListener listener);
}
