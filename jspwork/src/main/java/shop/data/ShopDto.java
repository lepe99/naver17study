package shop.data;

import java.sql.Timestamp;

public class ShopDto {
    private int idx;
    private String prdt;
    private int num;
    private int price;
    private Timestamp inDate;
    
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
    
    public Timestamp getInDate() {
        return inDate;
    }
    
    public void setInDate(Timestamp inDate) {
        this.inDate = inDate;
    }
}
