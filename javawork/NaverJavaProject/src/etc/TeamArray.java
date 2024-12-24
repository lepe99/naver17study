package etc;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class TeamArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] member = {"꽝", "김녹엽", "김동휘", "김준호", "박서희"
						, "박수진", "백성현", "서지훈", "오하늬", "이원재"
						, "이재호", "이재희", "장진욱", "전세호", "전종원"
						, "조진용", "재원석", "최원웅", "최은영", "최준혁"};
		
		int[] rnd = new int[20];
		String title;
		int teamInwon, teamCount;
		String[][] team;
		
		System.out.println("팀의 제목을 입력하세요");
		title = sc.nextLine();
		System.out.println("한 팀당 인원수를 입력하세요");
		teamInwon = sc.nextInt();
		teamCount = 20/teamInwon;
		
		team = new String[teamCount][teamInwon];
		
		Random random = new Random();
		
		for(int i=0; i<20; i++) {
			rnd[i] = random.nextInt(20);
			for(int j=0; j<i; j++) {
				if(rnd[i] == rnd[j]) {
					i--;
					break;
				}
			}	
		}
		
		// 오늘 날짜 출력
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(EEE)");
		System.out.println("\t**" + title + "(" + sdf.format(new Date()) + ")**");
		
		// 팀에 rnd 순서대로 이름 할당
		int idx = 0;
		for(int i=0; i<teamCount; i++) {
			for(int j=0; j<teamInwon; j++) {
				team[i][j] = member[rnd[idx++]];
			}
		}
		
		
		for(int i=0; i<teamCount; i++) {
			System.out.println();
			System.out.printf("[%d조] : ",i + 1);
			for(int j=0; j<teamInwon; j++) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print(team[i][j] + " ");
			}
		}
			
	}

}
