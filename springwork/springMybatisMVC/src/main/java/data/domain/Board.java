package data.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;
import java.util.List;

@Data
@Alias("Board")
public class Board {
    private int idx;
    private String id;
    private String writer;
    private String subject;
    private String content;
    private String readCount;
    private int regroup;
    private int relevel;
    private int restep;
    private Timestamp writeDate;
    
    private List<String> images;
    private int imageCount;
    private int commentCount;
}
