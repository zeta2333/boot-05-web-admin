package usts.pycro.admin.actuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-10 11:30 PM
 */
@Component
public class AppInfo implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("msg","你好")
                .withDetail("hello","pycro")
                .withDetails(Collections.singletonMap("world","666"));
    }
}
