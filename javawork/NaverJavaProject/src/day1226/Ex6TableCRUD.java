package day1226;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

// CREATE READ UPDATE DELETE (DB)
public class Ex6TableCRUD extends JFrame {
	JTable table;
	static final String FIlENAME = "/Users/lee/naver1210/student.txt";	
	List<Student> list = new ArrayList<>();
	DefaultTableModel tableModel; // 추가, 삭제등의 메서드를 가지고 있는 클래스 모델
	JTextField tfName, tfKor, tfEng;
	JButton btnAdd;
	
	
	public Ex6TableCRUD() {
		super("학생관리");
		this.setBounds(300, 100, 400, 400);
		
		this.initDesign();
		this.setVisible(true);
		
		// 윈도우 x 버튼 클릭 시 이벤트를 발생시켜서 파일을 저장한다
		// 익명 내부 클래스 형태로 이벤트를 구현
		this.addWindowListener(new WindowAdapter() { 
			@Override
			public void windowClosing(WindowEvent e) {
				// list 의 내용을 파일에 저장한다
				saveFile();
				//프로그램 종료
				System.exit(0);
				
				super.windowClosing(e);
			}
		});
		
	
	}
	
	
	public void initDesign() {
		// 파일을 읽어온다
		this.studentFileRead();
		
		// 테이블을 생성해서 center 에 추가
		String[] title = {"이름", "국어", "영어", "총점", "평균"};
		tableModel = new DefaultTableModel(title, 0);
		table = new JTable(tableModel);
		//frame 에 추가
		this.add("Center", new JScrollPane(table));
		
		// 입력부분 디자인
		JPanel panel = new JPanel();
		tfName = new JTextField(5);
		tfKor = new JTextField(4);
		tfEng = new JTextField(4);
		
		btnAdd = new JButton("추가");
		
		// panel 에 각 컴포넌트들 추가
		panel.add(new JLabel("이름"));
		panel.add(tfName);
		panel.add(new JLabel("국어"));
		panel.add(tfKor);
		panel.add(new JLabel("영어"));
		panel.add(tfEng);
		panel.add(btnAdd);
		
		// frame 에 panel 을 상단에 추가하자
		this.add("North", panel);
	}
	
	public void saveFile() {
		// List 의 내용을 파일에 저장한다
	}
	
	public void studentFileRead() {
		// 파일을 읽어서 list 변수에 담기
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(FIlENAME);
			br = new BufferedReader(fr);
			
			while(true) {
				String line = br.readLine();
				if(line == null) break;
				String[] s = line.split("\\|");
				
				Student student = new Student();
				student.setName(s[0]);
				student.setKor(Integer.parseInt(s[1]));
				student.setEng(Integer.parseInt(s[2]));
				
				list.add(student);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException | NullPointerException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Ex6TableCRUD ex6= new Ex6TableCRUD();

	}

}
