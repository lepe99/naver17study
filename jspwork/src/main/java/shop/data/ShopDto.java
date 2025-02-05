package shop.data;

import java.sql.Timestamp;

public class ShopDto {
    private int num;
    private String prdtName;
    private String prdtColor;
    private int prdtCnt;
    private int prdtPrice;
    private String prdtImg;
    private String prdtDateIn;
    
    public int getNum() {
        return num;
    }
    
    public void setNum(int num) {
        this.num = num;
    }
    
    public String getPrdtName() {
        return prdtName;
    }
    
    public void setPrdtName(String prdtName) {
        this.prdtName = prdtName;
    }
    
    public String getPrdtColor() {
        return prdtColor;
    }
    
    public void setPrdtColor(String prdtColor) {
        this.prdtColor = prdtColor;
    }
    
    public int getPrdtCnt() {
        return prdtCnt;
    }
    
    public void setPrdtCnt(int prdtCnt) {
        this.prdtCnt = prdtCnt;
    }
    
    public int getPrdtPrice() {
        return prdtPrice;
    }
    
    public void setPrdtPrice(int prdtPrice) {
        this.prdtPrice = prdtPrice;
    }
    
    public String getPrdtImg() {
        return prdtImg;
    }
    
    public void setPrdtImg(String prdtImg) {
        this.prdtImg = prdtImg;
    }
    
    public String getPrdtDateIn() {
        return prdtDateIn;
    }
    
    public void setPrdtDateIn(String prdtDateIn) {
        this.prdtDateIn = prdtDateIn;
    }
}
