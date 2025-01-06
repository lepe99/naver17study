package day0106;

// 생성자, setter, getter 선언

public class Ex2ShopDto {
    private int idx;
    private String prdt;
    private int num;
    private int price;

    public Ex2ShopDto() {

    }

    public Ex2ShopDto(String prdt, int num, int price) {
        this.prdt = prdt;
        this.num = num;
        this.price = price;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getPrdt() {
        return prdt;
    }

    public void setPrdt(String prdt) {
        this.prdt = prdt;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
