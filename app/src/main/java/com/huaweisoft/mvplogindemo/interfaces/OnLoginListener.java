package com.huaweisoft.mvplogindemo.interfaces;

import com.huaweisoft.mvplogindemo.model.User;

/**
 * Created by baiaj on 2017/4/26.
 */

public interface OnLoginListener {

    void loginSuccess();
    void loginFailed(String msg);

}
