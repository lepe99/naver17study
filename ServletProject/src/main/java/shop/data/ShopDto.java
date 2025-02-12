package shop.data;

import java.sql.Timestamp;

public class ShopDto {
    private int num;
    private String prdtName;
    private String prdtColor;
    private String prdtImage;
    private String prdtDateIn;
    private int prdtCnt;
    private int prdtPrice;
    private Timestamp dateWrite;
    
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
    
    public String getPrdtImage() {
        return prdtImage;
    }
    
    public void setPrdtImage(String prdtImage) {
        this.prdtImage = prdtImage;
    }
    
    public String getPrdtDateIn() {
        return prdtDateIn;
    }
    
    public void setPrdtDateIn(String prdtDateIn) {
        this.prdtDateIn = prdtDateIn;
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
    
    public Timestamp getDateWrite() {
        return dateWrite;
    }
    
    public void setDateWrite(Timestamp dateWrite) {
        this.dateWrite = dateWrite;
    }
}
