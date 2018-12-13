package com.glee.technology_sharing;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

/**
 * @author liji
 * @date 2018/12/5 10:33
 * description
 */


public class TestFragment extends Fragment {
    public final static String TAG = "TestFragment";
    private ProgressBar progressBar;
    private TextView textView;
    private TestViewModel mainViewModel;

    public static TestFragment newInstance() {
        return new TestFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar = view.findViewById(R.id.progress);
        textView = view.findViewById(R.id.text);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainViewModel = ViewModelProviders.of(this, ViewMoedlFactory.getInstance()).get(TestViewModel.class);
        //基本用法
        mainViewModel.integerLiveData.observe(
                getViewLifecycleOwner(),
                s -> {
                    Log.d("TestFragment", "integerLiveData" + s);
                    progressBar.setProgress(s == null ? 0 : s);
                }
        );

        //Transformations#map
        mainViewModel.stringLiveData.observe(
                getViewLifecycleOwner(), s -> {
                    Log.d("TestFragment", "stringLiveData" + s);
                    textView.setText(s);
                }
        );
    }
}
