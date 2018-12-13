package com.glee.technology_sharing;

import android.util.Log;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.AsyncListUtil;

/**
 * @author liji
 * @date 2018/11/27 21:21
 * description
 */


public class TestViewModel extends ViewModel {
    MutableLiveData<Integer> integerLiveData = new MutableLiveData<>();

    LiveData<String> stringLiveData =
            Transformations.map(integerLiveData, new Function<Integer, String>() {
                @Override
                public String apply(Integer input) {
                    return "进度：" + input;
                }
            });
    LiveData<String> stringLiveData =
            Transformations.switchMap(integerLiveData, new Function<Integer, LiveData<String>>() {
                @Override
                public LiveData<String> apply(Integer input) {
                    return null;
                }
            });

    /**
     * 用户信息LiveData，通过网络状态自动切换源LiveData
     */
    public LiveData<UserInfo> userInfoliveData =
            Transformations.switchMap(
                    //传入网络状态LiveData
                    netStatesLiveData,
                    new Function<NetStates, LiveData<UserInfo>>() {
                        @Override
                        public LiveData<UserInfo> apply(NetStates states) {
                            //如果网络状态改变为可用状态，返回网络用户信息LiveData
                            if (states == NetStates.AVAILABLE) {
                                return netUserInfoLiveData;
                            } else {
                                //反之返回本地数据库用户信息LiveData
                                return localDBUserInfoLiveData;
                            }
                        }
                    }
            );

    private boolean canceled = false;

    public TestViewModel() {
//        Transformations.switchMap(stringLiveData, new Function<Integer, LiveData<String>>() {
//            @Override
//            public LiveData<String> apply(Integer input) {
//                return null;
//            }
//        });
        new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                if (canceled) {
                    break;
                }
                integerLiveData.postValue(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    protected void onCleared() {
        Log.d("MainViewModel", "onCleared");
        canceled = true;
        super.onCleared();
    }
}
