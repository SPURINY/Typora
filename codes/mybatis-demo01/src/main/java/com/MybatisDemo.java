package com;

import com.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.imageio.IIOException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/***
 * 测试类
 * mybatis快速入门
 */

public class MybatisDemo {
    public static void main(String []args)  throws IOException {
        //1.加载mybatis核心配置文件，获取SqlSessionFactory对象（从官网复制的
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取SqlSession对象(用它执行sql语句
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //3.执行sql语句         (alt+enter自动引导，即等号及左边都是自动生成的
        List<User> users = sqlSession.selectList("test.selectAll");
        System.out.println(users);
        //4.释放资源
        sqlSession.close();
    }
}
