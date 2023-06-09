package usts.pycro.admin.interceptor;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-07 8:34 PM
 */
@Component
public class RedisUrlCountInterceptor implements HandlerInterceptor {

    //@Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();

        //默认每次访问当前url就会计数+1
        redisTemplate.opsForValue().increment(uri);

        return true;
    }
}
