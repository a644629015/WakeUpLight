package com.hjtech.base.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hjtech.base.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.List;

/**
 * Created by arutoria on 2017/7/11.
 */

public abstract class BaseListAdapter<T> extends RecyclerView.Adapter implements RecyclerViewGetLayout {

    protected List<T> mlist;
    protected Context context;
    protected ImageLoader imageLoader;
    protected DisplayImageOptions options; // 设置图片显示相关参数
    protected final int EMPTY_VIEW = 9999;
    protected ItemClickListener itemClickListener;

    public BaseListAdapter(List<T> mlist) {
        this.mlist = mlist;
        InitImageLoader(0);
    }

    public void setMyItemclick(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (null == context) {
            context = parent.getContext();
        }
        if (viewType == EMPTY_VIEW) {
            View view = LayoutInflater.from(context).inflate(R.layout.listitem_empty, parent, false);
            return new EmptyViewHolder(view);
        }
        return getViewHolder(parent, viewType);
    }

    protected View.OnClickListener baseClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (itemClickListener != null) {
                itemClickListener.onItemClick((Integer) v.getTag(), v);
            }
        }
    };

    @Override
    public abstract void onBindViewHolder(RecyclerView.ViewHolder holder, int position);

    @Override
    public int getItemCount() {
        return mlist.size() > 0 ? mlist.size() : 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (mlist.size() <= 0) {
            return EMPTY_VIEW;
        }
        return super.getItemViewType(position);
    }

    protected class EmptyViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_empty;

        public EmptyViewHolder(View itemView) {
            super(itemView);
        }
    }


    // imageLoader初始化
    protected void InitImageLoader(int rounde) {
        imageLoader = ImageLoader.getInstance();
        options = new DisplayImageOptions.Builder()
//                .showImageOnLoading(R.mipmap.icon_stub) // 设置图片下载期间显示的图片
//                .showImageForEmptyUri(R.mipmap.icon_empty) // 设置图片Uri为空或是错误的时候显示的图片
//                .showImageOnFail(R.mipmap.icon_error) // 设置图片加载或解码过程中发生错误显示的图片
                .imageScaleType(ImageScaleType.IN_SAMPLE_INT) // 图片缩放方式
                .bitmapConfig(Bitmap.Config.RGB_565)// 设置图片的解码类型//
                .cacheInMemory(true) // 设置下载的图片是否缓存在内存中
                .cacheOnDisk(true) // 设置下载的图片是否缓存在SD卡中
                .displayer(new RoundedBitmapDisplayer(rounde)) // 设置成圆角图片
                .build(); // 构建完成
    }

  public   interface ItemClickListener {
        void onItemClick(int position, View view);
    }

}
