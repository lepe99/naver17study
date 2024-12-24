package day1224;
// 어제 13번 예제 예외처리 다르게 ( throws 사용 x)
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex1FileException {

	public static void scoreRead() { // 예외 여러개 처리 가능
		FileReader fr = null;
		BufferedReader br = null;
		
		int sum = 0, score, avg, count = 0;	
		
		try {
			
			fr = new FileReader("/Users/lee/naver1210/score.txt");
			System.out.println("파일을 찾았어요");
			br = new BufferedReader(fr);
			
			while(true) {
				String line;
				line = br.readLine(); // null 일 경우 갯수에도 포함 안되고 while 문을 빠져나간다
				
				if(line == null)
					break;
				try {
					score = Integer.parseInt(line);
					sum += score;
					count++;
					System.out.println(count + "번 점수 : " + score);
				} catch (NumberFormatException e) { // line 이 정수형 변환이 되지 않는 경우일 때
					System.out.println("문자가 있네요 : " + e.getMessage());
				} 
				
			}
			avg = sum / count;
			System.out.println("=".repeat(15));
			System.out.println("총 합계 : " + sum);
			System.out.println("평균 : " + avg);
			
		} catch (FileNotFoundException e) { // 찾는 파일이 존재하지 않을 때
			System.out.println("파일을 찾을 수 없습니다 : " + e.getMessage());
		} catch (IOException e) { // br, fr 로 인한 일반 Exception 처리
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException | NullPointerException e) { 
				// 파일이 존재하지 않아 불러오지 못하였을 때 NullPointerException 예외를 처리한다
				System.out.println(e.getMessage());
			}	
		}
		
	// try 로 큰 영역을 묶은 다음, 나올 수 있는 예외를 catch 로 예외 처리 하였다

	}
	
	
	public static void main(String[] args) {
		scoreRead();
		System.out.println("** 정상 종료 **");
	}

}
