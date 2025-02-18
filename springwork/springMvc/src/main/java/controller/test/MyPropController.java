package controller.test;

import data.dto.MyCloudProps;
import data.dto.MyPropDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@AllArgsConstructor // 모든 필드를 파라미터로 받는 생성자를 만들어줌
public class MyPropController {
    
    @Autowired
    MyPropDto myPropDto;
    
    @Value("${server.port}") // application.yml 파일의 server.port 속성값을 참조
    int port;
    
    @Value("${emp.addr}") // application.yml 파일의 emp.addr 속성값을 참조
    String addr;
    
    @Autowired
    MyCloudProps myCloudProps;
    
    
    @GetMapping("/prop1")
    public String prop1(Model model) {
        model.addAttribute("addr", myPropDto.getAddr());
        model.addAttribute("hp", myPropDto.getHp());
        model.addAttribute("message", "서버 포트는 " + port + "이고 지역은 " + addr + "입니다.");
        return "result3";
    }
    
    @GetMapping("/prop2")
    public String prop2(Model model) {
        model.addAttribute("db", myCloudProps.getDb());
        model.addAttribute("username", myCloudProps.getUsername());
        model.addAttribute("password", myCloudProps.getPassword());
        System.out.println(myCloudProps.getDb() + ", " + myCloudProps.getUsername() + ", " + myCloudProps.getPassword());
        return "result4";
    }
}
