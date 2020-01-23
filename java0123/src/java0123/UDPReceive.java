package java0123;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceive {

	public static void main(String[] args) {
		try {
			// 받는 소켓 생성
			DatagramSocket socket = new DatagramSocket(7777);
			// 데이터를 저장할 패킷 생성
			/*byte [] b = new byte[65536]; // 65536 대신 length 사용 가능
			// 외부에서 만들어졌기 때문에 배열 초기화가 안됨
			DatagramPacket dp = new DatagramPacket(b, b.length);
			*/
			
			// 데이터 전송받아 읽기
			while (true) {
				// 데이터를 저장할 패킷 생성
				// 이 두 개의 문장을 반복문 바깥에 만들면 통신은 되나
				// 긴 메시지를 보내고 난 뒤 짧은 메시지를 보내면
				// 짧은 메시지 뒤에 긴 메시지의 내용이 추가되는 형태가 되어 버림
				// 반복문 안에서 계속 사용해야 하는 데이터는 반복문 안에서 초기화를 해주어야 함
				byte [] b = new byte[65536]; // 65536 대신 length 사용 가능
				DatagramPacket dp = new DatagramPacket(b, b.length);
				
				// 대기하고 있다가 데이터를 전송받으면 동작
				socket.receive(dp);
				// 보낸 곳 확인
				System.out.println("보낸 곳 : " + dp.getAddress().getHostAddress());
				// 데이터 확인
				String msg = new String(b);
				System.out.println(msg);
			}
			
		} catch (Exception e) {
			System.out.println("예외1 : " + e.getMessage());
			e.printStackTrace();
		}

	}

}
