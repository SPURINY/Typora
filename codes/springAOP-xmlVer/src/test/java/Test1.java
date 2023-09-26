import com.calculator.Config;
import com.calculator.infer.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    ApplicationContext ioc= new ClassPathXmlApplicationContext("applicationContext.xml");
    /*AnnotationConfigApplicationContext构造函数中传入的参数应该是配置类的类对象，
      而不是配置类的名称。所以您需要将"Config.class"修改为Config.class。*/
    @Test
    public void test(){
       Calculator bean= ioc.getBean(Calculator.class);
       bean.add(1,1);

       bean.div(3,0);
    }
}
