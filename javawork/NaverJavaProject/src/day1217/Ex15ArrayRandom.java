package day1217;

public class Ex15ArrayRandom {

	public static void main(String[] args) {
		int[] numbers = new int[20];
		/*
		 * 배열에 1~50 사이의 난수 20개를 구하여 놓고
		 * 오름차순으로 정렬해서 출력하시오
		 */
		for(int i=0; i<numbers.length; i++)
			numbers[i] = (int) (Math.random() * 50) + 1;
			// 이전에 발생한 값이랑 같을 경우 다시 구하기 (중복처리 로직)
			
		
		//정렬
		for(int i=0; i<numbers.length; i++) {
			for(int j=i+1; j<numbers.length; j++) {
				if(numbers[i] > numbers[j]) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
		//출력 - 한줄에 5개씩
		for(int i=0; i<numbers.length; i++) {
			System.out.print(i + " : " + numbers[i] + "\t\t");
			if((i + 1) % 5 == 0) System.out.println();
		}
	}

}
