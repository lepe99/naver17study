package bitcamp.study;

import dto.test.TestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BitController {
    
    @GetMapping("/hello")
    public List<TestDto> list() {
        List<TestDto> list = new ArrayList<>();
        list.add(new TestDto("홍길동", "서울", "010-2342-4444"));
        list.add(new TestDto("홍길송", "부산", "010-1234-4444"));
        list.add(new TestDto("홍길홍", "제주", "010-1234-4444"));
        return list;
    }
}
