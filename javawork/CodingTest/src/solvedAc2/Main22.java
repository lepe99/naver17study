package solvedAc2;
// https://www.acmicpc.net/problem/10814
// 정수형, 문자열을 동시에 입력받아 저장할 수 있는 자료구조가 없기에 새로운 클래스를 만들어서 해결
// stream()을 사용, 새로운 Comparator를 사용하여 정렬
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main22 {
	public static void main(String[] args) {
		try {
			run();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static void run() throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력부
		int n = Integer.parseInt(br.readLine());
		class User {
			int age;
			String name;
		}
		List<User> userList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			User user = new User();
			user.age = Integer.parseInt(st.nextToken());
			user.name = st.nextToken();
			userList.add(user);
		}
		userList.stream()
				.sorted((u1, u2) -> u1.age - u2.age)
				.forEach(user -> sb.append(user.age).append(" ").append(user.name).append("\n"));
				
		System.out.println(sb);
		br.close();
	}
}


