package com.glee.technology_sharing;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentManager manager = getSupportFragmentManager();
//                Fragment testFragment = manager.findFragmentByTag(TestFragment.TAG);
//                if (testFragment == null) {
//                    testFragment = TestFragment.newInstance();
//                }
//                manager.beginTransaction()
//                        .replace(R.id.main, testFragment, TestFragment.TAG)
//                        .commitNow();
//            }
//        });
//        MutableLiveData<String> stringMutableLiveData = new MutableLiveData<>();
//        stringMutableLiveData.observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//
//            }
//        });
//        findViewById(R.id.remove).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentManager manager = getSupportFragmentManager();
//                Fragment testFragment = manager.findFragmentByTag(TestFragment.TAG);
//                if (testFragment != null) {
//                    manager.beginTransaction()
//                            .detach(testFragment)
//                            .commitNow();
//                }
//
//            }
//        });
        getLifecycle().addObserver(new LifecycleObserver() {
            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
            public void onResume() {
                Log.w(TAG, "onResume: ");
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
            public void onPause() {
                Log.w(TAG, "onPause: ");
            }
        });

}
String TAG = "glee9507";}
