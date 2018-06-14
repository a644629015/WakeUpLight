
package com.hjtech.base.base;

public interface BaseRefreshView extends BaseView {

    //完成刷新
    void completeRefresh();

    //完成上拉加载
    void completeLoadmore();

    //清除数据
    void cleanData();

}
