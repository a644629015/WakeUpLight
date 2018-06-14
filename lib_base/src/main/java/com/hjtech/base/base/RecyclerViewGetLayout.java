package com.hjtech.base.base;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public interface RecyclerViewGetLayout {

    RecyclerView.ViewHolder getViewHolder(ViewGroup parent, int viewType);
}
