package day1217;

public class Ex14StringSort {

	public static void main(String[] args) {
		String[] names = {"박남정", "공효진", "김미나", "이진", "손석구", "Adams", "Jimmy"};
		//이름의 오름차순으로 출력
		for(int i=0; i<names.length; i++) {
			for(int j=i+1; j<names.length; j++) {
//				if(names[i].compareTo(names[j]) > 0) { // 오름차순 정렬
				if(names[i].compareTo(names[j]) < 0) { // 내림차순 정렬
					String temp = names[i];
					names[i] = names[j];
					names[j] = temp;
				}
			}
		}
		for(int i=0; i<names.length; i++) {
			System.out.println(i + " : " + names[i]);
		}

	}

}
// compareTo 개념 다시 찾아보기