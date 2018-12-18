package com.glee.technology_sharing.sample;

import com.glee.technology_sharing.sample.movie.MovieViewModel;
import com.glee.technology_sharing.sample.repository.RemoteDataSource;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author liji
 * @date 2018/12/11 20:28
 * description
 */


public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static ViewModelFactory factory;


    /**
     * 获取工厂单例
     */
    public static ViewModelFactory getInstance() {
        if (factory == null) {
            factory = new ViewModelFactory();
        }
        return factory;
    }
    //远程数据源，这里为Retrofit API
    private final RemoteDataSource remoteDataSource;

    private ViewModelFactory() {
        //构造Retrofit API
        remoteDataSource = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RemoteDataSource.class);
    }
    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //通过class对象判断所需的ViewModel，直接new构造并返回
        if (MovieViewModel.class.isAssignableFrom(modelClass)) {
            return (T) new MovieViewModel(remoteDataSource);
        }
        return super.create(modelClass);
    }
}
