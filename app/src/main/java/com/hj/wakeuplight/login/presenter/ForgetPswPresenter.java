package com.hj.wakeuplight.login.presenter;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

import com.hj.wakeuplight.R;
import com.hj.wakeuplight.login.contact.ForgetPswContact;
import com.hj.wakeuplight.login.contact.RegisterContact;
import com.hjtech.base.app.MyApp;
import com.hjtech.base.base.BasePresenterImpl;
import com.hjtech.base.utils.ToastUtils;

/*
 * 项目名:    WakeUpLight
 * 包名       com.hj.wakeuplight.login.presenter
 * 文件名:    RegisterPresenter
 * 创建者:    YHF
 * 创建时间:  2018/6/14 0014 on 13:34
 * 描述:     TODO
 */

public class ForgetPswPresenter extends BasePresenterImpl<ForgetPswContact.View> implements ForgetPswContact.Presenter {
    public ForgetPswPresenter(ForgetPswContact.View view) {
        super(view);
    }

    private String code = "";

    @Override
    public void reset() {
        if (TextUtils.isEmpty(view.getName())) {
            ToastUtils.showShortSafe("请输入用户名1");
            return;
        }
        if (TextUtils.isEmpty(view.getPass())) {
            ToastUtils.showShortSafe("请输入密码");
            return;
        }
        if (view.getPass()!=view.getPassagain()) {
            ToastUtils.showShortSafe("两次密码不一致");
            return;
        }
        if (TextUtils.isEmpty(view.getCode())) {
            ToastUtils.showShortSafe("请输入验证码");
            return;
        }
        ToastUtils.showLongSafe(view.getName()+"——"+view.getPass()+"——"+view.getPassagain()+"——"+view.getCode());
        view.registerSuccess();
        /*
        else {
            RetroftUtils.getApi().create(Net.class).register(view.getName())
                    .compose(RxSchedulers.<String>io_main())
                    .subscribe(new Consumer<String>() {
                        @Override
                        public void accept(String s) throws Exception {
                            //成功回调
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            //失败处理
                        }
                    });

        }*/
    }
    public void getCode() {
        if (TextUtils.isEmpty(view.getName()) || view.getName().length() != 11) {
            ToastUtils.showShortSafe(MyApp.getApplication().getResources().getString(R.string.tip_please_input_true_phone));

        }
        code = "123456";
        Log.d("bbbbb", "code-->" + code);
        ToastUtils.showShortSafe(MyApp.getApplication().getResources().getString(R.string.tip_get_code_success) + "-->" + code);
        view.countDown();
    }
    @SuppressLint("CheckResult")
    @Override
    public void verfi() {
        if (TextUtils.isEmpty(view.getName()) || view.getName().length() != 11) {
            ToastUtils.showShortSafe(MyApp.getApplication().getResources().getString(R.string.tip_please_input_true_phone));
        } else if (TextUtils.isEmpty(view.getCode())) {
            ToastUtils.showShortSafe(MyApp.getApplication().getResources().getString(R.string.tip_code_not_null));
        } else {
            if (TextUtils.isEmpty(code)) {
                code = view.getCode();
                view.showLlyt(1);
            } else if (code.equals(view.getCode())) {
                view.showLlyt(1);
            } else {
                ToastUtils.showShortSafe(MyApp.getApplication().getResources().getString(R.string.tip_code_error));
            }
        }
    }

    public void chageEyes(ImageView image, EditText text){
        if (!image.isSelected()) {
            text.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            image.setSelected(true);
        }else {
            text.setTransformationMethod(PasswordTransformationMethod.getInstance());
            image.setSelected(false);
        }
        text.setSelection(text.length());

    }
}
