package com.glee.technology_sharing.sample;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import androidx.databinding.BindingAdapter;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/**
 * @author liji
 * @date 2018/12/17 13:12
 * description
 */


public class Adapter {
    /**
     * imageView加载图片
     *
     * @param imageView ImageView
     * @param url       图片url
     */
    @BindingAdapter("load_url")
    public static void loadUrl(
            ImageView imageView,
            String url
    ) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    /**
     * 设置刷新状态
     *
     * @param swipeRefreshLayout SwipeRefreshLayout
     * @param state              是否在刷新中
     */
    @BindingAdapter("refresh_state")
    public static void refreshState(
            SwipeRefreshLayout swipeRefreshLayout,
            Boolean state
    ) {
        swipeRefreshLayout.setRefreshing(state);
    }

    /**
     * 刷新回调
     *
     * @param swipeRefreshLayout SwipeRefreshLayout
     * @param lambda             监听
     */
    @BindingAdapter("onRefresh")
    public static void refreshState(
            SwipeRefreshLayout swipeRefreshLayout,
            SwipeRefreshLayout.OnRefreshListener lambda
    ) {
        if (lambda != null) {
            swipeRefreshLayout.setOnRefreshListener(lambda);
        }
    }
}
