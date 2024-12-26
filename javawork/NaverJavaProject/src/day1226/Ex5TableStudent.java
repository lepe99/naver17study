package day1226;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex5TableStudent extends JFrame{
	JTable table;
	static final String FIlENAME = "/Users/lee/naver1210/student.txt";	
	List<Student> list = new ArrayList<>();
	
	public Ex5TableStudent() {
		super("학생성적관리");
		this.setBounds(300, 100, 400, 400);
		this.initDesign();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
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
	
	
	
	
	public void initDesign() {
		this.studentFileRead();
		// list 데이터를 읽어서 테이블에 출력 후 프레임에 출력하시오
		// 범례는 이름, 국어, 영어, 총점, 평균
		
		// 제목
		String[] title = {"이름", "국어", "영어", "총점", "평균"};
		
		// 데이터
		String[][] data = new String[list.size()][5];
		
		int i = 0;
		for(Student s : list) {
			data[i][0] = s.getName();
			data[i][1] = String.valueOf(s.getKor());
			data[i][2] = String.valueOf(s.getEng());
			data[i][3] = String.valueOf(s.getSum());
			data[i][4] = String.valueOf(s.getAvg());
			
			i++;
		}
		
		table = new JTable(data, title);
		this.add("Center", new JScrollPane(table));
	}
	
	
	public static void main(String[] args) {
		Ex5TableStudent ex5 = new Ex5TableStudent();

	}

}
