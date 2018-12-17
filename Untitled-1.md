# 美行科技 Android 技术分享


本文主要阐述了使用Android Architecture Components构建MVVM应用

## MVVM

MVVM（Model-View-ViewModel）设计架构旨在将图形用户界面与业务逻辑的开发分离开来，核心思想为**数据驱动视图**

![](https://github.com/GLee9507/Technology-sharing/raw/master/img/mvvm2.PNG)

- **Model**

  与MVP基本相同，Model表示应用程序的数据访问层，包括本地数据库或远程服务器等，一般情况下ViewModel会持有Model

- **ViewModel**
  
  ViewModel类似于MVP中的Presenter，负责处理程序的业务逻辑或者数据逻辑。但与之不同的是ViewModel不会持有View的引用，通过订阅-发布机制通知View更新UI

  该层的一个重要实现策略是将其与View分离，即ViewModel不应该意识到与之交互的View
  


- **View**
  
  View把UI事件传递到ViewModel，ViewModel做出具体业务逻辑处理并更新数据

  View通过订阅ViewModel中的数据，在数据变更时更新UI

  View层尽可能的下沉非UI相关代码到ViewModel
  <!-- Android Architecture Components 为我们提供了**ViewModel**实现，和可观察数据的实现——**LiveData**  

  该层的一个重要实现策略是将其与View分离，即ViewModel不应该意识到与之交互的View，官方明确表示ViewModel不可引用任何View或者Activity Context -->
  <!-- 在Android中View层为Activity或Fragment -->

## Android Architecture Components 安卓架构组件

![](https://github.com/GLee9507/Technology-sharing/raw/master/img/jetpack.png)
## ViewModel

ViewModel是Android Architecture Components中的一员，是Android中对MVVM架构中ViewModel的实现

源码
```java
public abstract class ViewModel {
    /**
     * This method will be called when this ViewModel is no longer used and will be destroyed.
     * <p>
     * It is useful when ViewModel observes some data and you need to clear this subscription to
     * prevent a leak of this ViewModel.
     */
    @SuppressWarnings("WeakerAccess")   
    protected void onCleared() {
    }
}
```
### 构造ViewModel

1. 无参构造

```java
public class TestFragment extends Fragment {

    TestViewModel testViewModel;
    ……

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        testViewModel = ViewModelProviders.of(this).get(TestViewModel.class);
    }

    ……

}
```

1. 有参构造
```java
public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static ViewModelFactory factory;

    public static ViewModelFactory getInstance() {
        if (factory == null) {
            factory = new ViewModelFactory();
        }
        return factory;
    }
    /**
     * Model层，包括本地数据库和远程服务器
     * DataBase、HTTPClient 为伪代码
     */
    private final DataBase db;
    private final HttpClient httpClient;

    public ViewModelFactory() {
        db = new DataBase();
        httpClient = new HttpClient();
    }
    
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        //通过传入的Class对象判断构造的ViewModel实例
        if (AViewModel.class.isAssignableFrom(modelClass)) {
            return (T) new AViewModel(db); ;
        } else if (BViewModel.class.isAssignableFrom(modelClass)) {
            return (T) new BViewModel(httpClient); ;
        } else if (CViewModel.class.isAssignableFrom(modelClass)) {
            return (T) new CViewModel(db, httpClient); ;
        }

        //……

        return super.create(modelClass);
    }
}
``` 

```java
public class TestFragment extends Fragment {

    TestViewModel testViewModel;
    ……

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        testViewModel = ViewModelProviders
                        .of(this, ViewMoedlFactory.getInstance())
                        .get(TestViewModel.class);
    }

    ……

}
```
<!-- 默认工厂
```java
public static class AndroidViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private static AndroidViewModelFactory sInstance;

    @NonNull
    public static AndroidViewModelFactory getInstance(@NonNull Application application) {
        if (sInstance == null) {
            sInstance = new AndroidViewModelFactory(application);
        }
        return sInstance;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (AndroidViewModel.class.isAssignableFrom(modelClass)) {
            // model 类继承了 AndroidViewModel
            try {
                return modelClass.getConstructor(Application.class).newInstance(mApplication);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e);
            } catch (InstantiationException e) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e);
            }
        }
        // 否则，由父类 `NewInstanceFactory` 处理
        return super.create(modelClass);
    }
}
```

父类 NewInstanceFactory
```java
public static class NewInstanceFactory implements Factory {

    @SuppressWarnings("ClassNewInstance")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        try {
            return modelClass.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("Cannot create an instance of " + modelClass, e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot create an instance of " + modelClass, e);
        }
    }
}
``` -->

### ViewModel生命周期
ViewMoedl会在配置变更（如屏幕旋转）时保持存活
![](https://github.com/GLee9507/Technology-sharing/raw/master/img/viewmodel-lifecycle.png)

<!-- AndroidX2.0之前是通过HolderFragment实现的
```java
public class HolderFragment extends Fragment implements ViewModelStoreOwner {

    ……

    //ViewModel仓库，内部维护HashMap
    private ViewModelStore mViewModelStore = new ViewModelStore();

    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        return mViewModelStore;
    }

    public HolderFragment() {
        //当宿主Activity配置变更销毁重建时，当前Fragment不会重建
        setRetainInstance(true);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //ViewModel销毁，执行ViewModel#onCleared
        mViewModelStore.clear();
    }

    ……
}
``` -->
## LiveData

LiveData是一个具有生命周期感知的可被观察的数据持有类，通常被ViewModel组件持有
### LiveData的优势

1. **避免内存泄漏**  
    当观察者的生命周期为Destroyed时，LiveData会把观察者的引用移除掉

2. **避免因生命周期造成的崩溃**  
    如果观察者的生命周期处于非活动状态时，不会收到LiveData事件

3. **提升性能**  
    当LiveData数据更新时，只有处于活动状态的观察者才会收到LiveData事件更新UI，而不是每次数据变更均更新UI

4. **共享资源**  
    多个观察者可以同时观察同一个LiveData，例如NetWorkStatusLiveData等

5. **视图与数据分离**  
    如果一个Activity或者Fragment因为配置变化而重新创建，例如设备旋转，它会立刻收到最新的可用数据

<!-- ![](https://user-gold-cdn.xitu.io/2018/11/26/1674da659ba72b84?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)  -->


### MutableLiveData

源码

```java
public class MutableLiveData<T> extends LiveData<T> {

    //子线程调用
    @Override
    public void postValue(T value) {
        super.postValue(value);
    }

    //主线程调用
    @Override
    public void setValue(T value) {
        super.setValue(value);
    }
}
```
### MediatorLiveData
合并多个LiveData至一个LiveData

![](https://github.com/GLee9507/Technology-sharing/raw/master/img/mediatorlivedata.png)

例
```java
LiveData<String> liveDataA = new MutableLiveData<>();
LiveData<String> liveDataB = new MutableLiveData<>();
MediatorLiveData<String> mediatorLiveData = new MediatorLiveData<>();

public TestViewModel() {
    mediatorLiveData.addSource(liveDataA, new Observer<String>() {
        //监听liveDataA，当其变化时更新mediatorLiveData
        @Override
        public void onChanged(String s) {
            mediatorLiveData.setValue(s);
        }
    });

    mediatorLiveData.addSource(liveDataB, new Observer<String>() {
        //监听liveDataB，当其变化时更新mediatorLiveData
        @Override
        public void onChanged(String s) {
            mediatorLiveData.setValue(s);
        }
    });
}
```
### Transformations#map 

例

```java
//下载进度LiveData
MutableLiveData<Integer> progressLiveData = new MutableLiveData<>();

//下载进度的文字描述LiveData
LiveData<String> stringLiveData =
        Transformations.map(integerLiveData, new Function<Integer, String>() {
            @Override
            public String apply(Integer input) {
                return "下载进度：" + input + "%";
            }
        });
```
### Transformations#switchMap 
![](https://github.com/GLee9507/Technology-sharing/raw/master/img/switchmap.png)
例

```java
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
```

## Lifecycle

Lifecycle是一个管理View生命周期的组件。在support library 26.1.0版本以后，AppCompatActivity和Fragment已引入Lifecycle

Lifecycle使用两个主要的枚举来跟踪他所关联组件的生命周期

LiveData的核心功能就是通过Lifecycle实现的

生命周期事件
```java
public enum Event {
    ON_CREATE,
    ON_START,
    ON_RESUME,
    ON_PAUSE,
    ON_STOP,
    ON_DESTROY
}
```
生命周期状态
```java
public enum State {
    INITIALIZED,
    CREATED,
    STARTED,
    RESUMED,
    DESTROYED
}
```
![](https://github.com/GLee9507/Technology-sharing/raw/master/img/lifecycle.webp)

例
```java
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //AppCompatActivity已经实现了LifeCycleOwner接口
        getLifecycle().addObserver(new LifecycleObserver() {

            //通过注解监听生命周期事件
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
```

## Sample 
代码文件结构  
![](https://github.com/GLee9507/Technology-sharing/raw/master/img/project.png)  
ViewModel层

```java
public class MovieViewModel extends ViewModel {
    //远程数据源
    private final RemoteDataSource remoteDataSource;
    
    //电影详情LiveData
    private MutableLiveData<Movie> movieLiveData = new MutableLiveData<>();
    
    //刷新状态LiveData
    private MutableLiveData<Boolean> refreshStateLiveData = new MutableLiveData<>();
    
    //电影标题LiveData
    public LiveData<String> titleLiveData = Transformations.map(movieLiveData,
            new Function<Movie, String>() {
                @Override
                public String apply(Movie input) {
                    return input.getTitle();
                }
            });

    //电影简介LiveData
    public LiveData<String> summaryLiveData = Transformations.map(movieLiveData,
            new Function<Movie, String>() {
                @Override
                public String apply(Movie input) {
                    return input.getSummary();
                }
            });

    //电影海报LiveData
    public LiveData<String> imgLiveData = Transformations.map(movieLiveData,
            new Function<Movie, String>() {
                @Override
                public String apply(Movie input) {
                    return input.getImages().getLarge();
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
        remoteDataSource.getMovie(ids[index++ % ids.length]).enqueue(new Callback<Movie>() {
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
}
```
ViewModel工厂
```java
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
```
Retrofit API
```java
public interface RemoteDataSource {

    /**
     * 获取电影详情
     * @param id 电影id
     */
    @GET("movie/subject/{id}?apikey=0b2bdeda43b5688921839c8ecb20399b")
    Call<Movie> getMovie(@Path("id") int id);
}
```
View层
```java
public class MovieActivity extends AppCompatActivity {

    private MovieViewModel movieViewModel;
    private TextView title;
    private TextView summary;
    private ImageView imageView;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        //获取ViewModel
        movieViewModel = ViewModelProviders
                .of(this, ViewModelFactory.getInstance())
                .get(MovieViewModel.class);
        //初始化View
        initView();
        //绑定View
        bindView();
    }

    private void bindView() {
        //绑定ViewModel中的电影详情LiveData
        movieViewModel.titleLiveData.observe(this,
                new Observer<String>() {
                    @Override
                    public void onChanged(String strTitle) {
                        title.setText(strTitle);
                    }
                });

        movieViewModel.summaryLiveData.observe(this,
                new Observer<String>() {
                    @Override
                    public void onChanged(String strSummary) {
                        summary.setText(strSummary);
                    }
                });

        movieViewModel.imgLiveData.observe(this,
                new Observer<String>() {
                    @Override
                    public void onChanged(String url) {
                        Glide.with(imageView.getContext()).load(url).into(imageView);
                    }
                });

        //绑定ViewModel中的刷新状态LiveData
        movieViewModel.getRefreshStateLiveData().observe(this,
                new Observer<Boolean>() {
                    @Override
                    public void onChanged(Boolean aBoolean) {
                        swipeRefreshLayout.setRefreshing(aBoolean == null ? false : aBoolean);
                    }
                }
        );
    }

    private void initView() {
        title = findViewById(R.id.title);
        summary = findViewById(R.id.summary);
        swipeRefreshLayout = findViewById(R.id.swipe);
        imageView = findViewById(R.id.image);
        //下拉刷新时请求电影详情数据
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                movieViewModel.getMovie();
            }
        });
    }
}
```

## Architecture Components常见误区

### 1. View层不可

### 1. 泄漏Fragment观察者
当我们在Fragment中使用LiveData时，在Fragment与Activity取消关联`Fragment#onDetach()`并且重新关联` Fragment#onAttach()`时，Fragment观察者会泄漏。因为Fragment没有执行`Fragment#onDestroyView()`生命周期，观察者并没有自动移除，故当LiveData更新数据时观察者`Observer#onChanged()`会执行多次

正确用法

```java
public class TestFragment extends Fragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //LifeCycleOwner参数由this替换为getViewLifecycleOwner()
        mainViewModel.integerLiveData.observe(
            /*this*/ getViewLifecycleOwner(),
                new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer s) {
                        progressBar.setProgress(s == null ? 0 : s);
                    }
                }
        );
    }
}
```
 `Fragment#getViewLifecycleOwner()`是Support 28.0.0 和 AndroidX 1.0.0引入的

### 2. 首次加载数据在`Activity#onCreate()`、`Fragment#onCreateView()`中

当配置变更时Activity重建，导致重复加载数据

正确使用方式在ViewModel的构造方法中首次加载数据

### 3. 将MutableLiveData暴露给View

违背了关注点分离原则，有悖于MVVM设计思想。即View不可直接对ViewModel中的数据进行修改
## 简化View层代码利器——DataBinding
DataBinding可以让你以XML声明的形式而不是代码编程的形式将布局中的UI组件绑定到程序中的数据源

### 启用DataBinding
build.gradle 
```java
android {
    ...
    dataBinding {
        enabled = true
    }
}

dependencies {
    ...
    annotationProcessor 'androidx.databinding:databinding-compiler:3.2.1'
}
```


DataBindingV2支持绑定LiveData

需要在gradle.properties中添加
```java
android.databinding.enableV2=true
```
### View层精简后

```java
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
```

### xml布局文件

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:android="http://schemas.android.com/apk/res/android">

    <data>
        <variable
            name="viewModel"
            type="com.glee.technology_sharing.sample.movie.MovieViewModel" />
    </data>

    <androidx.swiperefreshlayout.widget.SwipeRefreshLayou
        android:id="@+id/swipe"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        app:onRefresh="@{()->viewModel.getMovie()}"
        app:refresh_state="@{viewModel.refreshStateLiveData}">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">

            <TextView
                android:id="@+id/title"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_margin="10dp"
                android:text="@{viewModel.titleLiveData}"
                android:textSize="20sp" />

            <TextView
                android:id="@+id/summary"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_margin="10dp"
                android:text="@{viewModel.summaryLiveData}"
                android:textSize="20sp" />

            <ImageView
                android:id="@+id/image"
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"
                app:load_url="@{viewModel.imgLiveData}" />
        </LinearLayout>
    </androidx.swiperefreshlayout.widget.SwipeRefreshLayout>
</layout>
```


### DataBinding适配器

```java
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
```