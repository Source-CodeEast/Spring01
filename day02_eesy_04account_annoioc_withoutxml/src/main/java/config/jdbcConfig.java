package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * 和Sping连接数据库相关的配置类
 *
 * */

//@Configuration 当他没有在获取容器时将字节码文件传入时就需要将它定义为配置类让他扫描包,当然也可以使用Import导入其他配置类
public class jdbcConfig {

//    获取jdbcConfig.properties中的各个配置文件
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    /**
     *
     * 用于创建QueryRunner对象
     *
     * */
    @Bean(name = "runner")
    @Scope("prototype") //注意这里要是多例对象
    public QueryRunner createQueryRuner(@Qualifier("ds2")DataSource dataSource){
        return new QueryRunner(dataSource);
    }

//    创建源对象
    @Bean(name = "ds2")
    public DataSource createDataSource(){
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
            return ds;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    @Bean(name="ds1")
    public DataSource createDataSource1() {
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/eesy02");
            ds.setUser(username);
            ds.setPassword(password);
            return ds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
