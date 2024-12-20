package day1219;

public class Ex8StringBuffer {

	public static void main(String[] args) {
		String str = "Happy";
		// String -> StringBuffer	
		StringBuffer sb = new StringBuffer(str);
		System.out.println(sb); // 인스턴스 변수인 경우 변수명만 출력 시 자동으로 toString()이 호출
//		System.out.println(sb.toString()); // 와 같다 / toSting을 갖고 있지 않는 경우 값이 아닌 주소가 출력된다
		
		// String 은 값 자체를 변경할 수 없지만 StringBuffer 는 문자열 편집이 가능하다
		sb.append('A');
		sb.append(100);
		sb.append("Bitcamp");
		System.out.println(sb);
		
		// 삭제
		sb.delete(5, 9); // 5 ~ 8 인덱스 부분 제거
		System.out.println(sb);
		
		// 삽입
		sb.insert(5, "Java"); // 3번 인덱스 삽입, 나머진 뒤로
		System.out.println(sb);
		
		// 중간의 문자열 변경
		sb.replace(5, 9, "Hello"); // 5~9 인덱스의 Java 4글자를 5글자 Hello로 
		System.out.println(sb);
		
		// 데이터를 json 데이터로 변환
		String name = "캔디";
		int age = 23;
		
		StringBuffer sb2 = new StringBuffer();
		sb2.append("{\"name\":");
		sb2.append("\"" + name + "\",");
		sb2.append("\"age\":");
		sb2.append(age + "}");
		System.out.println(sb2);
	}

}
