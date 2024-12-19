package day1218;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatExam {

	public static void main(String[] args) {
		// java.text.SimpleDateFormat
		// format()
		Date date = new Date();
		System.out.println(date);
		
		// 내가 원하는 포맷양식으로 출력해 보자
		// M : 월, m : 분, H : 24시간, h : 12시간, E : 요일, a : 오전/오후
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy년MM월dd일 HH:mm EEE"); // 요일 요약
		SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm EEEE"); // 요약 풀네임
		
		System.out.println(sdf1.format(date));
		System.out.println(sdf2.format(date));
		System.out.println(sdf3.format(date));
		System.out.println(sdf4.format(date));
		
		int num1 = 45678900;
		int num2 = 34567;
		
		NumberFormat nf1 = NumberFormat.getInstance(); // 3자리마다 콤마
		System.out.println("num1 = " + nf1.format(num1)); 
		System.out.println("num2 = " + nf1.format(num2));
		
		NumberFormat nf2 = NumberFormat.getCurrencyInstance(Locale.CHINA); // 앞에 통화
		System.out.println("num1 = " + nf2.format(num1)); 
		System.out.println("num2 = " + nf2.format(num2));
	}

}
