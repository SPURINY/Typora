package com;

import com.mapper.UserMapper;
import com.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/***
 * 测试类
 * Mapper代理开发入门
 */

public class MybatisDemo2 {
    public static void main(String []args)  throws IOException {
        //1.加载mybatis核心配置文件，获取SqlSessionFactory对象（从官网复制的
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取SqlSession对象(用它执行sql语句
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //3.执行sql语句         (alt+enter自动引导，即等号及左边都是自动生成的
        //List<User> users = sqlSession.selectList("test.selectAll");
        //3.1把UserMapper接口类型传进去，获取一个代理接口
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //3.2通过代理接口调用方法
        List<User> users = userMapper.selectAll();
        System.out.println(users);
        //4.释放资源
        sqlSession.close();
    }
}
