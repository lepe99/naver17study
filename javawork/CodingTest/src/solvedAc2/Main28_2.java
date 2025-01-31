package solvedAc2;
// 1 ~ n 까지의 정수가 들어있는 리스트 IntStream 활용하여 생성
// 반복문으로 삽입하는 것과 비교하면 별로 시간적 이점이 없으므로 쉬운 방법 사용하는게 나아보임
// queue 인터페이스를 이용해 문제 해결
// ArrayDeque , LinkedList 클래스를 이용해 문제 해결 가능 (둘 다 Deque로 활용 가능)
// ArrayDeque : 양쪽 끝 삽입 삭제 시 O(1)의 시간 복잡도, 중간 삽입 삭제 시 O(n)의 시간 복잡도, 메모리 이용 낮음
// LinkedList : 양쪽 끝 삽입 삭제 시 O(1)의 시간 복잡도, 중간 삽입 삭제 시 O(1) ~ O(n)(최악)의 시간 복잡도, 메모리 이용 상대적으로 높음 (포인터 때문)
// 해당 문제는 Queue 자료구조를 통해 해결 가능. ArrayDeque 사용하는게 바람직
// collect.(Collectors.toCollection(LinkedList::new)) 이렇게 사용하여 LinkedList 객체 생성 가능
// toList(), toSet(), toMap() 외에도 다른 컬렉션 객체 생성하려면 위와 같이 사용한다

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main28_2 {
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
		Queue<Integer> queue = IntStream.range(1, n + 1).boxed()
				.collect(Collectors.toCollection(LinkedList::new));
		
		while (queue.size() != 1) {
			queue.remove();
			queue.add(queue.remove());
		}
		
		System.out.println(queue.poll());
		br.close();
	}
}