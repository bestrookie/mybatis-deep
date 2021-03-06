package com.bestrookie;

import com.bestrookie.pojo.DepartmentPojo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author bestrookie
 * @date 2021/12/1 10:33 上午
 */
public class TestApi {
    public static void main(String[] args) throws Exception {
        InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<DepartmentPojo> departmentList = sqlSession.selectList("departmentMapper.findAll");
        departmentList.forEach(System.out::println);
    }
}
