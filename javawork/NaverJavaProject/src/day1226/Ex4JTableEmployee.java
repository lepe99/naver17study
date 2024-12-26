package day1226;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex4JTableEmployee extends JFrame{
	JTable table;
	Ex1EmployeeArrayList ex1 = new Ex1EmployeeArrayList();
	
	public Ex4JTableEmployee() {
		super("사원파일 읽기");
		this.setBounds(300, 100, 400, 300); // 시작위치와 크기 지정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x 버튼 클릭 시 종료
		this.initDesign();
		this.setVisible(true); // 프레임 보이게 하기
	}
	
	public void initDesign() {
		// 파일정보 읽어오기	
//		ex1.employeeFileRead();
		
		// 테이블의 제목 부분 (배열)
		String[] title = {"사원명", "나이", "핸드폰", "주소"};

		// 데이블의 데이터 부분
		String[][] data = new String[ex1.employeeList.size()][4];
		
		int i = 0;
		for(Employee s : ex1.employeeList) {
			data[i][0] = s.getEmployeeName();
			data[i][1] = String.valueOf(s.getAge());
			data[i][2] = s.getHp();
			data[i][3] = s.getAddress();
			i++;
		}
		

		// JTable 생성
		table = new JTable(data, title);
		
		
		// frame 의 center 에 추가
		this.add("Center", new JScrollPane(table));		
	}
	
	
	public static void main(String[] args) {
		Ex4JTableEmployee ex4 = new Ex4JTableEmployee();

	}

}
