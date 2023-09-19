package com.test;

import com.mapper.BrandMapper;
import com.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    @Test
    public void testSelectAll() throws IOException {
        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取sqlSession
        SqlSession session = sqlSessionFactory.openSession();
        //3.获取Mapper代理对象
        BrandMapper brandMapper=session.getMapper(BrandMapper.class);
        //4.执行sql
        List<Brand> brands=brandMapper.selectAll();
        System.out.println(brands);
        //5.释放资源
        session.close();
    }
    @Test
    public void testSelectById() throws IOException {
        int id=1;

        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取sqlSession
        SqlSession session = sqlSessionFactory.openSession();
        //3.获取Mapper代理对象
        BrandMapper brandMapper=session.getMapper(BrandMapper.class);
        //4.执行sql
        Brand brand=brandMapper.selectById(id);
        System.out.println(brand);
        //5.释放资源
        session.close();
    }

    @Test
    public void testSelectByCondition() throws IOException {
        //接收参数
        int status=1;
        String companyName="ttt";
        String brandName="ttt";
        //处理参数（因为sql模糊查询 LIKE '%John%';
        companyName="%"+companyName+"%";
        brandName="%"+brandName+"%";
        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取sqlSession
        SqlSession session = sqlSessionFactory.openSession();
        //3.获取Mapper代理对象
        BrandMapper brandMapper=session.getMapper(BrandMapper.class);
        //4.执行sql
        /*法一：List<Brand> brands = brandMapper.selectByCondition(status,companyName,brandName);*/
        /*法二：Brand brand=new Brand();
        brand.setStatus(status);
        brand.setBrandName("brandName");
        brand.setCompanyName("companyName");
        List<Brand> brands = brandMapper.selectByCondition(brand);
        System.out.println(brands);*/
        Map map = new HashMap();
        //map.put("status" , status);
        map.put("companyName", companyName);
        map.put("brandName" , brandName);
        List<Brand> brands = brandMapper.selectByDynamiteConditionIf(map);
        System.out.println(brands);
        //5.释放资源
        session.close();
    }
    @Test
    public void add() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "手机中的战斗机";
        int ordered = 100;

        //封装对象（除id外，因为id自增
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取sqlSession
        SqlSession session = sqlSessionFactory.openSession();
        //3.获取Mapper代理对象
        BrandMapper brandMapper=session.getMapper(BrandMapper.class);
        //4.执行sql
       brandMapper.add(brand);
        System.out.println(brand.getId());
        session.commit();//提交事务【不过不知道为什么我的很多日志底下都没显示，比如事务回滚就没
        //5.释放资源
        session.close();
    }

}
