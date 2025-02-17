package dto.test;

import lombok.*;

//@Setter // setter 메소드 생성
//@Getter // getter 메소드 생성
//@ToString // toString 메소드 생성
@Data // getter, setter, toString 메소드 생성
@NoArgsConstructor // 기본 생성자 생성
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자 생성
public class TestDto {
    private String name;
    private String addr;
    private String hp;
}
