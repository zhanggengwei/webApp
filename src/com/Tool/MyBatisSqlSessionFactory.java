package com.Tool;
import com.UserInfo.Entity.UserInfoEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import java.io.*;
/**
 * Created by vd on 2017/7/30.
 */
public class MyBatisSqlSessionFactory {
    private static SqlSessionFactory sqlSessionFactory;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
    static{
        try {
            InputStream inputStream = Resources.getResourceAsStream("conf.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            System.out.println(inputStream+"---->");
        } catch (IOException e) {
            // TODO: handle exception
            e.getSuppressed();
            throw new RuntimeException(e);
        }
    }
    public static SqlSession openSession() {
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession==null) {
            sqlSession = sqlSessionFactory.openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }
    public static void closeSqlSession() {
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession!=null) {
            sqlSession.close();
            threadLocal.remove();
        }
    }
    private MyBatisSqlSessionFactory() {
        // TODO Auto-generated constructor stub
    }

}
