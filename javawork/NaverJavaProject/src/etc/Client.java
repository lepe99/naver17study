package etc;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Client {
    public static void main(String[] args) {
        try {
            // DatagramSocket 생성
            DatagramSocket socket = new DatagramSocket();

            // 구독하고 싶은 뉴스 주제 서버로 전송
            String data = "경제";
            byte[] bytes = data.getBytes();
            DatagramPacket sPacket = new DatagramPacket(
                    bytes, bytes.length, new InetSocketAddress("localhost", 50001));
            socket.send(sPacket);

            while (true) {
                // 뉴스 받기
                DatagramPacket rPacket = new DatagramPacket(new byte[1024], 1024);
                socket.receive(rPacket);

                // 문자열로 변환하여 콘솔에 출력
                String news = new String(rPacket.getData(), 0, rPacket.getLength(), "UTF-8");
                System.out.println(news);

                // 10번째 뉴스를 받으면 while문 종료
                if (news.contains("뉴스10")) break;
            }
            // DatagramSocket 닫기
            socket.close();
        } catch (Exception e) {
        }
    }
}
