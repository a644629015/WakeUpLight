package com.hj.wakeuplight.login.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.hj.wakeuplight.R;
import com.hj.wakeuplight.login.contact.RegisterContact;
import com.hj.wakeuplight.login.presenter.RegisterPresenter;
import com.hjtech.base.base.BaseActivity;
import com.hjtech.base.utils.ToastUtils;

/*
 * 项目名:    WakeUpLight
 * 包名       com.hj.wakeuplight.login.activity
 * 文件名:    RegisterLoginActivity
 * 创建者:    YHF
 * 创建时间:  2018/6/14 0014 on 12:00
 * 描述:     TODO
 */

public class RegisterLoginActivity extends BaseActivity<RegisterContact.Presenter> implements RegisterContact.View {


    private LinearLayout llyt_first, llyt_second;
    private EditText reg_name;
    private EditText reg_pass;
    private EditText reg_passagain;
    private EditText reg_code;
    private Button next;
    private ImageView back;
    private ImageView eyes;
    private ImageView againeyes;
    private TimeCount timeCount;
    private Button regbutton;
    private Button getcode;
    private CheckBox checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViewAndEvent();
        showLlyt(0);
    }

    @SuppressLint("WrongViewCast")
    private void initViewAndEvent() {
        llyt_first =findViewById(R.id.llyt_first);
        llyt_second =findViewById(R.id.llyt_second);
        reg_name = findViewById(R.id.reg_username);
        reg_pass = findViewById(R.id.reg_password);
        reg_passagain = findViewById(R.id.reg_passwordagain);
        reg_code = findViewById(R.id.reg_code);
        next=findViewById(R.id.next);
        back=findViewById(R.id.back);
        eyes=findViewById(R.id.pass_eyes);
        againeyes=findViewById(R.id.passagain_eyes);
        regbutton=findViewById(R.id.reg_button);
        getcode=findViewById(R.id.getcode);
        checkbox=findViewById(R.id.reg_checkbox);

        regbutton.setOnClickListener(clickListener);
        getcode.setOnClickListener(clickListener);
        next.setOnClickListener(clickListener);
        back.setOnClickListener(clickListener);
        eyes.setOnClickListener(clickListener);
        againeyes.setOnClickListener(clickListener);
    }


    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.reg_button:
                    presenter.register();
                    break;
                case R.id.getcode:
                    presenter.getCode();
                    break;
                case R.id.next:
                    presenter.verfi();
                    break;
                case R.id.back:
                    finish();
                    break;
                case R.id.pass_eyes:
                    presenter.chageEyes(eyes,reg_pass);
                    break;
                case R.id.passagain_eyes:
                    presenter.chageEyes(againeyes,reg_passagain);
                    break;
            }
        }
    };

    @Override
    public RegisterContact.Presenter initPresenter() {
        return new RegisterPresenter(this);
    }
    public static void obtain(Context context) {
        Intent intent = new Intent(context, RegisterLoginActivity.class);
        context.startActivity(intent);
    }
    @Override
    public void countDown() {
        timeCount = new TimeCount(60 * 1000, 1000);
        timeCount.start();
    }

    @Override
    public void registerSuccess() {
        ToastUtils.showShortSafe(getResources().getString(R.string.tip_reg_success));
        finish();
    }
    @Override
    public String getName() {
        return reg_name.getText().toString().trim();
    }
    @Override
    public String getPass() {
        return reg_pass.getText().toString().trim();
    }
    @Override
    public String getPassagain() {
        return reg_passagain.getText().toString().trim();
    }
    @Override
    public String getCode() {
        return reg_code.getText().toString().trim();
    }
    @Override
    public void showLlyt(int i) {
        switch (i) {
            case 0:
                llyt_first.setVisibility(View.VISIBLE);
                llyt_second.setVisibility(View.GONE);
                break;
            case 1:
                llyt_first.setVisibility(View.GONE);
                llyt_second.setVisibility(View.VISIBLE);
                break;
        }
    }
    @Override
    public boolean isChecked() {
        return checkbox.isChecked();
    }
    private class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        public void onFinish() {
            getcode.setText(getResources().getString(R.string.get_code));
            getcode.setEnabled(true);
        }

        public void onTick(long millisUntilFinished) {
            getcode.setText(millisUntilFinished / 1000 + "s");
            getcode.setEnabled(false);
        }
    }
}
