package day1224;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Ex10ListVector {

	public static void main(String[] args) {
		// Arrays 클래스의 asList 이용해서 List 컬렉션에 자료 빠르게 입력
		List<String> list1 = Arrays.asList("장미꽃", "안개꽃", "국화꽃", "다알리아");
		System.out.println("list1의 크기 : " + list1.size());
		
		List<Integer> list2 = Arrays.asList(56, 67, 100, 90, 80);
		System.out.println("list2의 크기 : " + list2.size());

		System.out.println("list1 출력");
		for(String s : list1)
			System.out.print(s + " ");
		
		System.out.println("list2 출력");
		Iterator<Integer> iter = list2.iterator();
		while(iter.hasNext())
			System.out.print(iter.next() + " ");
		// 둘 중 편한 방법 쓰자
	}

}
