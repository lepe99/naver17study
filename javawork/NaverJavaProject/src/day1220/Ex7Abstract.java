package day1220;

import java.util.List;
import java.util.Vector;

public class Ex7Abstract {

	public static void main(String[] args) {
		// 다형성 처리 예시
		List<String> list = null; // 리스트 안에 String 만 넣겠다. collection 에는 <> 안에 넣을 자료형 명시 해야 함
		list = new Vector<String>(); // 벡터는 리스트의 자식 클래스
		
		list.add("Red"); // add 메서드는 오버라이드 메서드
		list.add("Green");
		
		for(String s : list)
			System.out.println(s);
		
		
		// 현재 할당된 크기를 알아보는 capacity() 메서드 -> Vector 만 가지고 있다
		int n = ((Vector<String>)list).capacity(); // 다운캐스팅하여 호출
		System.out.println(n);
	}

}
