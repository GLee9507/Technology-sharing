package com.glee.technology_sharing.sample.repository;

import com.glee.technology_sharing.sample.repository.bean.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author liji
 * @date 2018/12/17 10:28
 * description
 */


public interface RemoteDataSource {

    /**
     * 获取电影详情
     * @param id 电影id
     */
    @GET("subject/{id}?apikey=0b2bdeda43b5688921839c8ecb20399b")
    Call<Movie> getMovie(
            @Path("id") int id
    );
}
