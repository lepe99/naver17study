package data.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@Alias("Shop") // mybatis에서 사용할 이름
public class Shop {
    private int num;
    private String name;
    private String color;
    private int price;
    private int qty;
    private String image;
    private String arrivalDate;
    private Timestamp regDate;
}
