package bitcamp.study;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // 스프링 컨테이너에 빈 객체로 등록, myCar로 이름 지정되어 등록됨
@Data
public class MyCar {
    @Value("아우디 A6")
    private String myCarName;
    @Value("검정색")
    private String myCarColor;
}
