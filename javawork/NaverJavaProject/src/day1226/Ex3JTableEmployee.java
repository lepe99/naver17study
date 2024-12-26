package day1226;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex3JTableEmployee extends JFrame{
	JTable table;
	Ex1EmployeeArrayList ex1 = new Ex1EmployeeArrayList();
	
	public Ex3JTableEmployee() {
		super("사원파일 읽기");
		this.setBounds(300, 100, 400, 300); // 시작위치와 크기 지정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x 버튼 클릭 시 종료
		this.initDesign();
		this.setVisible(true); // 프레임 보이게 하기
	}
	
	public void initDesign() {
		// 파일정보 읽어오기	
//		ex1.employeeFileRead();
		
		// 테이블의 제목 부분
		Vector<String> title = new Vector<>();
		title.add("사원명");
		title.add("나이");
		title.add("핸드폰");
		title.add("주소");
		
		// 테이블의 데이터 부분
		Vector<Vector<String>> data = new Vector<>();
		
		for(Employee s : ex1.employeeList) {
			Vector<String> employee = new Vector<>();
			employee.add(s.getEmployeeName());
			employee.add(String.valueOf(s.getAge()));
			employee.add(s.getHp());
			employee.add(s.getAddress());
			data.add(employee);
		}
		
		// JTable 생성
		table = new JTable(data, title);
		
		
		// frame 의 center 에 추가
		this.add("Center", new JScrollPane(table));		
	}
	
	
	public static void main(String[] args) {
		Ex3JTableEmployee ex3 = new Ex3JTableEmployee();

	}

}
