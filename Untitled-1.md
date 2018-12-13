# 使用Android Architecture Components构建MVVM应用

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

### Transformations#map 

例

```java
//下载进度LiveData
MutableLiveData<Integer> progressLiveData = new MutableLiveData<>();

//下载进度文字描述LiveData
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