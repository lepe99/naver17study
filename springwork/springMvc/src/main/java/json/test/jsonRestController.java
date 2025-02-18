package json.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // json 형태로 데이터를 반환하는 컨트롤러, 프론트에서 GET, PUT, POST, DELETE 등의 요청을 할 때 사용
public class jsonRestController {
    
    @GetMapping("/bit")
    public String test1() {
        return "bitcamp";
    }
}
