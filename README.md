# attemper-samples

- 任务调度中心[attemper](https://github.com/attemper/attemper)的Demo项目
  - `attemper-samples-spring-boot`: Spring Boot框架
  - `attemper-samples-spring`: Spring MVC框架

## Http任务

* [同步任务](./attemper-samples-task/src/main/java/com/github/attemper/samples/task/demo001) - 执行器与业务应用保持同步

* [异步任务](./attemper-samples-task/src/main/java/com/github/attemper/samples/task/demo002) - 业务应用需回调执行器

* [直接调用URL地址](./attemper-samples-task/src/main/java/com/github/attemper/samples/task/demo003) - 需配置URL地址和协议方法(默认`POST`)