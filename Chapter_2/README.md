# Binder

## Binder 的使用

假设两个进程之间进行通信, 它们分别是Server和Client.
现在Server要提供一个服务供Client使用. 这个服务对应一个接口称为IService.
显然Server要实现IService接口, 然后Client要能够调用它. 那这个任务就落在了Binder身上.
要说Binder实现这个接口不是很准确, 准确的来说是定义了一个ServiceImp, 它既继承了Binder又实现了IService.
不仅如此ServeceImp内部还有一个Proxy内部类.

1. Server需要提供服务由Binder实现, Client可以获取到Binder对象然后调用服务.(中间的数据传输已经被Android系统封装好了)
2. Binder可以传输Binder对象, 这样进程之间服务的调用就是双向的
3. Binder归属于特定进程
4. Binder中的方法运行在Binder线程池中, 所以如果要更新UI可能需要借助于Hander, 同样如果在UI线程中发起远程服务调用最好也要开启在子线程中进行.

## Binder 的实现

涉及 Server, Client, Service Manager, Binder驱动

源码涉及cpp代码
