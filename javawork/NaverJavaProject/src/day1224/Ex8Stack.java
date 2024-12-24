package day1224;

import java.util.Stack;

public class Ex8Stack {

	public static void main(String[] args) {
		// Stack -> LIFO 후입선출 (DFS, undo/redo 구현, 후위 표기법, 문자열 뒤집기 등 사용)
		// push, pop 을 이용하여 데이터 추가, 제거
		Stack<String> stack1 = new Stack<>(); // List 로 업캐스팅 선언하면 Stack 의 전용 메서드인 push(), pop() 사용이 번거롭다

		stack1.push("사과");
		stack1.push("오렌지");
		stack1.push("사과");
		stack1.push("키워");
		stack1.push("딸기");
		
		System.out.println("stack의 개수 : " + stack1.size());
		
		while(!stack1.isEmpty()) { // 스택 내부가 비어있는지 여부를 반환
			System.out.println(stack1.pop());
		}
	}

}
