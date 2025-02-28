package data.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@Alias("Comment") // mybatis에서 사용할 이름
public class Comment {
    private int idx;
    private int num;
    private String image;
    private String message;
    private int likes;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul") // json으로 변환할 때 날짜 형식 지정
    private Timestamp regDate;
}
