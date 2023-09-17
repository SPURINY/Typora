

# [Spring Framework Tutorial | Full Course - YouTube](https://www.youtube.com/watch?v=If1Lw4pLLEo)

## 1.报错集：

1.![image-20230916174613321](images\image-20230916174613321.png)

一开始class属性爆红，cannot resolve class or package ppr和cannot resolve class Car

solution:一开始用的ppr.Car当<img src="images\image-20230916174738428.png" alt="image-20230916174738428" style="zoom:50%;" />，因为建包的时候右键new没有package

- 在蓝色文件夹(Sources Root)右键就可以建包了<img src="images\image-20230916174913472.png" alt="image-20230916174913472" style="zoom: 50%;" />

2.![image-20230916180344013](images\image-20230916180344013.png)

solution:

**因为在 Idea 中，编译器只会把 src/main/java 也就是源代码目录下的 <u>.java</u> 文件编译成 .class 文件然后放到 target 目录中，其他的默认不会。**

- 把spring.xml复制一份放到target/classes目录下



3.![image-20230916190123485](images\image-20230916190123485.png)

solution:可以看出我写错地方了(classes\spring.xml)，写在”java\spring.xml“就解决了



4.<img src="images\image-20230917101907146.png" alt="image-20230917101907146" style="zoom:67%;" />

solution：漏了对括号

![image-20230917101935586](images\image-20230917101935586.png)



## 2.codes

### 1.Dependency injection

<img src="images\image-20230916180653253.png" alt="image-20230916180653253" style="zoom:33%;" />

```xml
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>4.2.4.RELEASE</version>
    </dependency>
    ---------------pom.xml-------------------
    --------------spring.xml--------------------
        <bean id="vehicle" class="com.ppr.Car"></bean>
```

```java
package com.ppr;

public interface Vehicle {
    public void drive();
}

```

```java
package com.ppr;

public class Car implements Vehicle{
    @Override
    public void drive() {
        System.out.println("car is running");
    }
}

```

```java
package com.ppr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[]args){
        ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
       Vehicle vehicle=(Vehicle) context.getBean("vehicle");
       vehicle.drive();
    }
}

```

![image-20230916180822507](images\image-20230916180822507.png)

- `ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");`
         `Vehicle vehicle=(Vehicle) context.getBean("vehicle");`//objext->Vehicle

- **过去想用别的接口实现类得在main方法里改，耦合高＋得重新编译测试。现在只需在pring.xml文档中`class="com.ppr.Car“`,把Car改成其他实现类即可。**

### 2.< property>属性/成员（Setter injection

```java
public class Tyre {
    private String brand;//成员/属性
    @Override
    public String toString() {
        return "Tyre{" +
                "brand='" + brand + '\'' +
                '}';
    }
}

```

```xml
<bean id="tyre" class="com.ppr.Tyre">
        <property name="brand" value="test"></property>
    </bean>
```

- **相当于setter**

### 3.constructor injection

- < constructor-arg>

```java
 public Tyre() {//无参构造

    } 
public Tyre(String brand) {//加了构造器
        this.brand = brand;
    }
```

```xml
<bean id="tyre" class="com.ppr.Tyre">
        <constructor-arg value="aaa"></constructor-arg>
 </bean>
```

### 4.Annotation|configuration| Bean

---------------------------E.G.1---------------------------------------

```java
public class Samsung {
    public void config(){
        System.out.println("samsung--config--method--");
    }
}
```

```java
public class App //主方法
{
    public static void main( String[] args )
    {
        ApplicationContext factory= new AnnotationConfigApplicationContext(AppConfig.class);
        Samsung s1=factory.getBean(Samsung.class);
        s1.config();
    }
}
```

```java
@Configuration
public class AppConfig {
    @Bean
    public Samsung setSamsung(){
        return new Samsung();
    }

}
```

![image-20230917100602103](images\image-20230917100602103.png)

- ```
  ApplicationContext factory= new AnnotationConfigApplicationContext(AppConfig.class);
   Samsung s1=factory.getBean(Samsung.class);
  ```

  - AppConfig是配置类，**@Configuration**,相当于xml配置文件
  - @Bean，表示一个bean,相当于< bean/>





-------------------------------E.G.2----自动连线/装载（**@Autowired**)------------------------------------------

```jade
public class Samsung {
   
    private Processor cpu;//属性

    public Processor getCpu() {
        return cpu;
    }
    public void setCpu(Processor cpu) {
        this.cpu = cpu;
    }

    public void config(){
        System.out.println("samsung--config--method--");
        cpu.run();
    }
}
```

```java
@Configuration
public class AppConfig {
    @Bean
    public Samsung setSamsung(){
        return new Samsung();
    }

    @Bean
    public Processor getCpu (){
        return new BestProcessor();
    }

}
```

```java
public interface Processor {//处理器接口
    public void run();
}
```

```java
public class BestProcessor implements Processor{
//接口实现类
    @Override
    public void run() {
        System.out.println("^^i am best cpu~~");
    }
}
```

![image-20230917102248712](images\image-20230917102248712.png)

- 由报错可知：AppConfig类的getCpu()并没能把new的对象给传过去。
- - <u>***@Autowired**</u>*

- <img src="images\image-20230917102552600.png" alt="image-20230917102552600" style="zoom:67%;" />



### 5. Annotation|Component

可以在config类中不写具体的Bean

- config类+注解：

  - `@ComponentScan(basePackages = "org.example")`

- bean对应的类上面加注解：`@Component`

  - 默认bean id为类名+第一个字母小写
  - 自定义bean id: Component("xxx")

  ```java
  @Configuration
  @ComponentScan(basePackages = "org.example")
  public class AppConfig {
     /* @Bean
      public Samsung setSamsung(){
          return new Samsung();
      }
  
      @Bean
      public Processor getCpu (){
          return new BestProcessor();
      }
  */
  }
  ```

```java
@Component
public class Samsung {。。。。。。}
```

```java
@Component
public class BestProcessor implements Processor{
    。。。}
```

### 6.Annotation|Primary &Qualifier

- 如果在5.的code基础上加一个Processor接口实现类SecondProcessor

- ```java
  @Component
  public class SecondProcessor implements Processor{
      @Override
      public void run() {
          System.out.println("&&2nd CPU**");
      }
  }
  ```

报错：Caused by: org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'org.example.Processor' available: expected single matching bean but found 2: bestProcessor,secondProcessor

- <u>**solution1：@Primary**</u>
- - 指明两个实现类谁的优先级更高，即new该类的bean
  - 使用与 `@Primary` 注释关联的 **bean** 。
  - ![image-20230917105520476](images\image-20230917105520476.png)



- **<u>solution2：@Qualifier("bean的id")</u>**
  - 自动装配(@Autowired)的时候
  - <img src="images\image-20230917110402193.png" alt="image-20230917110402193" style="zoom:67%;" />
  - ps：一开始写的SecondP...报错，改小写(默认bean的id)就ok了
  - <img src="C:\Users\purin\AppData\Roaming\Typora\typora-user-images\image-20230917110529776.png" alt="image-20230917110529776" style="zoom:67%;" />

