package org.boot.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"*.test", "data.dto"})
public class SpringMvcApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SpringMvcApplication.class, args);
    }
    
}
