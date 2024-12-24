package day1223;

class UserException extends Exception { // 사용자 예외 클래스 선언
	public UserException(String message) {
		super(message);
	}
}
public class Ex12UserException {

	public static void inputName(String name) throws UserException {
		if(name.equals("김태희") || name.equals("송혜교"))
			throw new UserException("거짓 이름을 말하고 있네요!"); // 사용자 예외 출력	
		else
			System.out.println("내 이름은 " + name + "입니다");
	}
	
	
	public static void main(String[] args) {
		try {
			inputName("성시경");
		} catch (UserException e) {
			System.out.println("오류메세지 : " + e.getMessage());
		}
		
		try {
			inputName("김태희");
		} catch (UserException e) {
			System.out.println("오류메세지 : " + e.getMessage());
		}
		
		System.out.println("정상종료");

	}

}
