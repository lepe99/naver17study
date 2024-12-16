package day1216;

public class Ex4ForLabel {

	public static void main(String[] args) {
		Loop:
			for(int i=1; i<=3; i++) {
				for(int j=1; j<=4; j++) {
//					if(i==2)
//						continue Loop; // i++ 로 이동, i가 2인경우는 출력 안함
	
					if(j==3)
						continue Loop; // j가 1, 2인 경우만 출력
					
//					if(j==3)
//						break; // 위랑 같음
					
					if(j==3)
						break Loop; // 바깥 for문 탈출 => 종료
					
					System.out.println("i = " + i + ", j = " + j);
				}
			}

	}

}
