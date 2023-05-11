package usts.pycro.admin.actuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-11 10:59 AM
 */
@Component
@Endpoint(id = "myservice")
public class MyServiceEndPoint {
    @ReadOperation
    public Map getDockerInfo() {
        // 端点的读操作：http://localhost:8080/actuator/myservice
        return Collections.singletonMap("dockerInfo", "docker started...");
    }

    @WriteOperation
    public void stopDocker() {
        System.out.println("docker stopped...");
    }
}
