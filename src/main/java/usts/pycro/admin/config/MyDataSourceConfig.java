package usts.pycro.admin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-05 6:01 PM
 */
@Deprecated
//@Configuration
public class MyDataSourceConfig {
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        //druidDataSource.setUrl();
        //druidDataSource.setUsername();
        //druidDataSource.setPassword();
        //druidDataSource.setDriverClassName();
        //加入监控功能
        //druidDataSource.setFilters("stat,wall");

        //druidDataSource.setMaxActive(12);
        return druidDataSource;
    }

    /**
     * 配置druid的监控页功能
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(statViewServlet, "/druid/*");
        registrationBean.addInitParameter("loginUsername","admin");
        registrationBean.addInitParameter("loginPassword","123456");
        return registrationBean;
    }

    /**
     * webStatFilter 用于采集web-jdbc关联监控的数据
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        filterFilterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterFilterRegistrationBean;
    }
}
