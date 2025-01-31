package solvedAc2;
// https://www.acmicpc.net/problem/2164
// 1 ~ n 까지의 정수가 들어있는 리스트 IntStream 활용하여 생성
// 반복문으로 삽입하는 것과 비교하면 별로 시간적 이점이 없으므로 쉬운 방법 사용하는게 나아보임
// 참조한 리스트의 길이에 따라 조건문을 이용해 홀수 혹은 짝수 번째 요소를 제거하는 방식으로 구현
// 이 또한 구현이 어렵고, 시간적 이점이 없었음
// 짝수, 홀수 인덱스 추출해야될 문제 해결 위해 방법은 알아두기
// 람다 표현식 내부에서 외부 변수의 값을 변경할 수 없음 알아두고 메서드 참조 방식 이용하기
// 28_2 클래스에서 Queue 인터페이스를 이용해 문제 해결
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main28 {
	public static void main(String[] args) {
		try {
			run();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static void run() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		List<Integer> list = IntStream.range(1, n + 1)
						.boxed()
						.collect(Collectors.toList());
		System.out.println(list);
		
		boolean isEven = true;
		int size = list.size();
		while (list.size() != 1) {
			if (isEven) {
                list = IntStream.range(0, list.size()).filter(i -> i % 2 == 1)
                                .mapToObj(list::get)
                                .collect(Collectors.toList());
			} else {
                list = IntStream.range(0, list.size()).filter(i -> i % 2 == 0)
                                .mapToObj(list::get)
                                .collect(Collectors.toList());
			}
			isEven = size % 2 == 0;
			size += list.size();
			
			System.out.println(list);
		}
		
		System.out.println(list.get(0));
		br.close();
	}
}