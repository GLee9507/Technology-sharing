package com.glee.technology_sharing.sample.movie;

import android.os.Bundle;
import android.widget.TextView;

import com.glee.technology_sharing.R;
import com.glee.technology_sharing.databinding.ActivityMovieBinding;
import com.glee.technology_sharing.sample.ViewModelFactory;
import com.glee.technology_sharing.sample.repository.bean.Movie;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/**
 * @author liji
 * @date 2018/12/17 10:14
 * description
 */


public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMovieBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_movie);
        //获取ViewModel
        MovieViewModel movieViewModel = ViewModelProviders
                .of(this, ViewModelFactory.getInstance())
                .get(MovieViewModel.class);
        //设置属性
        binding.setViewModel(movieViewModel);
        //设置生命周期所有者
        binding.setLifecycleOwner(this);
    }
}
