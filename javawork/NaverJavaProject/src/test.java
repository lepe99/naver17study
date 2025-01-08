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
        Ex4Thread ex1 = new Ex4Thread("1번 쓰레드", 300);
        Ex4Thread ex2 = new Ex4Thread("2번 쓰레드", 300);
        Ex4Thread ex3 = new Ex4Thread("3번 쓰레드", 300);

        //run 메서드 호출-start
        ex1.start();
        ex2.start();
        ex3.start();
    }
}