package com.hj.wakeuplight.login.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hj.wakeuplight.R;
import com.hj.wakeuplight.login.contact.ForgetPswContact;
import com.hj.wakeuplight.login.presenter.ForgetPswPresenter;
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

public class ForgetPswActivity extends BaseActivity<ForgetPswContact.Presenter> implements ForgetPswContact.View {

    private LinearLayout llyt_first, llyt_second;
    private EditText fgp_name;
    private EditText fgp_pass;
    private EditText fgp_passagain;
    private EditText fgp_code;
    private Button fgpbutton;
    private ImageView eyes;
    private ImageView againeyes;
    private TimeCount timeCount;
    private Button getcode;
    private Button next;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpsw);
        initViewAndEvent();
        showLlyt(0);
    }

    @SuppressLint("WrongViewCast")
    private void initViewAndEvent() {
        llyt_first =findViewById(R.id.llyt_first);
        llyt_second =findViewById(R.id.llyt_second);
        fgp_name = findViewById(R.id.fgp_username);
        fgp_pass = findViewById(R.id.fgp_password);
        fgp_passagain = findViewById(R.id.fgp_passwordagain);
        fgp_code = findViewById(R.id.fgp_code);
        next=findViewById(R.id.next);
        back=findViewById(R.id.back);
        eyes=findViewById(R.id.pass_eyes);
        againeyes=findViewById(R.id.passagain_eyes);
        fgpbutton=findViewById(R.id.fgp_button);
        getcode=findViewById(R.id.getcode);

        fgpbutton.setOnClickListener(clickListener);
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
                case R.id.fgp_button:
                    presenter.reset();
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
                    presenter.chageEyes(eyes,fgp_pass);
                    break;
                case R.id.passagain_eyes:
                    presenter.chageEyes(againeyes,fgp_passagain);
                    break;

            }
        }
    };

    @Override
    public ForgetPswContact.Presenter initPresenter() {
        return new ForgetPswPresenter(this);
    }
    public static void obtain(Context context) {
        Intent intent = new Intent(context, ForgetPswActivity.class);
        context.startActivity(intent);
    }
    @Override
    public void countDown() {
        timeCount = new TimeCount(60 * 1000, 1000);
        timeCount.start();
    }

    @Override
    public void registerSuccess() {
        ToastUtils.showShortSafe(getResources().getString(R.string.tip_edit_success));
        finish();
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
    @Override
    public String getName() {
        return fgp_name.getText().toString().trim();
    }
    @Override
    public String getPass() {
        return fgp_pass.getText().toString().trim();
    }
    @Override
    public String getPassagain() {
        return fgp_passagain.getText().toString().trim();
    }
    @Override
    public String getCode() {
        return fgp_code.getText().toString().trim();
    }
}
