package day1212;

import java.util.Scanner;

public class Ex9Scanner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 이름 키 몸무게 읽기
		String name;
		double height, weight;
		System.out.println("이름 입력");
		name = sc.nextLine();
		System.out.println("키와 몸무게 입력");
		height = sc.nextDouble();
		weight = sc.nextDouble();
		sc.close();
		System.out.println("** " + name + "님의 키와 몸무게 **");
		System.out.printf("키 : %.1f\t몸무게 : %.1f", height, weight);
	}

}
