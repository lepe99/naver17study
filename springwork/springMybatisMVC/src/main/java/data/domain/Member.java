package data.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@Alias("Member")
public class Member {
    private int num;
    private String name;
    private String passwd;
    private String id;
    private String hp;
    private String address;
    private String image;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private Timestamp regDate;
}
