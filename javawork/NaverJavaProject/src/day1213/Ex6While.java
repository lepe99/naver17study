package day1213;

public class Ex6While {

	public static void main(String[] args) {
		int a = 65;
		
		while (a < 90) {
//			System.out.printf("%c", a++);
			System.out.print((char) a++);
		}
		
		System.out.println();
		char b ='a';
		//do-while 이용해 a~z 출력
		do {
			System.out.print(b++);
		} while(b <= 'z'); // char은 ascii code 연산 비교 가능
		
		int n = 0;
		while(n<=10) {
			n++;
			if(n % 2 == 0)
				continue; // 조건식(while, do-while), 반복문(for) 으로 이동
			System.out.printf("%3d", n);
		}
	}

}
