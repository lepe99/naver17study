package test.day0121;

import test.data.FoodDto;

import java.util.ArrayList;
import java.util.List;

public class FoodDataList {
    private List<FoodDto> list = new ArrayList<>();
    
    public FoodDataList() {
        list.add(new FoodDto("계란말이", "계란말이.jpg", 23000, "2025-01-08", 2));
        list.add(new FoodDto("망고빙수", "11.jpg", 11000, "2025-01-18", 3));
        list.add(new FoodDto("야채샌드위치", "8.jpg", 5000, "2025-01-23", 4));
        list.add(new FoodDto("콘치즈", "5.jpg", 7000, "2025-01-03", 2));
        list.add(new FoodDto("치즈샌드위치", "치즈샌드위치.jpg", 8000, "2025-01-17", 6));
        list.add(new FoodDto("짜장라면", "짜장라면.jpg", 9000, "2025-01-12", 5));
    }
    
    public List<FoodDto> getAllData() {
        return list;
    }
}
