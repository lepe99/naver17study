package day1217;

public class Ex3Array {

	public static void main(String[] args) {
		int[] arr1;
		arr1 = new int[5]; // 할당과 시에 초기값이 들어간다 (0)
		arr1[0] = 23;
		arr1[3] = 50;
		for(int i=0; i<arr1.length; i++)
			System.out.println("arr1[" + i + "] = " + arr1[i]);
		System.out.println("=".repeat(30));
		
		int[] arr2 = new int[5];
		arr2 = new int[] {23, 45, 56, 11, 29};
		for(int i=0; i<arr2.length; i++)
			System.out.println("arr2[" + i + "] = " + arr2[i]);
		System.out.println("=".repeat(30));
		
		int[] arr3 = new int[] {90, 100, 89, 45, 88};
		for(int i=0; i<arr3.length; i++)
			System.out.println("arr3[" + i + "] = " + arr3[i]);
		System.out.println("=".repeat(30));
	}

}
