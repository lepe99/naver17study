package day0107;
/*
create table restaurant
(
    num       smallint auto_increment primary key,
    foodname  varchar(30),
    foodprice int,
    foodsize  varchar(20) default '보통'
);

create table foodorder
(
    idx        smallint auto_increment primary key,
    num        smallint,
    ordername  varchar(20),
    ordercnt   smallint,
    bookingday varchar(30),
    constraint fk_foodorder_num foreign key (num) references restaurant (num)
);
 */
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

    public Ex1Dto(int num) {
        this.num = num;
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


    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderCnt() {
        return orderCnt;
    }

    public void setOrderCnt(int orderCnt) {
        this.orderCnt = orderCnt;
    }

    public String getBookingDay() {
        return bookingDay;
    }

    public void setBookingDay(String bookingDay) {
        this.bookingDay = bookingDay;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodSize() {
        return foodSize;
    }

    public void setFoodSize(String foodSize) {
        this.foodSize = foodSize;
    }
}
