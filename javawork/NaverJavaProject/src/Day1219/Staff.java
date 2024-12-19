package Day1219;

public class Staff {
	/*
	 * 멤버변수 사원명 직급 기본급 수당 가족수
	 * 디폴트 생성자 -> 사원명, 직급 가족수를 인자로
	 * setter, getter 메소드 사용	
	 * 직급에 따라 기본급 / 부장 = 450 과장 = 300 대리 = 250 사원 150 / getPay() 통해 반환
	 * 직급에 따라 수당 / 부,과장 = 70 대리,사원 = 50 / getExtraPay()
	 * getPay() 값을 반환받아서 세금 5프로를 구해서 반환하는 getTax()
	 * 가족수가 5인 이상이면 30 반환, 2인 이상 10 반환, 나머지 0 / getFamPay()
	 * 실수령액을 구해서 반환하는 메서드 기본급 + 수당 - 세금 + 가족수당을 구해서 반환 / getNetPay()
	 */
	
	private String staffName;
	private String position;
	private int pay;
	private int extraPay;
	private int familyNum;
	
	// 생성자
	public Staff(String staffName, String position, int familyNum) {
		this.staffName = staffName;
		this.position = position;
		this.familyNum = familyNum;
	}

	// getter, setter
	
	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	
	public int getPay() {
		String pos = this.getPosition();
		pay = switch(pos) {
		case "부장" -> 450;
		case "과장" -> 300;
		case "대리" -> 200;
		case "사원" -> 150;
		default -> 0;
		};
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	
	public int getExtraPay() {
		String pos = this.getPosition();
		extraPay = switch(pos) {
		case "부장", "과장" -> 70;
		case "대리", "사원" -> 50;
		default -> 0;
		};
		return extraPay;
	}

	public void setExtraPay(int extraPay) {
		this.extraPay = extraPay;
	}

	
	public int getFamilyNum() {
		return familyNum;
	}

	public void setFamilyNum(int familyNum) {
		this.familyNum = familyNum;
	}
	
	// 추가 getter
	public double getTax() {
		double tax = this.getPay() / 20.0;
		return tax;
	}
	
	
	public int getFamPay() {
		int numF = this.getFamilyNum();
		int famPay;
		
		if(numF >= 5) famPay = 30;
		else if (numF >= 2) famPay = 10;
		else famPay = 0;
		
		return famPay;
	}
	
	
	public double getNetPay() {
		//기본급 + 수당 - 세금 + 가족수당
		int pay1 = this.getPay();
		int extraPay1 = this.getExtraPay();
		double tax1 = this.getTax();
		int famPay1 = this.getFamPay();
		
		double netPay = pay1 + extraPay1 - tax1 + famPay1;
		return netPay;
	}
	
	
	
	
}
// 질문 1 자동생성 된 g, s  안쓰는건 어떻게
// 질문 2 생성자가 setter 메소드 역할 대체하는게 맞는가
