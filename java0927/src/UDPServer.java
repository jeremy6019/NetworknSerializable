

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

	public static void main(String[] args) {
		try {
			
			//데이터를 받는 소켓 생성 
			DatagramSocket socket = 
					new DatagramSocket(7777);
			
			while(true) {
				//데이터를 넘겨받을 배열을 생성 
				//반복문 안에서 만들어야 매번 새로 생성 
				//바깥에서 만들면 이전 내용이 출력될 수 있음 
				byte[] data = new byte[1024]; 
				//데이터를 전송받기 위한 패킷을 생성 
				DatagramPacket dp = 
						new DatagramPacket(data, 1024);
				socket.receive(dp);
				//보낸 곳 확인 
				System.out.printf("보낸 곳: %s\n",
					dp.getAddress().getHostAddress());
			    //받은 내용을 문자열로 변환해서 출력 
				String message = new String(data);
			    System.out.printf("메세지:%s\n", message.trim());
			    
			}
			
		} catch(Exception e) {
			System.out.printf("%s\n", e.getMessage());
			e.printStackTrace();
		}

	}

}
