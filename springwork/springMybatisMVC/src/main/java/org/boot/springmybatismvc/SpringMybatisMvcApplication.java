package org.boot.springmybatismvc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"data.*", "*.controller"})
@MapperScan("data.repository") // mybatis Mapper 스캔
public class SpringMybatisMvcApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SpringMybatisMvcApplication.class, args);
    }
    
}
