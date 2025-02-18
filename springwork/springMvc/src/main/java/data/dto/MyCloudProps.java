package data.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource("classpath:naverCloud.properties") // application.yml이 아닌 타 yml 참조시에는 다른 클래스 만들어 참조하는 과정이 필요
@ConfigurationProperties(prefix = "naver.cloud")
public class MyCloudProps {
    private String db;
    private String username;
    private String password;
}
