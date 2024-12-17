package day1217;

public class Ex9ArrayAge {

	public static void main(String[] args) {
		int[] datas = new int[] {12, 34, 54, 20, 33, 59, 41, 44, 27, 21};
		System.out.println("인원수 : " + datas.length);
		/*
		 * 위 데이터로 10~50대까지 각각의 인원수 구하시오
		 * 배열변수 []age 이용
		 * 10대 : 1명
		 * 20대 : 3명
		 * ...
		 */
		int[] age = new int[5];
		for(int i=0; i<datas.length; i++)
			age[datas[i] / 10 - 1]++;
		
		for(int i=1; i<=5; i++)
			System.out.printf("%d대 : %d명\n", i * 10, age[i - 1]);
			
		
		
	}

}
