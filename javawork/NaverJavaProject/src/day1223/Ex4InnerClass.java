package day1223;

abstract class AbstEmployee {
	abstract public void addEmployee();
	abstract public void removeEmployee();
}

interface InterSales {
	public void insertGoods();
	public void selectGoods();
}
// 위 클래스와 인터페이스를 익명 내부 클래스 형태로 구현 후 메인에서 호출


public class Ex4InnerClass {
	AbstEmployee emp = new AbstEmployee() {
		
		@Override
		public void removeEmployee() {
			System.out.println("사원 제거");
		}
		
		@Override
		public void addEmployee() {
			System.out.println("사원 추가");
		}
	};
	
	InterSales sales = new InterSales() {
		
		@Override
		public void selectGoods() {
			System.out.println("상품 선택");
			
		}
		
		@Override
		public void insertGoods() {
			System.out.println("상품 입력");
			
		}
	};

	public static void main(String[] args) {
		
		Ex4InnerClass ex4 = new Ex4InnerClass();
		ex4.emp.removeEmployee();
		ex4.emp.addEmployee();
		
		System.out.println();
		
		ex4.sales.selectGoods();
		ex4.sales.insertGoods();
	}

}
