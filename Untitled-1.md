# 标题

本文主要阐述了Android Architecture Components在MVVM设计架构中的应用

## Android MVVM

MVVM（Model-View-ViewModel）设计架构旨在将图形用户界面与业务逻辑的开发分离开来，核心思想为**数据驱动视图**

![](https://github.com/GLee9507/Technology-sharing/raw/master/img/mvvm2.PNG)

- **Model**

  Model表示应用程序的数据访问层，在Android中可以为本地数据库或远程服务器

- **ViewModel**
  
  ViewModel，处理业务逻辑并且提供可观察数据。Android Architecture Components 为我们提供了**ViewModel**实现，和可观察数据的实现——**LiveData**  

  该层的一个重要实现策略是将其与View分离，即ViewModel不应该意识到与之交互的View，官方明确表示ViewModel不可引用任何View或者Activity Context

- **View**
  
  View把UI事件传递到ViewModel，ViewModel做出具体业务逻辑处理并更新数据

  View通过订阅ViewModel中的数据，在数据变更时更新UI

  在Android中View层为Activity或Fragment



## ViewModel

### 构造ViewModel

```java
public class TestFragment extends Fragment {

    ……

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainViewModel = ViewModelProviders.of(this).get(TestViewModel.class);
    }

    ……

}
```

### ViewMode生命周期
![](https://github.com/GLee9507/Technology-sharing/raw/master/img/viewmodel-lifecycle.png)

## LiveData

LiveData是一个具有生命周期感知的可被观察的数据持有类
### LiveData的优势

1. **避免内存泄漏**  
    当观察者的生命周期为Destroyed时，LiveData会把观察者的引用移除掉

2. **避免因生命周期造成的崩溃**  
    如果观察者的生命周期处于非活动状态时，不会收到LiveData事件

3. **提升UI性能**  
    当LiveData数据更新时，只有处于活动状态的观察者才会收到LiveData事件更新UI，而不是每次数据变更均更新UI

4. **共享资源**  
    多个观察者可以同时观察同一个LiveData，例如NetWorkStatusLiveData等

5. **视图与数据分离**  
    如果一个Activity或者Fragment因为配置变化而重新创建，例如设备旋转，它会立刻收到最新的可用数据

![](https://user-gold-cdn.xitu.io/2018/11/26/1674da659ba72b84?imageView2/0/w/1280/h/960/format/webp/ignore-error/1) 


## MutableLiveData基本用法（略）
……
## Transformations#map 