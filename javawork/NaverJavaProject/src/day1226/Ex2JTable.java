package day1226;

//import java.util.Arrays;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex2JTable extends JFrame{
	JTable table;
	
	public Ex2JTable() {
		super("JTable공부");
		this.setBounds(300, 100, 300, 300); // 시작위치와 크기 지정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x 버튼 클릭 시 종료
		this.initDesign();
		this.setVisible(true); // 프레임 보이게 하기
	}
	
	public void initDesign() {
		// 기본 레이아웃은 BorderLayout
		// 이 레이아웃은 동 서 남 북 센터롤 위치를 정하는 레이아웃
		
		// 방법 1
//		String[] title = {"이름", "혈액형", "나이"};
//		String[][] data = {
//				{"이미자", "AB", "23"}
//				, {"손기자", "A", "34"}
//				, {"박민영", "B", "19"}
//		};
		
		// 방법 2
//		Vector<String> title = (Vector<String>) Arrays.asList("이름", "혈액형", "나이");
//		Vector<String> data1 = (Vector<String>) Arrays.asList("이미자", "AB", "23");
//		Vector<String> data2 = (Vector<String>) Arrays.asList("손기자", "A", "34");
//		Vector<String> data3 = (Vector<String>) Arrays.asList("박민영", "B", "19");
		
		Vector<String> title = new Vector<>();
		title.add("이름");
		title.add("혈액형");
		title.add("나이");
		
		Vector<String> data1 = new Vector<>();
		data1.add("이미자");
		data1.add("AB");
		data1.add("23");
		
		Vector<String> data2 = new Vector<>();
		Vector<String> data3 = new Vector<>();
		
		Vector<Vector<String>> data = new Vector<>();
		data.add(data1);
		data.add(data2);
		data.add(data3);
		
		// JTable 생성
		table = new JTable(data, title);
		
		// North 에 JLabel(단순 글자 출력)을 추가
		this.add("North", new JLabel("데이터 출력 테이블", JLabel.CENTER));
		
		// frame 의 center 에 추가
//		this.add("Center", table); // table 의 범례가 나오지 않음, 데이터가 많을 경우 스크롤도 안됨
		// data 매개변수엔 North, East, West, South, Center 올 수 있음
		this.add("Center", new JScrollPane(table)); // JScrollPane 으로 생성해서 넣어야 나타난다
		
	}

	public static void main(String[] args) {
		Ex2JTable ex2 = new Ex2JTable();

	}

}
