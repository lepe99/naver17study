package data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter, setter, toString 메소드 생성
@NoArgsConstructor
@AllArgsConstructor
public class TestDto {
    private String name;
    private String addr;
    private String gender;
}
