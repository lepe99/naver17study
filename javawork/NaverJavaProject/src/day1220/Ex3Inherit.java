package day1220;

import day1220_2.DbServerSystem; // 자동완성 하면 자동 임포트. 패키지 다르기 떔 임포트 해서 사용해야함

class DataProcess extends DbServerSystem {
	private String sql;
	
	public DataProcess() {
		sql = "select";
		this.dbServerName = "Mysql"; // protected 인 경우 직접 접근 가능 ( 상속 관계일 때 )	
//		this.serverPort = 9000;	// default 멤버 변수는 상속관계라 하더라도 접근 불가능!
	}
	
	public DataProcess(String dbServerName, int serverPort, String sql) {
		super(dbServerName, serverPort); // 반드시 첫 문장
		this.sql = sql;
	}
	
	// 생성해둔 동명의 오버라이드 메서드가 없으면 this 로 호출해도 무방!
	// 있다면 반드시 super 로 호출!
	public void process() {
		this.serverStart();
		System.out.println("SQL문 " + sql + "처리함");
		super.serverClose();
		System.out.println();
	}
}

public class Ex3Inherit {

	public static void main(String[] args) {
		DataProcess dp1 = new DataProcess();
		DataProcess dp2 = new DataProcess("Oracle", 9000, "INSERT");
		
		dp1.process();
		dp2.process();

	}

}
