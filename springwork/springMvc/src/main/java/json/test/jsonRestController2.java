package json.test;

import data.dto.TestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class jsonRestController2 {
    
    @GetMapping("/test")
    @ResponseBody // json 형태로 데이터를 반환
    public TestDto test1() {
        TestDto dto = new TestDto("홍길동", "서울시 강남구", "남성");
        return dto; // json 형태로 반환
    }
}
