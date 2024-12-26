package day1226;

public class Student {
	private String name;
	private int kor;
	private int eng;
	
	public Student() {
		
	}

	public Student(String name, int kor, int eng) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public int getSum() {
		int sum = kor + eng;
		return sum;
	}
	
	public int getAvg() {
		int sum = getSum();
		int Avg = sum / 2;
		return Avg;
	}
	
	
}
