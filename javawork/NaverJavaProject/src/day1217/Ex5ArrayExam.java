package day1217;

public class Ex5ArrayExam {

	public static void main(String[] args) {
		int[] data = {23, 100, -56, 234, 11, 88, 99, -120, 7, 10};
		int max = data[0]; // 첫 데이터를 최대값으로 지정
		int min = data[0];
		// 1번지부터 끝까지 비교해서 max보다 더 큰 값이 나오면 그 값을 max에 저장
		
		for(int i : data) {
			max = max > i ? max : i;
			min = min > i ? i : min;
		}
		System.out.println("max = " + max);
		System.out.println("min = " + min);
	}

}
