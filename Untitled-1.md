# LiveData

LiveData是一个具有生命周期感知的可被观察的数据持有类
## LiveData的优势

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