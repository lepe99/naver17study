package day1224;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex5Set {

	public static void main(String[] args) {
		
		Set<String> set1 = new HashSet<>();
		Set<String> set2 = new TreeSet<>();
		
		set1.add("강리나");
		set1.add("이홍기");
		set1.add("강리나");
		set1.add("이영자");

		
		set2.add("강리나");
		set2.add("이홍기");
		set2.add("강리나");
		set2.add("이영자");

		
		System.out.println("set1의 개수 : " + set1.size()); // "강리나"가 중복되어 하나의 값만 들어갔기에 3개 출력
		System.out.println("set2의 개수 : " + set2.size());
		
		System.out.println("HashSet 결과"); // 비순차적
		for(String n : set1)
			System.out.print(n + " ");
		System.out.println();
		
		System.out.println("TreeSet 결과"); // 오름차순
		for(String n : set2)
			System.out.print(n + " ");
		System.out.println();
		
		
		// 데이터를 출력하는 다른 방법 - Iterator
		Iterator<String> iter = set2.iterator();
		while(iter.hasNext()) // Next 값이 없다면 f
			System.out.print(iter.next() + " ");
		System.out.println();
	}

}
