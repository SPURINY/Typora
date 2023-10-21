import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class test1 {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
    @Test
    public void test03(){//批量插入
        String sql="INSERT INTO t_user(userId,password) VALUES(?,?)";
        List<Object[]>objects = new ArrayList<Object[]>();
        objects.add(new Object[] {"lihua", "123445"});
        objects.add(new Object[] {"mary", "123445"});
        objects.add(new Object[] {"lux", "123445"});
        jdbcTemplate.batchUpdate(sql,objects);
    }
    @Test
    public void test02(){
        String sql="update t_user SET password=? WHERE userId=?";
        int update = jdbcTemplate.update(sql, "123", "1001");
        System.out.println("更新用户"+update);
    }
    @Test
    public void test() throws SQLException {
        DataSource bean = ioc.getBean(DataSource.class);
        Connection connection = bean.getConnection();
        System.out.println(connection);
        connection.close();
    }
    @Test
    public void test01() throws SQLException {

        System.out.println(jdbcTemplate);

    }
}
