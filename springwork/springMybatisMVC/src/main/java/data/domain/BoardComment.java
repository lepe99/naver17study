package data.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@Alias("BoardComment")
public class BoardComment {
    private int idx;
    private int num;
    private String id;
    private String writer;
    private String writerImage;
    private String content;
    private String image;
    private Timestamp writeDate;
}
