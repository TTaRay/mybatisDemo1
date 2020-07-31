package com.ssm.test;

import com.ssm.dao.StudentDao;
import com.ssm.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws Exception {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产一个SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象   (对象被增强，可以实现功能！)
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        //5.使用代理对象执行方法
        List<Student> list = studentDao.findAll();
        for (Student stu:list){
            System.out.println(stu);
        }
        //6.释放资源
        sqlSession.close();
        in.close();
    }
}
