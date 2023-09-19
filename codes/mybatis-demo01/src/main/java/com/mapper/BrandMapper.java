package com.mapper;

import com.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    /**
     * 查询所有
     */
    List<Brand> selectAll();
    /*
    * 查看详情(即根据id查询——有参数：id)
    * */
    Brand selectById(int id);

    /*多条件查询
    * */
    //法一：List<Brand> selectByCondition(@Param("status")int status,@Param("companyName")String companyName,@Param("brandName") String brandName);
    //法二：List<Brand> selectByCondition(Brand brand);//把参数封装成一个brand对象
    List<Brand> selectByCondition(Map map);
    /*动态多条件*/
    List<Brand> selectByDynamiteConditionIf(Map map);
    /*
    * 插入
    * */
    void add(Brand brand);
}
