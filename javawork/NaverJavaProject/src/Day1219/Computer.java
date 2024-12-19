package Day1219;

public class Computer {
	int sum(int ... values) {
		int sum = 0;
		
		for(int val : values)
			sum += val;
		
		return sum;
	}
}
