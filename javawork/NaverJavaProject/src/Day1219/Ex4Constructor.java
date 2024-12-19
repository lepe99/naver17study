package Day1219;
// 생성자도 generate로 자동 생성 가능
class Orange {
	private String name;
	private String color;
	private int age;
	
	// 생성자
	Orange() {
//		this.name = "이말자";
//		this.color = "노랑";
//		this.age = 30;
		
		// 생성자에서 다른 생성자 호출 시 this() 사용
		this("이말자","노랑"); // 인자가 맞는 생성자 호출
	}
	
	Orange(String name, String color) {
		this.name = name;
		this.color = color;
		this.age = 30;
	}
	
	public void writeMember() {
		System.out.println("name : " + name + " color = " + color + " age = " + age);
	}
	public void writeMember(int n) { // 오버로딩
		if(n==1) {
			System.out.println("이름 : " + name);
			System.out.println("좋아하는 색상 : " + color);
			System.out.println("나이 : " + age);
			System.out.println("*".repeat(20));
		} else if(n==2) 
			System.out.println (name + "님은 " + color + " 색상을 좋아합니다");
		else
			System.out.println("1 or 2만 가능합니다");
			
		
	}
}


public class Ex4Constructor {

	public static void main(String[] args) {
		Orange or1 = new Orange();
		or1.writeMember();
		
		
		Orange or2 = new Orange("고민시", "파랑");
		or2.writeMember();
		or2.writeMember(1);
		or2.writeMember(2);
		or2.writeMember(4);
		
	}

}
