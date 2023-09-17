# 一、引言

web服务器：写的网站在web服务器上运行，相当于容器。如tomcat

# 二、tomcat

## 1.基本使用

- 先看的maven



### 1.启动

![image-20230903160713332](D:\学习资料\笔记\images\image-20230903160713332.png)

正常关闭比较好，涉及资源释放

### 2.修改配置

- <img src="D:\学习资料\笔记\images\image-20230903161548750.png" alt="image-20230903161548750" style="zoom:67%;" />
- 如果打不开，原因可能是**没启动tomcat**。而且修改了之后需要重新启动tomcat。
- tomcat是用java写的，所以电脑要配置java_home

### 3.部署项目

把文件夹or war包复制到webapps里

![image-20230903182832116](D:\学习资料\笔记\images\image-20230903182832116.png)

### 4.IDEA中创建maven web 项目



![image-20230903183942522](D:\学习资料\笔记\images\image-20230903183942522.png)

#### 4.1用骨架建

![image-20230903184932927](D:\学习资料\笔记\images\image-20230903184932927.png)

![image-20230903184955400](D:\学习资料\笔记\images\image-20230903184955400.png)

![image-20230903185057859](D:\学习资料\笔记\images\image-20230903185057859.png)

![image-20230903185133054](D:\学习资料\笔记\images\image-20230903185133054.png)

```html
<packageing>war</packaging>
*war：web项目打包方式
*默认是jar
```

#### 4.2不用骨架![image-20230903185706806](D:\学习资料\笔记\images\image-20230903185706806.png)



### 5.IDEA中使用tomcat＋部署项目(集成本地)

配置tomcat

- ![image-20230903190207305](D:\学习资料\笔记\images\image-20230903190207305.png)
- ![image-20230903190230124](D:\学习资料\笔记\images\image-20230903190230124.png)
- server自己选下载目录



部署项目到tomcat上

- <img src="D:\学习资料\笔记\images\image-20230903190336591.png" alt="image-20230903190336591" style="zoom:67%;" />

- <img src="D:\学习资料\笔记\images\image-20230903190444399.png" alt="image-20230903190444399" style="zoom: 50%;" />
- 最后部署失败，，因为名字里有下划线，然后我就把已经部署的项目全去掉了，只加了新创建的项目

启动项目

- <img src="D:\学习资料\笔记\images\image-20230903192251702.png" alt="image-20230903192251702" style="zoom:50%;" />
- 自动访问到这个地址：<img src="D:\学习资料\笔记\images\image-20230903192328484.png" alt="image-20230903192328484" style="zoom:50%;" />
- 在地址栏输入相对路径a.html即可访问a.html：<img src="D:\学习资料\笔记\images\image-20230903192426714.png" alt="image-20230903192426714" style="zoom:50%;" />

### 6.IDEA中用tomcat-maven插件部署项目

- ```html
  //pom.xml中
  <build>
      <plugins>
        <plugin>
          <groupId>org.apache.tomcat.maven</groupId>
          <artifactId>tomcat7-maven-plugin</artifactId>
          <version>2.2</version>
        </plugin>
        </plugins>
     </build>
  ```

- <img src="D:\学习资料\笔记\images\image-20230903194033581.png" alt="image-20230903194033581" style="zoom:67%;" />

