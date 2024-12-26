package day1226;

public class Employee {
	private String employeeName;
	private int age;
	private String hp;
	private String address;
	
	public Employee() {
		
	}

	public Employee(String employeeName, int age, String hp, String address) {
		super();
		this.employeeName = employeeName;
		this.age = age;
		this.hp = hp;
		this.address = address;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
