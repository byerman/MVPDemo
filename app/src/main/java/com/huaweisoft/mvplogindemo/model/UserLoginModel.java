package com.huaweisoft.mvplogindemo.model;

import com.huaweisoft.mvplogindemo.interfaces.IUserLoginModel;
import com.huaweisoft.mvplogindemo.interfaces.OnLoginListener;
import com.huaweisoft.mvplogindemo.interfaces.OnRegisterListener;

/**
 * Created by baiaj on 2017/4/26.
 */

public class UserLoginModel implements IUserLoginModel{


    @Override
    public void login(final String userName, final String password, final OnLoginListener listener) {
        // 模拟子线程耗时操作
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("baj".equals(userName) && "123456".equals(password)){
                    listener.loginSuccess();
                }else{
                    listener.loginFailed("登录失败");
                }
            }
        }.start();
    }

    @Override
    public void register(final String userName, final String password, final OnRegisterListener listener) {
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (userName.length() >= 3 && password.length() >= 6){
                    listener.onRegisterSuccess("注册成功");
                }else{
                    listener.onRegisterFailed("注册失败");
                }
            }
        }.start();
    }

}
