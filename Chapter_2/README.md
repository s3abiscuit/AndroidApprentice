# IPC

假设两个进程之间进行通信, 它们分别是Server和Client.
现在Server要提供一个服务供Client使用. 这个服务对应一个接口称为IService.
显然Server要实现IService接口, 然后Client要能够调用它. 那这个任务就落在了Binder身上.
要说Binder实现这个接口不是很准确, 准确的来说是定义了一个ServiceImp, 它既继承了Binder又实现了IService.
