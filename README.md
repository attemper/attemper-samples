# attemper-samples

- 任务调度中心[attemper](https://github.com/attemper/attemper)的Demo项目
  - `attemper-samples-spring-boot`: Spring Boot框架集成的例子
  - `attemper-samples-spring`: Spring MVC框架集成的例子

## Http任务

* [同步任务](./attemper-samples-task/src/main/java/com/github/attemper/samples/task/demo001) - 执行器与业务应用保持同步

* [异步任务](./attemper-samples-task/src/main/java/com/github/attemper/samples/task/demo002) - 业务应用需回调执行器

* [直接调用URL地址](./attemper-samples-task/src/main/java/com/github/attemper/samples/task/demo003) - 需配置URL地址和协议方法(默认`POST`)

## 接收参数的Http任务

* [实体类接收参数](./attemper-samples-task/src/main/java/com/github/attemper/samples/task/demo020) - 参数在调度中心定义，执行时传给业务应用(反射为对象)

* [Map接收参数](./attemper-samples-task/src/main/java/com/github/attemper/samples/task/demo021) - 参数在调度中心定义，执行时传给业务应用(反射未Map)

## 高级

* [并发任务](./attemper-samples-task/src/main/java/com/github/attemper/samples/task/demo050) - 多个节点并发执行

* [判断条件改变节点走向](./attemper-samples-task/src/main/java/com/github/attemper/samples/task/demo051) - 根据前置节点的执行结果，决定后续节点的走向

* [父子任务](./attemper-samples-task/src/main/java/com/github/attemper/samples/task/demo052) - 父任务引用子任务(可向其传参) 

## 其他
* [延迟任务](./attemper-samples-task/src/main/java/com/github/attemper/samples/task/demo300) - 调用调度中心API设置任务的触发器 