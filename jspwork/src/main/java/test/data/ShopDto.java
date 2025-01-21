package test.data;

public class ShopDto {
    private String name;
    private int cnt;
    private int price;
    
    public ShopDto() {
    }
    
    public ShopDto(String name, int cnt, int price) {
        this.name = name;
        this.cnt = cnt;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getCnt() {
        return cnt;
    }
    
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
}
