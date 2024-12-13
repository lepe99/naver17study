package day1213;

public class Ex5While {

	public static void main(String[] args) {
		int a = 10;
		// while은 조건이 맞지 않으면 실행 없이 빠져나온다.
		while(a<10) {
			System.out.println("loop1");
		}

		// do-while은 한 번 실행 후 조건을 비교하므로 최소 한번은 문장이 실행
		do {
			System.out.println("loop2");
		} while(a<10);
		
		a = 0;
		while(a<=10) {
			System.out.printf("%3d", a++); // 무한루프
		}
		
		a = 1;	
		while(true) {
			System.out.printf("%3d", a++);
			if (a>10)
				break; //돌지 않게 break 
		}	
		a = 1;
		do {
			System.out.printf("3d", a++);
		} while(a<=10);     
		
	}

}
