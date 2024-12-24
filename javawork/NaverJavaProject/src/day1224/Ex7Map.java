package day1224;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ex7Map {

	public static void main(String[] args) {
		// Map 타입은 key 와 value 의 쌍으로 데이터를 추가한다
		// 이때 key 값은 Set 타입이다. 즉, 중복허용하지 않고 비순차적
		Map<String, String> map = new HashMap<>();
		
		// map 에 데이터 추가
		map.put("name", "송혜교");
		map.put("age", "34");
		map.put("blood", "AB");
		map.put("name", "이영자"); // 같은 key 값에 다른 value 선언 -> 덮어쓴다
		map.put("age2", "34");
		
		System.out.println("map의 사이즈 : " + map.size()); // map 의 사이즈
		// map 에서 key 값으로 value 값 꺼내기
		System.out.println("이름 : " + map.get("name"));
		System.out.println("나이 : " + map.get("age"));
		System.out.println("혈액형 : " + map.get("blood"));
		System.out.println("핸드폰 : " + map.get("hp")); // 없을 경우 반환
		System.out.println("나이 : " + map.get("age2")); 
		// value 값은 key 에 종속되었기에 중복해도 괜찮음
		
		System.out.println();
		
		// key 값들을 자동으로 얻은 후 value 값들 얻기
		Set<String> keySets = map.keySet(); // Set 컬렉션에 Map 컬렉션의 key 값만 뽑아 저장
		for(String key : keySets) {
			String v = map.get(key);
			System.out.println(key + " => " + v);
		}

	}

}
