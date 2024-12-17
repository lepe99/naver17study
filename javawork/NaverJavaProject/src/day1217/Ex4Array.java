package day1217;

public class Ex4Array {

	public static void main(String[] args) {
		String[] str1;
		str1 = new String[4]; // 할당과 시에 초기값이 들어간다 (객체는 null)
		str1[0] = "Hello";
		str1[3] = "Kitty";
		for(int i=0; i<str1.length; i++)
			System.out.println("str1[" + i + "] = " + str1[i]);
		System.out.println("=".repeat(30));
		
		String[] str2; 
		str2 = new String[] {"초록색", "분홍색", "빨간색", "노란색"};
		for(String s : str2)
			System.out.println(s);
		System.out.println("=".repeat(30));
		
		String[] str3 = new String[] {"김미나", "안지영", "홍길동", "강한나"};
		for(String s : str3)
			System.out.println(s);
	

	}

}
