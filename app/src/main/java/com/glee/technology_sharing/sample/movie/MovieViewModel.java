package com.glee.technology_sharing.sample.movie;

import com.glee.technology_sharing.sample.repository.bean.Movie;
import com.glee.technology_sharing.sample.repository.RemoteDataSource;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author liji
 * @date 2018/12/17 10:14
 * description
 */


public class MovieViewModel extends ViewModel {
    //远程数据源
    private final RemoteDataSource remoteDataSource;
    //网络请求对象
    private Call<Movie> movieCall;

    //电影详情LiveData
    private MutableLiveData<Movie> movieLiveData = new MutableLiveData<>();

    //刷新状态LiveData
    private MutableLiveData<Boolean> refreshStateLiveData = new MutableLiveData<>();

    //电影标题LiveData
    private LiveData<String> titleLiveData = Transformations.map(movieLiveData,
            new Function<Movie, String>() {
                @Override
                public String apply(Movie input) {
                    return input == null ? null : input.getTitle();
                }
            });

    //电影简介LiveData
    private LiveData<String> summaryLiveData = Transformations.map(movieLiveData,
            new Function<Movie, String>() {
                @Override
                public String apply(Movie input) {
                    return input == null ? null : input.getSummary();
                }
            });

    //电影海报LiveData
    private LiveData<String> imgLiveData = Transformations.map(movieLiveData,
            new Function<Movie, String>() {
                @Override
                public String apply(Movie input) {
                    return input == null ? null : input.getImages().getSmall();
                }
            });

    public MovieViewModel(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
        //初始化时加载数据
        getMovie();
        //设置刷新状态为true
        refreshStateLiveData.setValue(true);
    }

    //电影id数组
    private int[] ids = {3878007, 27069377, 1291560, 27198855, 27615441};
    //当前电影的索引
    private int index = ids.length;

    /**
     * 网络请求电影详情
     */
    public void getMovie() {
        //遍历请求
        movieCall = remoteDataSource.getMovie(ids[index++ % ids.length]);
        movieCall.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                //更新电影详情LiveData数据
                movieLiveData.setValue(response.body());
                //刷新状态LiveData置为false
                refreshStateLiveData.setValue(false);
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                //刷新状态LiveData置为false
                refreshStateLiveData.setValue(false);
            }
        });
    }

    public LiveData<Boolean> getRefreshStateLiveData() {
        return refreshStateLiveData;
    }

    public LiveData<String> getTitleLiveData() {
        return titleLiveData;
    }

    public LiveData<String> getSummaryLiveData() {
        return summaryLiveData;
    }

    public LiveData<String> getImgLiveData() {
        return imgLiveData;
    }

    /**
     * 取消网络请求，避免ViewModel泄漏
     */
    @Override
    protected void onCleared() {
        super.onCleared();
        if (movieCall != null && !movieCall.isCanceled()) {
            movieCall.cancel();
        }
    }
}
