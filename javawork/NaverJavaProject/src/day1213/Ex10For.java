package day1213;

public class Ex10For {

	public static void main(String[] args) {
		for(int i=1; i<=5; i++)
			System.out.print(i + " ");
		System.out.println();
		for(int i=1; i<=10; i+=2)
			System.out.print(i + " ");
		System.out.println();
		for(int i=10; i>=1; i--)
			System.out.print(i + " ");
		System.out.println();
		for(int i=10; i<=100; i+=10)
			System.out.print(i + " ");
		
		System.out.println();
		System.out.println("break");
		for(int i=1; i<=10; i++) {
			System.out.println(i + " ");
			if(i==5) break;
		}
		
		System.out.println();
		System.out.println("Continue");
		for(int i=1; i<=10; i++) {
			if(i%2 == 1) continue;
			System.out.println(i + " ");
		}	
	}
		
}