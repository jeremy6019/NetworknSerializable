package network;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {

		try {
			//	서버소켓을 생성 
			ServerSocket ss = new ServerSocket(9000);
			while(true) {
				System.out.printf("서버 대기중 ....\n");
				//클라이언트 요청 대기중 
				Socket socket = ss.accept();
				//접속한 클라이언트 정보 출력 
				System.out.printf("접속자:%s\n",
						socket.toString());
				//클라이언트가 전송한 내용을 출력 
				BufferedReader br =
						new BufferedReader(
								new InputStreamReader(
										socket.getInputStream()));
				    while(true) {
				     	String line = br.readLine();
					    if(line==null) {
						   break;
					    }
					   System.out.printf("전송한 내용:%s\n",
							line);
				    }
					 br.close();
					 socket.close();
			}
				} catch(Exception e1) {
			System.out.printf("%s\n", e1.getMessage());
			e1.printStackTrace();
		      }
	
	}

}
