package com.glee.technology_sharing;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * @author liji
 * @date 2018/12/11 20:28
 * description
 */


class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static ViewModelFactory factory;


    public static ViewModelFactory getInstance() {
        if (factory == null) {
            factory = new ViewModelFactory();
        }
        return factory;
    }
    private final DataBase db;
    private final HttpClient httpClient;

    public ViewModelFactory() {
        db = new DataBase();
        httpClient = new HttpClient();
    }

    /**
     *
     */
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (TestViewModel.class.isAssignableFrom(modelClass)) {
            return (T) new TestViewModel();
        }
        return super.create(modelClass);
    }
}
