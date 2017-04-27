package com.huaweisoft.mvplogindemo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.huaweisoft.mvplogindemo.R;
import com.huaweisoft.mvplogindemo.interfaces.IUserLoginView;
import com.huaweisoft.mvplogindemo.presenter.LoginPresenter;

/**
 * Created by baiaj on 2017/4/26.
 */

public class LoginAct extends AppCompatActivity implements IUserLoginView, View.OnClickListener {

    private EditText etUserName;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnClear;
    private Button btnRegister;
    private ProgressBar mProgressBar;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initEvent();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                showLoading();
                mLoginPresenter.login(getUserName(),getPassword());
                break;
            case R.id.btn_clear:
                clearUserName();
                clearPassword();
                break;
            case R.id.btn_register:
                showLoading();
                mLoginPresenter.register(getUserName(),getPassword());
                break;
            default:
                break;
        }
    }

    private void initView() {
        etUserName = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnClear = (Button) findViewById(R.id.btn_clear);
        btnRegister = (Button) findViewById(R.id.btn_register);
        mProgressBar = (ProgressBar) findViewById(R.id.pb_loadding);
        mLoginPresenter = new LoginPresenter(this);
    }

    private void initEvent() {
        btnLogin.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    public String getUserName() {
        return etUserName.getText().toString();
    }

    public String getPassword() {
        return etPassword.getText().toString();
    }

    public void clearUserName() {
        etUserName.setText("");
    }

    public void clearPassword() {
        etPassword.setText("");
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void gotoMainAct() {
        Intent intent = new Intent(this,MainAct.class);
        startActivity(intent);
    }

    @Override
    public void showErrorMsg(String errorMsg) {
        Toast.makeText(this,errorMsg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccesMsg(String successMsg) {
        Toast.makeText(this,successMsg,Toast.LENGTH_SHORT).show();
    }

}
