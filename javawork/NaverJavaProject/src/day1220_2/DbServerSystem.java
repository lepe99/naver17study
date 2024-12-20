package day1220_2;

public class DbServerSystem {
	// 접근지정자 일단 default 로 해보고 protected 로도 수정 해 보자
//	String dbServerName;
	int serverPort;
	protected String dbServerName; // protected 는 상속 관계인 외부 패키지에서도 접근 가능
//	protected int serverPort;
	
	public DbServerSystem() { // 생성자도 클래스와 같이 public
		dbServerName = "Oracle";
		serverPort = 8080;
	}
		
	public DbServerSystem(String dbServerName) {
		this.dbServerName = dbServerName;
		serverPort = 8080;
	}
	
	public DbServerSystem(String dbServerName, int serverPort) {
		this.dbServerName = dbServerName;
		this.serverPort = serverPort;
	}
	
	public void serverStart() {
		System.out.println(serverPort + " Port로 " + dbServerName + " DB 세팅 완료");
	}
	
	public void serverClose() {
		System.out.println(dbServerName + " DB Close 함");
	}
}


