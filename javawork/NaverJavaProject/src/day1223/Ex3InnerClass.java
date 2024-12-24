package day1223;
// 익명 내부 클래스가 효용 있는 경우 => 간단한 구현이고 재사용성이 없을 떄. 일회성 사용
abstract class AbstEx {
	abstract public void show();
}

interface MyDB{
	public void list();
	public void insert();	
}

class SubMyDB implements MyDB {

	@Override
	public void list() {
		System.out.println("목록 출력2");
	}

	@Override
	public void insert() {
		System.out.println("삽입2");
		
	}
	
}
public class Ex3InnerClass {
	
	AbstEx abst1 = new AbstEx() { // Anonymous (익명) 내부 클래스 형태로 구현
		
		@Override
		public void show() {
			System.out.println("show 호출");
		}
	};
	
	MyDB myDB = new MyDB() { // Anonymous (익명) 내부 클래스 형태로 구현
		
		@Override
		public void list() {
			System.out.println("db 목록을 출력합니다");
		}
		
		@Override
		public void insert() {
			System.out.println("db에 데이터를 추가합니다");
			
		}
	};
	
	MyDB myDB2 = new SubMyDB(); // 다형성 통한 클래스 호출
	
	public static void main(String[] args) {
		Ex3InnerClass ex3 = new Ex3InnerClass();
		ex3.abst1.show();
		System.out.println();
		
		ex3.myDB.list();
		ex3.myDB.insert();
		System.out.println();
		
		ex3.myDB2.list();
		ex3.myDB2.insert();
	}
}