- 如果右键没有"tomcat7:run"，[Maven Helper插件右键没有tomcat7:run 的解决方法_灵sa的博客-CSDN博客](https://blog.csdn.net/qq_48842471/article/details/128524227)

  

## 2.maven

![image-20230903164445383](D:\学习资料\笔记\images\image-20230903164445383.png)

### 1.maven默认的仓库地址![image-20230903165839085](D:\学习资料\笔记\images\image-20230903165839085.png)

因为在c盘，所以最好自己建一个



### 2.常用命令"mvn xxx"

- compile：编译
- clean：清理 删除target文件夹
- test：测试
- package：打包 在target文件夹中
- install：安装  下载到本地仓库文件夹

<img src="D:\学习资料\笔记\images\image-20230903171610089.png" alt="image-20230903171610089" style="zoom:67%;" />

在项目目录下用命令

### 3.maven生命周期

![image-20230903172000239](D:\学习资料\笔记\images\image-20230903172000239.png)

**同一生命周期内**，才会在执行后便命令时自动把本声明周期内前边的也执行了。E.G.执行install时，会自动执行compile,test,package（体现为多了targe文件夹&jar包等等



### 4.IDEA配置maven

坐标

![image-20230903172902923](D:\学习资料\笔记\images\image-20230903172902923.png)

2022版创建maven项目：

![image-20230903173731442](D:\学习资料\笔记\images\image-20230903173731442.png)

<img src="D:\学习资料\笔记\images\image-20230903173757584.png" alt="image-20230903173757584" style="zoom:67%;" />



导入maven文件：

<img src="D:\学习资料\笔记\images\image-20230903174151959.png" alt="image-20230903174151959" style="zoom:67%;" />



### 5.依赖管理

导包：

在pom.xml中写<u>**依赖坐标**</u>（就不用自己导包了）

<img src="D:\学习资料\笔记\images\image-20230903174930600.png" alt="image-20230903174930600" style="zoom:67%;" />

点刷新开始下载【写完or删完刷新】![image-20230903175008024](D:\学习资料\笔记\images\image-20230903175008024.png)

------

依赖范围：

![image-20230903175830230](D:\学习资料\笔记\images\image-20230903175830230.png)



# 三、servlet

## 1.概念

- 运行在服务器端的小程序。servlet是一个<u>接口</u>，定义了Java类被浏览器访问（tomcat识别）的规则
- 是javaEE规范之一（规范=>接口）
- 定义servlet类实现servlet接口，并由web服务器运行servlet
- 由tomcat创建，调用
- **看javaEE文档**
- 学java看JDK文档

## 2.快速入门

1.创建web项目

- 打开IDEA->用骨架建【之前学的】

- 部署，tomcat-maven插件【之前学的】

  ```
  <build>
      <plugins>
        <plugin>
          <groupId>org.apache.tomcat.maven</groupId>
          <artifactId>tomcat7-maven-plugin</artifactId>
          <version>2.2</version>
        </plugin>
        </plugins>
     </build>
  ```

- 【新内容】**导入servlet依赖**

  ```html
  
      <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>3.1.0</version>
        <scope>provided</scope>
      </dependency>
  ```

  -  <scope>**provided**</scope>作用范围仅在编译、测试时。

2. 定义一个类，**实现Servlet接口**，并重写方法
   - <u>ctrl+o:重写父类方法</u>

  

3.在类上方使用@WebServlet注解，配置该Servlet的访问路径

4.启动项目 并通过3中的路径访问

```java
mport javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
/***
 * servlet快速入门
 * ①导坐标：在pom.xml中加依赖，maven替人导包
 * ②重写接口所有方法
 * ③写访问路径
 * */


//注解,写访问路径
@WebServlet("/servlet01")
public class myServlet implements Servlet {//ctrl+o重写父类方法
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hello");//Servlet接口被访问时，service()会自动执行
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}

```



p.s若文件夹中无法new JAVA class，可右键

<img src="D:\学习资料\笔记\images\image-20230903231020117.png" alt="image-20230903231020117" style="zoom:50%;" />

## 3.执行流程

servlet对象由web服务器创建，并调用方法。

## 4.生命周期

<img src="D:\学习资料\笔记\images\image-20230905162543769.png" alt="image-20230905162543769" style="zoom: 67%;" />

![image-20230905162631767](D:\学习资料\笔记\images\image-20230905162631767.png)

- ②相当于提前了servlet对象创建的时间



```java
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "ServletDemo01", value = "/sy")
//value==urlPatterns访问路径
public class servletDemo01 implements Servlet {
    
    /**
     * 初始化方法
     * 1.调用时机：默认情况下，servlet第一次被访问的时候，创建对象并初始化
     * 2.一次
     * */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("--init--");
    }


    /**
 * 提供服务
 * 1.调用时机：每次请求servlet时都会调用
 * */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("***service****");
    }


    /**
     * 提供服务
     * 1.调用时机：内存释放或服务器关闭时，servlet对象会被销毁，调用destroy释放资源
     * 2.一次
     * */
    @Override
    public void destroy() {
        System.out.println("***service****");
    }
}
```

运行结果：按照“/sy”路径访问时（且刷新只调用了service，**init只调用一次**）

<img src="D:\学习资料\笔记\images\image-20230905170458009.png" alt="image-20230905170458009" style="zoom:67%;" />

销毁：需要正常关闭-->ctrl+c

- 利用terminal启动<img src="D:\学习资料\笔记\images\image-20230905170705103.png" alt="image-20230905170705103" style="zoom:50%;" />
- ctrl+c结束 -->调用destroy

## 5.servlet方法

<img src="D:\学习资料\笔记\images\image-20230905171242093.png" alt="image-20230905171242093" style="zoom:67%;" />

```java
@Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }
```

- 观察可知getServletConfig()返回一个ServletConfig类，且init()形参里有ServletConfig类----》**想在getServletConfig()里直接用init()类里的局部变量**--------》**扩大其作用域**
- - <img src="C:\Users\purin\AppData\Roaming\Typora\typora-user-images\image-20230905171629861.png" alt="image-20230905171629861" style="zoom:50%;" />`定义私有成员config`
  - <img src="D:\学习资料\笔记\images\image-20230905171652577.png" alt="image-20230905171652577" style="zoom:50%;" />用形参给私有成员config赋值
  - <img src="D:\学习资料\笔记\images\image-20230905171717789.png" alt="image-20230905171717789" style="zoom:50%;" />返回私有成员

## 6.servlet体系结构

<img src="D:\学习资料\笔记\images\image-20230905172216846.png" alt="image-20230905172216846" style="zoom: 50%;" />

- 开发B/S架构的web项目，都是针对HTTP协议，所以自定义**继承HttpServlet**的Servlet类



get：

<img src="D:\学习资料\笔记\images\image-20230905173053182.png" alt="image-20230905173053182" style="zoom:50%;" />

<img src="D:\学习资料\笔记\images\image-20230905173104761.png" alt="image-20230905173104761" style="zoom:50%;" />

post：

①写了个表单利用post方式发送

```html
<html>
<body>
    <form action="http://localhost:8080/servlet02/Demo02" method="post">
        <input name="username">
        <input type="submit">
    </form>

</body>
</html>
```

②<img src="D:\学习资料\笔记\images\image-20230905173952234.png" alt="image-20230905173952234" style="zoom:67%;" />

③随便写点点提交后，以post的方式访问demo02了。控制台：<img src="D:\学习资料\笔记\images\image-20230905174105047.png" alt="image-20230905174105047" style="zoom:67%;" />





urlPatterns匹配方式

<img src="D:\学习资料\笔记\images\image-20230905175406502.png" alt="image-20230905175406502" style="zoom:67%;" />



## 7.request

![image-20230905180113156](D:\学习资料\javaweb\image-20230905180113156.png)

### 7.1request继承体系

![image-20230905180239098](D:\学习资料\笔记\images\image-20230905180239098.png)

![image-20230905180709056](D:\学习资料\笔记\images\image-20230905180709056.png)

### 7.2获取请求数据

![image-20230905181824430](D:\学习资料\笔记\images\image-20230905181824430.png)

- get方式获取请求参数：用getQueryString()

- post方式用输入流

- request***通用的请求参数方法***①(在**doPost,doGet都能用**)

  - ![image-20230905184136025](D:\学习资料\笔记\images\image-20230905184136025.png)
  - 参数是形如“username=lihua&hobby=1&hobby=2”的形式。request把各个分离出来，利用map**集合**(key，value)存储，key数据类型为string，value类型为string[]
  - ![image-20230905184414188](D:\学习资料\笔记\images\image-20230905184414188.png)

  

1.getParameterMap()

```java
/****
         * getParameterMap
         */
        Map<String,String[]> map=request.getParameterMap();
        //遍历
        for(String key:map.keySet()){
            System.out.println(key);

            String values[]=map.get(key);//String[]
            for(String val:values){
                System.out.print(val+" ");
            }

            System.out.println();
        }
```

```html
<html>
<body>
<form action="http://localhost:8080/servlet02/Demo03" method="get">
    <input name="username">
    <input type="checkbox" name="hobby" value="1">music
    <input type="checkbox" name="hobby" value="2">kpop
    <input type="submit">
</form>
</body>
</html>
```

流程：访问a1.html,提交后![image-20230905190820649](D:\学习资料\笔记\images\image-20230905190820649.png)terminal显示![image-20230905190754281](D:\学习资料\笔记\images\image-20230905190754281.png)

2.根据key返回<img src="D:\学习资料\笔记\images\image-20230905190959501.png" alt="image-20230905190959501" style="zoom:67%;" />

- get、post**通用请求参数方法②**
  - 在doPost中调用doGet
  - ![image-20230905191357735](D:\学习资料\笔记\images\image-20230905191357735.png)

### 7.3请求转发

<img src="D:\学习资料\笔记\images\image-20230905200951517.png" alt="image-20230905200951517" style="zoom: 50%;" />

<img src="D:\学习资料\笔记\images\image-20230905201108474.png" alt="image-20230905201108474" style="zoom:50%;" />



## 8.请求参数中文乱码

### 8.1GET

![image-20230905200021643](D:\学习资料\笔记\images\image-20230905200021643.png)

### 8.2POST

![image-20230905192253199](D:\学习资料\笔记\images\image-20230905192253199.png)

**<u>历史遗留问题：</u>**

应该第一行乱码，第二行汉字，但terminal两行一样，且都是不认识的字符，也没搜出来是什么编码方式。。。。。

![image-20230905200302424](D:\学习资料\笔记\images\image-20230905200302424.png)

a1.html

```html
<html>
<body>
<form action="http://localhost:8080/servlet02/Demo04" method="get">
    <input name="username">
    <input type="checkbox" name="hobby" value="1">music
    <input type="checkbox" name="hobby" value="2">kpop
    <input type="submit">
</form>
</body>
</html>
```

```java
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "ServletDemo4luanMa", value = "/Demo04")
public class ServletDemo4luanMa extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        System.out.println(username);
        //1.把已知的乱码(iso_xxx编码)转换成二进制
        byte[] bs =username.getBytes(StandardCharsets.ISO_8859_1);
        //2.二进制转字符串，new时用字节数组做参数
        String s=new String(bs,StandardCharsets.UTF_8);
        System.out.println(s);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

```

## 9.reponse

![image-20230905201227868](D:\学习资料\笔记\images\image-20230905201227868.png)

![image-20230905202109390](D:\学习资料\笔记\images\image-20230905202109390.png)

