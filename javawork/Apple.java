//Apple.java 로 컴파일 하기 위한 기본 자바클래스를 생성해보세요
public class Apple
{
	public static void main(String[] args)
	{
		System.out.println(args[0]); //args의 0번 배열값 출력
		System.out.println(args[1]); //args의 1번 배열값 출력
		System.out.println("두 수를 더해보자");
		System.out.println(args[0] + args[1]); //문자열이라 정상적인 덧셈 불가
		
		//숫자 계산을 위해 문자열을 숫자로 변환 하려면 Integer.parseInt를 사용
		int su1 = Integer.parseInt(args[0]);
		int su2 = Integer.parseInt(args[1]);
		System.out.println("두 수의 합은 " + (su1+su2) + "입니다");
	}

}