package day1219;

public class Ex6VarArgs {
	
	public static void writeColor(String color1) {
		System.out.println("color1 = " + color1);
	}
	
	public static void writeColor(String color1, String color2) {
		System.out.println("color1 = " + color1 + "color2 = " + color2);
	}
	
	public static void writeColor(String color1, String color2, String color3) {
		System.out.println("color1 = " + color1 + "color2 = " + color2 + "color3 = " + color3);
	}
	
	
	
	public static void writeName(String ... name) { //VarArgs / ... 은 배열 타입으로 전달 받는다
		System.out.println("name의 length : " + name.length);
		
		if(name.length == 0) System.out.println("멤버가 없습니다");
		else {
			System.out.println("** 멤버 목록 **");
			
			for(String n : name)
				System.out.println("\t" + n);
			System.out.println("=".repeat(20));
		}
	}
	
	
	
	public static void main(String[] args) {
		writeColor("red");
		writeColor("yellow", "green");
		writeColor("white", "orange", "black");
//		writeColor("white", "orange", "black", "red"); // 오류 발생 (해당 오버로딩 메서드 없음)
		
		System.out.println("Variable Arguments 기능을 이용해서 인자로 여러 문자열을 보내보자");
		writeName("이미자");
		writeName("이미자", "손예진");
		writeName("이미자", "손예진", "한고은");
		writeName("이미자", "손예진", "한고은", "마이클");
		writeName(); // 인자 없이도 가능!

	}

}
