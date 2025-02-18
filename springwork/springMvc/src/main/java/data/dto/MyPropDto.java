package data.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration // 스프링 설정 클래스임을 선언 (스프링 컨테이너에 빈으로 등록)
//@PropertySource("classpath:application.yml") // application.yml 파일을 참조 (생략 가능)
@ConfigurationProperties(prefix = "emp") // application.yml 파일의 emp 속성값을 참조
@Data
//@Component // 스프링 빈으로 등록, @Configuration과 역할 겹침
public class MyPropDto {
    private String addr;
    private String hp;
}
