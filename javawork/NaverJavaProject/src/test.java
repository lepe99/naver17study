import day1227.Ex4Thread;

public class test extends Thread {
    String msg;
    int count;

    public test(String msg, int count) {
        this.msg = msg;
        this.count = count;
    }

    @Override
    public void run() { // 스레드 클래스의 메서드를 오버라이딩
        for (int i = 1; i <= count; i++) {
            System.out.println(msg + ":" + count);
        }
    }

    public static void main(String[] args) {
    }
}