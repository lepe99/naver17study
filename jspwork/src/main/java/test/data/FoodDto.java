package test.data;

public class FoodDto {
    private String foodName;
    private String foodPhoto;
    private int foodPrice;
    private String foodDay;
    private int foodCnt;
    
    public FoodDto() {
    }
    
    public FoodDto(String foodName, String foodPhoto, int foodPrice, String foodDay, int foodCnt) {
        this.foodName = foodName;
        this.foodPhoto = foodPhoto;
        this.foodPrice = foodPrice;
        this.foodDay = foodDay;
        this.foodCnt = foodCnt;
    }
    
    public String getFoodName() {
        return foodName;
    }
    
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    
    public String getFoodPhoto() {
        return foodPhoto;
    }
    
    public void setFoodPhoto(String foodPhoto) {
        this.foodPhoto = foodPhoto;
    }
    
    public int getFoodPrice() {
        return foodPrice;
    }
    
    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }
    
    public String getFoodDay() {
        return foodDay;
    }
    
    public void setFoodDay(String foodDay) {
        this.foodDay = foodDay;
    }
    
    public int getFoodCnt() {
        return foodCnt;
    }
    
    public void setFoodCnt(int foodCnt) {
        this.foodCnt = foodCnt;
    }
}
    
    