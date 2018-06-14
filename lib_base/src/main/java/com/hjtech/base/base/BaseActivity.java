package com.hjtech.base.base;


import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.hjtech.base.R;
import com.hjtech.base.utils.ActivityManager;
import com.hjtech.base.utils.SharePreUtils;

import java.util.Locale;

/*
 * 项目名:    EasyPark
 * 包名       com.hjtech.easypark.common.base
 * 文件名:    BaseActivity
 * 创建者:    ZJB
 * 创建时间:  2017/6/20 on 14:15
 * 描述:     TODO
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {

    protected P presenter;
    public Context context;
    private TextView tv_title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        context = this;
        ActivityManager.getAppInstance().addActivity(this);
        presenter = initPresenter();
        selectLanguage(SharePreUtils.getString(this, "language", "zh"));
    }

    @Override
    protected void onResume() {
        /**
         * 设置为横屏
         */
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onResume();
    }

    protected void fullScreen() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    protected void onDestroy() {
        ActivityManager.getAppInstance().removeActivity(this);
        if (presenter != null) {
            presenter.detach();
        }
        super.onDestroy();
    }

    public abstract P initPresenter();

    /**
     * 沉浸式状态栏
     */
    public void transStatus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    /**
     * 初始化ToolBar
     *
     * @param title  ToolBar中间的标题
     * @param isBack 是否显示左边返回箭头
     * @return Toolbar
     */
    public Toolbar initToolBar(final AppCompatActivity activity, boolean isBack, String title) {
        Toolbar toolbar = activity.findViewById(R.id.tool_bar);
        toolbar.setTitle("");
        activity.setSupportActionBar(toolbar);
        tv_title = activity.findViewById(R.id.tool_bar_title);
        tv_title.setText(title);
        if (isBack) {
            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    activity.finish();
//                }
//            });
        }
        return toolbar;
    }

    public void setToolbarTitle(String title) {
        if (tv_title != null) {
            tv_title.setText(title);
        }
    }

    @Override
    public void showLoadingDialog(String msg) {

    }

    @Override
    public void dimissLoadingDialog() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setStatusBar(int color, boolean isLight) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以上
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            //根据上面设置是否对状态栏单独设置颜色
            if (color != -1) {
                getWindow().setStatusBarColor(getResources().getColor(color));
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4到5.0
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {//android6.0以后可以对状态栏文字颜色和图标进行修改
            if (isLight) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }
    }

    protected boolean checkPermission(int requestCode, String permissions) {
        if (ContextCompat.checkSelfPermission(context, permissions) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            ActivityCompat.requestPermissions(this, new String[]{permissions}, requestCode);
        }
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(context, "拒绝权限", Toast.LENGTH_SHORT).show();
        }
    }

    /*
   将状态栏字体颜色设为深色
    */
    private void setStatusBarTextColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public void selectLanguage(String language) {
        //设置语言类型
        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        switch (language) {
            case "en":
                configuration.locale = Locale.ENGLISH;
                break;
            case "zh":
                configuration.locale = Locale.SIMPLIFIED_CHINESE;
                break;
            case "ft":
                configuration.locale = Locale.JAPANESE;
                break;
            default:
                configuration.locale = Locale.getDefault();
                break;
        }
        resources.updateConfiguration(configuration, displayMetrics);
        //保存设置语言的类型
        SharePreUtils.putString(this, "language", language);
    }

}
