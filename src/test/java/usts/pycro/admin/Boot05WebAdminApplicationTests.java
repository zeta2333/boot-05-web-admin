package usts.pycro.admin;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import usts.pycro.admin.bean.User;
import usts.pycro.admin.mapper.UserMapper;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class Boot05WebAdminApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    UserMapper userMapper;

    //@Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Test
    void contextLoads() {
        String sql = "select count(*) from t_emp";
        Long cnt = jdbcTemplate.queryForObject(sql, Long.class);

        log.info("数据源：{}", dataSource.getClass().getSimpleName());
        log.info("记录总数:{}", cnt);
    }

    @Test
    @Transactional
    public void testUserMapper() {
        User user = userMapper.selectById(1);
        System.out.println(userMapper.getClass().getName());
        log.info("用户信息：{}", user);
    }

    @Disabled
    @Test
    public void testRedis() {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set("hello", "world123");
        System.out.println(operations.get("/sql"));
        System.out.println(redisConnectionFactory.getClass().getName());
    }

}
