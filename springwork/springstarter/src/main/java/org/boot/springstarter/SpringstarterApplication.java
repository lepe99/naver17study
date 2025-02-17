package org.boot.springstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"controller.test", "dto.test"}) // ComponentScan을 통해 패키지를 지정하면 해당 패키지의 하위 패키지까지 스캔
@ComponentScan("*.test") // 와일드카드 사용 가능
@ComponentScan("*.study")
public class SpringstarterApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SpringstarterApplication.class, args);
    }
}
