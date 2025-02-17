package controller.test;

import org.springframework.web.bind.annotation.GetMapping;
import dto.test.TestDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Controller // bean 객체를 자동으로 등록
@RestController // @RestController는 @Controller + @ResponseBody
public class HelloController {
    
    // spring은 메서드 별로 매핑 가능
//    @ResponseBody // HTTP의 Body에 문자 내용을 직접 반환
//    @RequestMapping(value = "/", method = RequestMethod.GET) // GetMapping과 같은 기능, 스프링 모든 버전
    @GetMapping("/hello2") // 스프링 4.3 버전 이후부터 사용 가능
    public TestDto hello() {
        TestDto testDto = new TestDto();
        testDto.setName("홍길동");
        testDto.setAddr("서울시 강남구");
        testDto.setHp("010-1234-5678");
        System.out.println(testDto); // toString() 메서드 호출
        return testDto;
    }
}