package day1212;

public class Page94 {

	public static void main(String[] args) {
		int charCode = 'A';
//		int charCode = 'a';
//		int charCode = '5';
		
		if(charCode >= 65 && charCode <= 90)
			System.out.println("대문자임");
		
		if(charCode >= 97 && charCode <= 122)
			System.out.println("소문자임");
		
		if(charCode >= 48 && charCode <= 57)
			System.out.println("숫자임");
		
		int val = 6;
//		int val = 5;
		
		if(val % 2 == 0 || val % 3 == 0)
			System.out.println("2 또는 3의 배수임");
		
		boolean result = val % 2 == 0 || val % 3 == 0;
		
		if(!result)
			System.out.println("2 또는 3의 배수 아님");
	}

}
