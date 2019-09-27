

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
    public static void main(String[] args) {
        //파일처리 네트워크 데이터베이스는 
    	//사용을 할 때 반드시 예외처리를 예외처리를 해야합니다. 
		try {
			//	서버소켓을 만들기 
			//8000번포트로 클라이언트와 통신하도록 생성 
			ServerSocket ss = new ServerSocket(8000);
			//무한반복 
			while(true) {
				System.out.printf("서버 대기 중 ....\n");
				//클라이언트 접속 대기  
				//클라이언트가 접속하면 소켓을 만들고 
				//아래줄을 실행시킵니다. 
				// 접속이 없으면 여기서 계속 대기 
				Socket socket = ss.accept();
				
				//접속한 클라이언트의 메세지 확인 
				System.out.printf("접속자:%s\n",
						socket.toString());
				
				//클라이언트가 전송한 내용을 읽어서 출력하기  
				BufferedReader br =
						new BufferedReader(
								new InputStreamReader(
										socket.getInputStream()));
				String line ="";
				while(true) {
				    //한 줄 가져오기  
					line = br.readLine();
					if(line==null) {
						   break;
					 }
					//가져온 내용이 있으면 출력 
					System.out.printf("전송한 내용:%s\n", line);
				  }
				
				  //서버가 클라이언트에게 메세지 보내기 -echo 
				    PrintWriter pw = new PrintWriter(
					    socket.getOutputStream());				    
					pw.println("반사:"+line);
				    pw.flush();
				    //사용한 객체 닫기 
				    //이작업이 안되면 다음에 켓을 사용할 수 없게 됩니다. 
					br.close();
					socket.close();
			    }
			
			} catch(Exception e) {
				//예외발생 메세지를 출력 
				System.out.printf("%s\n", e.getMessage());
				//예외발생 위치를 확인하기 위해서 작성 
				e.printStackTrace();
		      }
	
	}

}
