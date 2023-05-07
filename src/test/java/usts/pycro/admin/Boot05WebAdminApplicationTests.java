package usts.pycro.admin;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class Boot05WebAdminApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
        String sql = "select count(*) from t_emp";
        Long cnt = jdbcTemplate.queryForObject(sql, Long.class);

        log.info("数据源：{}",dataSource.getClass().getSimpleName());
        log.info("记录总数:{}", cnt);
    }

}
