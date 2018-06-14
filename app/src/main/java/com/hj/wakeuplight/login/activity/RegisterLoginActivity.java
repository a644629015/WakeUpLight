package com.hj.wakeuplight.login.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.hj.wakeuplight.R;
import com.hj.wakeuplight.login.contact.RegisterContact;
import com.hj.wakeuplight.login.presenter.RegisterPresenter;
import com.hjtech.base.base.BaseActivity;

/*
 * 项目名:    WakeUpLight
 * 包名       com.hj.wakeuplight.login.activity
 * 文件名:    RegisterLoginActivity
 * 创建者:    YHF
 * 创建时间:  2018/6/14 0014 on 12:00
 * 描述:     TODO
 */

public class RegisterLoginActivity extends BaseActivity<RegisterContact.Presenter> implements RegisterContact.View {

    private EditText edit_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViewAndEvent();
    }

    private void initViewAndEvent() {
        edit_name = findViewById(R.id.edit_name);

        findViewById(R.id.btn_register).setOnClickListener(clickListener);
    }


    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_register:
                    presenter.register();
                    break;
            }
        }
    };

    @Override
    public RegisterContact.Presenter initPresenter() {
        return new RegisterPresenter(this);
    }

    @Override
    public String getName() {
        return edit_name.getText().toString().trim();
    }
}
