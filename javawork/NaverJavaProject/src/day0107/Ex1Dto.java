package day0107;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Ex1Dto {
    private int idx;
    private int num;
    private String orderName;
    private int orderCnt;
    private String bookingDay;
    private String foodName;
    private int foodPrice;
    private String foodSize;

    public Ex1Dto() {
    }

    public Ex1Dto(int num, String orderName, int orderCnt, String bookingDay) {
        this.num = num;
        this.orderName = orderName;
        this.orderCnt = orderCnt;
        this.bookingDay = bookingDay;
    }

    public Ex1Dto(String foodName, int foodPrice, String foodSize) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodSize = foodSize;
    }


}
