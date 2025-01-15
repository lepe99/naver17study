package etc;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static DatagramSocket socket = null;
    // 최대 10개의 스레드로 요청을 처리하는 스레드풀 생성
    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        // UDP 서버 실행
        startServer();

        Scanner sc = new Scanner(System.in);
        while (true)
            if (sc.nextLine().equals("q")) break;
        sc.close();

        // UDP 서버 중지
        stopServer();
    }

    public static void startServer() {
        //작업 스레드 정의
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    // DatagramSocket 생성 및 Port 바인딩
                    socket = new DatagramSocket(50001);
                    System.out.println("s: 시작됨");

                    while (true) {
                        // 클라이언트가 구독하고 싶은 뉴스 종류 얻기
                        DatagramPacket rPacket = new DatagramPacket(new byte[1024], 1024);
                        socket.receive(rPacket);

                        // 작업 큐에 처리 작업(Runnable) 넣기
                        threadPool.execute(() -> {
                            try {
                                String news = new String(rPacket.getData(), 0, rPacket.getLength());
                                SocketAddress socketAddress = rPacket.getSocketAddress();

                                for (int i = 1; i <= 10; i++) {
                                    String data = news + ": 뉴스" + i;
                                    byte[] bytes = data.getBytes("UTF-8");
                                    DatagramPacket sPacket = new DatagramPacket(
                                            bytes, 0, bytes.length, socketAddress);
                                    socket.send(sPacket);
                                }
                            } catch (Exception e) {
                            }
                        });
                    }
                } catch (Exception e) {
                    System.out.println("s: " + e.getMessage());
                }
            }
        };
        // 스레드 시작
        thread.start();
    }

    public static void stopServer() {
        // UDP 서버 닫음, Port 할당 해제
        socket.close();
        threadPool.shutdownNow(); // 스레드풀 종료
        System.out.println("s: 종료됨");
    }
}
