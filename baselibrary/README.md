# AndroidBaseLibrary

项目内容介绍
#### 一： BaseLibrary
BaseLibrary：只封装通用的代码，与项目无关。可以放到任何一个项目使用。

#### 二： CommonLibrary
CommonLibrary：封装项目有关的代码，可以给各个模块使用。  
 
包括：1、所有的bean对象 2、网络请求接口 3、页面路由跳转

#### 三： 应用层



#### 一： 设置application主题 
如果activity继承了BaseToolBarActivity，那么application主题要添加如下属性：

```
  <item name="windowActionBar">false</item>
  <item name="windowNoTitle">true</item>
```

#### 二：关于launchstarter介绍 
简介：异步和延迟初始化启动器，可以理解为APP启动优化的工具类。
使用场景：

1：对于可以异步初始化的任务：我们可以使用异步启动器在Application的onCreate方法中执行加载。

2：对于不能异步执行的，但不是必须在onCreate完成前执行的，我们可以利用延迟启动器进行加载。

使用方法见：
