package com.hjtech.base.app;


import android.text.TextUtils;

import com.hjtech.base.utils.SharePreUtils;

public class AppData {

    private String memberId = "";
    private String requestCode = "";
    private String phone = "";
    private String avatar = "";
    private volatile static AppData instance;

    public static AppData getInstance() {
        if (instance == null) {
            synchronized (AppData.class) {
                if (instance == null) {
                    instance = new AppData();
                }
            }
        }
        return instance;
    }

    private AppData() {

    }

    public String getAvatar() {
        if (TextUtils.isEmpty(avatar)) {
            avatar = SharePreUtils.getString(MyApp.getApplication(), "avatar", "");
        }
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        if (phone.equals("")) {
            phone = SharePreUtils.getString(MyApp.getApplication(), "phone", "");
        }
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMemberId() {
        if (TextUtils.isEmpty(memberId)) {
            memberId = SharePreUtils.getString(MyApp.getApplication(), "memberId", "");
        }
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getRequestCode() {
        if (TextUtils.isEmpty(requestCode)) {
            requestCode = SharePreUtils.getString(MyApp.getApplication(), "requestCode", "");
        }
        return requestCode;
    }

    public void setRequestCode(String requestCode) {
        this.requestCode = requestCode;
    }
}
