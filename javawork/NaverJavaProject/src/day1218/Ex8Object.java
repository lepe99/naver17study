package day1218;

class Orange {
	public static final String MESSAGE = "Happy";
	
	private String name;
	private int age;
	
	public void showData() { // 메서드는 대부분 public 사용
		// 일반 멤버 메서드는 this라는 인스턴스 변수를 가지고 있다
		// static 멤버 메서드엔 this가 없음
		// 그래서 this.name 과 같이 접근 가능 (this는 경우에 따라 생략 가능)
		System.out.println("이름 : " + this.name + " 나이 : " + this.age);
		System.out.println(MESSAGE); // 같은 클래스 안 static 변수라 호출 가능
		System.out.println(name); //this 생략 가능 : 메서드의 지역변수와 클래스의 멤버 변수의 이름이 겹치지 않을 때
	}
	
	// 값을 변경하기 위한 setter method를 만들어 보자
	public void setName(String name) { // 메서드 지역변수 이름과 멤버변수 이름이 같으므로 this 생략 불가
//		name = name; // Null
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
		
	}
} 
/////////////////
public class Ex8Object {
	
	public static void main(String[] args) {
		System.out.println(Orange.MESSAGE);
		
		Orange orange = new Orange();
//		System.out.println(orange.name); // 오류 : private 변수는 직접 접근할 수 없다
		
		orange.showData();
		
		System.out.println("값변경");
		orange.setName("김태희");
		orange.setAge(35);  // private 변수는 반드시 메서드를 이용해 값 변경
		orange.showData();
	}

}
