package day1224;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Ex9ListVector {

	public static void main(String[] args) {
		// List 자료형은 동적 할당이 되어있기에 capacity 를 초과하여 요소를 추가하면 할당 용량이 자동으로 늘어난다 
		// (선언값 따로 없으면 기본 단위인 10 단위로 증가)
		List<String> list1 = new Vector<>(); // 기본으로 10개 할당
		List<String> list2 = new Vector<>(5); // 5개 할당
		List<String> list3 = new Vector<>(5, 3); // 5개 할당, 용량 증가시 3개씩 증
		
		System.out.println("list1의 데이터 개수 : " + list1.size());
		System.out.println("list1의 할당 크기 : " + ((Vector<String>) list1).capacity());
		// capacity 는 List 의 오버라이드 메서드가 아니기에 다운캐스팅하여 사용하였다
		System.out.println("list2의 데이터 개수 : " + list2.size());
		System.out.println("list2의 할당 크기 : " + ((Vector<String>) list2).capacity());
		
		
		list2.add("김상아");
		list2.add("이미자");
		list2.add("홍상수");
		list2.add("이진");
		list2.add("이효리");
		list2.add("김상아");
		list2.add("이진");
		
		System.out.println("list2의 데이터 개수 : " + list2.size());
		System.out.println("list2의 할당 크기 : " + ((Vector<String>) list2).capacity());
		
		// Vector 의 출력 방법 1
		System.out.println("1번");
		for(String s : list2)
			System.out.print(s + " ");
		
		// Vector 의 출력 방법 2
		System.out.println("\n2번");
		for(int i=0; i<list2.size(); i++)
			System.out.printf("%d : %s ", i + 1, list2.get(i));
		
		// Vector 의 출력 방법 3 (Iterator)
		System.out.println("\n3번");
		Iterator<String> iter = list2.iterator();
		while(iter.hasNext())
			System.out.print(iter.next() + " ");
		
		// Vector 의 출력 방법 4 (toArray Object 반환)
		System.out.println("\n4번");
			Object[] ob = list2.toArray(); 
			for(Object s : ob)
				System.out.print(s + " ");

	}

}
