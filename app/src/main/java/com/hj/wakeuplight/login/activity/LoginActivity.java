package com.hj.wakeuplight.login.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.util.Log;

import com.hj.wakeuplight.R;
import com.hj.wakeuplight.login.contact.LoginContact;
import com.hj.wakeuplight.login.presenter.LoginPresenter;
import com.hjtech.base.base.BaseActivity;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity<LoginContact.Presenter> implements LoginContact.View {

    private static final String TAG="LogDemo";
    private TextView username;
    private TextView password;
    private TextView forgetpsw;
    private TextView register;
    private Button login;
    private CheckBox rememberpsw;
    Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fullScreen();
        setContentView(R.layout.activity_login);
        initViewAndEvent();
    }

    private void initViewAndEvent() {
        username=this.findViewById(R.id.login_username);
        password=this.findViewById(R.id.login_password);
        forgetpsw=this.findViewById(R.id.login_forgetpsw);
        register=this.findViewById(R.id.login_register);
        login=this.findViewById(R.id.login_button);
        rememberpsw=this.findViewById(R.id.login_checkBox);

        login.setOnClickListener(clickListener);
        forgetpsw.setOnClickListener(clickListener);
        register.setOnClickListener(clickListener);
        rememberpsw.setOnClickListener(clickListener);
        mContext=this;
        Log.i(TAG, "mContext:"+String.valueOf(mContext));


    }
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.login_button:
                    presenter.login();
                    break;
                case R.id.login_register:
                    RegisterLoginActivity.obtain(mContext);
                    break;
                case R.id.login_forgetpsw:
                    ForgetPswActivity.obtain(mContext);
                    break;
            }
        }
    };

    @Override
    public LoginContact.Presenter initPresenter() {
        return new LoginPresenter(this);
    }
    @Override
    public String getName() {
        return username.getText().toString().trim();
    }
    @Override
    public String getPsw() {
        return password.getText().toString().trim();
    }
}

