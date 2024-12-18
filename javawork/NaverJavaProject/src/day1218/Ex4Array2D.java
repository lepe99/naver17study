package day1218;

public class Ex4Array2D {
	public static void main(String[] args) {
		// 2차원 배열에 선언 시 초기값 지정하기
		int[][] arr1 = {
				{67, 78, 90},
				{100, 98, 100},
				{67, 78, 45, 90}
		};
		System.out.println("행 갯수 : " + arr1.length);
		System.out.println("0번행의 열 갯수 : " + arr1[0].length);
		System.out.println("1번행의 열 갯수 : " + arr1[1].length);
		System.out.println("2번행의 열 갯수 : " + arr1[2].length);
		
		//출력
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr1[i].length; j++) {
				System.out.print(arr1[i][j] + "\t");
			}
			System.out.println();
		}
		
	}
}
