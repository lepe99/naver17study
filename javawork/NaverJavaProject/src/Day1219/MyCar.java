package Day1219;

import java.text.SimpleDateFormat;
import java.util.Date;
public class MyCar {
	private String carName;
	private int carPrice;
	private String purchaseDay;
	private String carColor;
	
	public MyCar() { // 퍼블릭 클래스 내 메서드는 퍼플릭 붙여주는게 좋음. 다른 패키지와 공유 고려
		// 생성되는 시간을 구해서 purchaseDay에 넣어보자
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		purchaseDay = sdf.format(new Date());
		
		carColor = "흰색";
	}
	
	//Constructor
	public MyCar(String carName, int carPrice, String carColor) { // generate 로 생성 후 수정
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		purchaseDay = sdf.format(new Date());
		
		this.carName = carName;
		this.carPrice = carPrice;
		this.carColor = carColor;
	}
	
	//toString
	@Override
	public String toString() {
		return "MyCar [carName=" + carName + ", carPrice=" + carPrice + ", "
				+ "purchaseDay=" + purchaseDay + ", carColor="
				+ carColor + "]";
	}
	
	//setter getter
	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public int getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}

	public String getPurchaseDay() {
		return purchaseDay;
	}

	public void setPurchaseDay(String purchaseDay) {
		this.purchaseDay = purchaseDay;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}



	
}
