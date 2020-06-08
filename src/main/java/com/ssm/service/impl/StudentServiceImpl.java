package com.ssm.service.impl;

import com.ssm.beans.Student;
import com.ssm.service.StudentService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class StudentServiceImpl implements StudentService {
    private SqlSession sqlSession;
    @Override
    public void insertStudent(Student students) {
        try {
            //1.加载主配置文件
            InputStream inputstream= Resources.getResourceAsStream("mybatis.xml");
            //2.创建会话工厂，传入mybatis的配置文件信息
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
            //3.通过工厂得到SqlSession
            sqlSession = sqlSessionFactory.openSession();
            //4.相关操作
            int exeRes = sqlSession.insert("addStudent",students);
            sqlSession.commit();
            System.out.println("输出执行返回："+exeRes);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    @Override
    public Student getStudentById(int id) {
        Student student = null;
        try {
            //Mybatis提供的工具类方法，快速加载资源文件
            Reader reader=Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
            sqlSession=sqlSessionFactory.openSession();
            student = sqlSession.selectOne("getStudentById", id);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
        return student;
    }

    @Override
    public void delStudentById(int id) {
        try {
            InputStream inputStream=Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            int exeRes = sqlSession.delete("delStudentById",id);
            sqlSession.commit();
            System.out.println("输出执行结果："+exeRes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    @Override
    public void updStudent(Student student) {
        try {
            InputStream inputStream=Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            int exeRes = sqlSession.update("updStudent",student);
            sqlSession.commit();
            System.out.println("输出执行结果："+exeRes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }


}
