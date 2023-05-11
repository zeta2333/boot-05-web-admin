package usts.pycro.admin.actuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-10 10:58 PM
 */
@Component
public class MyComponentHealthIndicator extends AbstractHealthIndicator {
    /**
     * 真实的检查方法
     *
     * @param builder
     * @throws Exception
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        // 携带一系列参数
        Map<String, Object> map = new HashMap<>();
        // 检查参数
        if (1 == 2) {
            // builder.up();//健康
            builder.status(Status.UP);
            map.put("count", 1);
            map.put("ms", 100);
        } else {
            // builder.down();
            builder.status(Status.OUT_OF_SERVICE);
            map.put("err", "连接超时");
            map.put("ms", 3000);
        }
        builder.withDetail("code", 100)
                .withDetails(map);
    }
}
