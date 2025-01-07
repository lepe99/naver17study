import lombok.*;

import java.util.Calendar;


public class test {
    Calendar cal = Calendar.getInstance();

    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH);
    int day = cal.get(Calendar.DAY_OF_MONTH);
    int week = cal.get(Calendar.DAY_OF_WEEK);
    int amPm = cal.get(Calendar.AM_PM);
    int hour = cal.get(Calendar.HOUR);
    int minute = cal.get(Calendar.MINUTE);
    int second = cal.get(Calendar.SECOND);

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(arr[-1]);
    }

}
