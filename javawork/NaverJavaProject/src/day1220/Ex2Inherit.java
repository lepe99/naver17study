package day1220;

class SuperObj2 {
	private String schoolName; // private 는 자식 메서드도 접근 못함
	
	SuperObj2() {
		schoolName = "청담고등학교";
	}
	
	SuperObj2(String schoolName) {
		this.schoolName = schoolName;
	}
	
	public void write() {
		System.out.println("학교명 : " + schoolName);
	}
}


class SubObj2 extends SuperObj2 { // SuperObj2 을 상속
	private String studentName;
	
	SubObj2() {
		studentName = "이름없음";
	}
	
	SubObj2(String schoolName, String studentName) {
		super(schoolName); // 부모의 해당 생성자에 전달
		this.studentName = studentName;
	}
	
	//오버라이드, 자동완성
	@Override // 부모의 메서드를 재정의 했다는 의미
		public void write() {
			super.write(); // 부모가 처리한 로직 실행 - super()와 다르호출 위치는 상관 없다 
//			this.write(); // 자기 자신이 호출되서 무한루프
			System.out.println("학생 이름 : " + studentName);
		}
}


class SubObj22 extends SuperObj2 {
	private String teacherName;
	
	SubObj22() {
		teacherName = "이름없음";
	}
	
	SubObj22(String schoolName, String teachername) {
		super(schoolName);
		this.teacherName = teachername;
	}
	
	@Override
	public void write() {
		System.out.println("선생님 이름 : " + teacherName);
		super.write();
	}
}



public class Ex2Inherit {
	
	public static void main(String[] args) { 
		SubObj2 s1 = new SubObj2();
		SubObj2 s2 = new SubObj2("강남고등학교", "홍길동");
		SubObj22 s3 = new SubObj22();
		SubObj22 s4 = new SubObj22("중동고등학교", "이진");
		
		s1.write();
		s2.write();
		System.out.println();
		s3.write();
		s4.write();
	}
}
