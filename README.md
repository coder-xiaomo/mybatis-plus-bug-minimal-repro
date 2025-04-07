# mybatis-plus bug 最小复现项目 ([issue 6662](https://github.com/baomidou/mybatis-plus/issues/6662#issuecomment-2781540430))

数据库：
MySQL, 初始化脚本见 testdb.sql

打包命令：

```bash
mvn -DskipTests=true clean package
```

运行命令：

```bash
java -jar ./target/backend-0.0.1-SNAPSHOT.jar
```

请求：

```bash
# 接口见 DemoController.java
curl http://127.0.0.1:8080/issue

# 备注：
# IDEA 运行时正常
# 打成 jar 包后报错如下
```


```
java.util.concurrent.CompletionException: com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: Please add specific implementation dependencies or use the setCompatibleSet method to specify
        at java.base/java.util.concurrent.CompletableFuture.encodeThrowable(CompletableFuture.java:315)
        at java.base/java.util.concurrent.CompletableFuture.completeThrowable(CompletableFuture.java:320)
        at java.base/java.util.concurrent.CompletableFuture$AsyncRun.run(CompletableFuture.java:1807)
        at java.base/java.util.concurrent.CompletableFuture$AsyncRun.exec(CompletableFuture.java:1796)
        at java.base/java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:373)
        at java.base/java.util.concurrent.ForkJoinPool$WorkQueue.topLevelExec(ForkJoinPool.java:1182)
        at java.base/java.util.concurrent.ForkJoinPool.scan(ForkJoinPool.java:1655)
        at java.base/java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1622)
        at java.base/java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:165)
Caused by: com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: Please add specific implementation dependencies or use the setCompatibleSet method to specify
        at com.baomidou.mybatisplus.core.toolkit.ExceptionUtils.mpe(ExceptionUtils.java:49)
        at com.baomidou.mybatisplus.core.toolkit.Assert.isTrue(Assert.java:38)
        at com.baomidou.mybatisplus.extension.spi.CompatibleHelper.getCompatibleSet(CompatibleHelper.java:75)
        at com.baomidou.mybatisplus.extension.toolkit.SqlHelper.executeBatch(SqlHelper.java:186)
        at com.baomidou.mybatisplus.extension.toolkit.SqlHelper.executeBatch(SqlHelper.java:209)
        at com.baomidou.mybatisplus.extension.repository.AbstractRepository.executeBatch(AbstractRepository.java:107)
        at com.baomidou.mybatisplus.extension.repository.CrudRepository.saveBatch(CrudRepository.java:61)
        at com.baomidou.mybatisplus.extension.service.IService.saveBatch(IService.java:41)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:568)
        at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:359)
        at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:196)
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)
        at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:380)
        at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:119)
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)
        at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:727)
        at com.example.backend.service.impl.UserServiceImpl$$SpringCGLIB$$0.saveBatch(<generated>)
        at com.example.backend.controller.DemoController.lambda$issue$0(DemoController.java:53)
        at java.base/java.util.concurrent.CompletableFuture$AsyncRun.run(CompletableFuture.java:1804)
        ... 6 more
java.util.concurrent.CompletionException: com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: Please add specific implementation dependencies or use the setCompatibleSet method to specify
        at java.base/java.util.concurrent.CompletableFuture.encodeThrowable(CompletableFuture.java:315)
        at java.base/java.util.concurrent.CompletableFuture.completeThrowable(CompletableFuture.java:320)
        at java.base/java.util.concurrent.CompletableFuture$AsyncRun.run(CompletableFuture.java:1807)
        at java.base/java.util.concurrent.CompletableFuture$AsyncRun.exec(CompletableFuture.java:1796)
        at java.base/java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:373)
        at java.base/java.util.concurrent.ForkJoinPool$WorkQueue.topLevelExec(ForkJoinPool.java:1182)
        at java.base/java.util.concurrent.ForkJoinPool.scan(ForkJoinPool.java:1655)
        at java.base/java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1622)
        at java.base/java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:165)
Caused by: com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: Please add specific implementation dependencies or use the setCompatibleSet method to specify
        at com.baomidou.mybatisplus.core.toolkit.ExceptionUtils.mpe(ExceptionUtils.java:49)
        at com.baomidou.mybatisplus.core.toolkit.Assert.isTrue(Assert.java:38)
        at com.baomidou.mybatisplus.extension.spi.CompatibleHelper.getCompatibleSet(CompatibleHelper.java:75)
        at com.baomidou.mybatisplus.extension.toolkit.SqlHelper.executeBatch(SqlHelper.java:186)
        at com.baomidou.mybatisplus.extension.toolkit.SqlHelper.executeBatch(SqlHelper.java:209)
        at com.baomidou.mybatisplus.extension.repository.AbstractRepository.executeBatch(AbstractRepository.java:107)
        at com.baomidou.mybatisplus.extension.repository.CrudRepository.saveBatch(CrudRepository.java:61)
        at com.baomidou.mybatisplus.extension.service.IService.saveBatch(IService.java:41)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:568)
        at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:359)
        at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:196)
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)
        at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:380)
        at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:119)
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)
        at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:727)
        at com.example.backend.service.impl.UserServiceImpl$$SpringCGLIB$$0.saveBatch(<generated>)
        at com.example.backend.controller.DemoController.lambda$issue$0(DemoController.java:53)
        at java.base/java.util.concurrent.CompletableFuture$AsyncRun.run(CompletableFuture.java:1804)
        ... 6 more
```