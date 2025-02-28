package data.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("BoardFile")
public class BoardFile {
    private int num;
    private int idx;
    private String fileName;
}
