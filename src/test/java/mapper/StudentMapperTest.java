package mapper;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import data.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：Mybatis_Plus插件之整合p6spy
 * Package(包名): mapper
 * Class(测试类名): StudentMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/4/7
 * Time(创建时间)： 20:00
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class StudentMapperTest
{
    @Test
    public void select() throws Exception
    {
        String resource = "mybatis-config.xml";
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream(resource);
        //根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(config);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> list = studentMapper.selectList(null);

        sqlSession.close();
    }

    @Test
    public void select1() throws Exception
    {
        String resource = "mybatis-config.xml";
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream(resource);
        //根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(config);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("class_no", 1002L);
        queryWrapper.eq("sex", "男");

        List<Student> list = studentMapper.selectList(queryWrapper);

        sqlSession.close();
    }
}