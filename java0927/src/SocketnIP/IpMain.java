package SocketnIP;

import java.net.InetAddress;

public class IpMain {

	public static void main(String[] args) {
     
		// 파일, 네트워크, 데이터베이스를 사용할 때는 
		//예외처리를 강제하는 경우가 많습니다. 
		try {
			InetAddress addr = 
					InetAddress.getByName(
							"www.daum.net");
			System.out.printf("다음:%s\n", addr);
			
			//구글의 서버 IP주소 전부 출력 
			InetAddress[] googles = 
					InetAddress.getAllByName("www.google.com");
			for(InetAddress address : googles) {
				System.out.printf("%s\n", address);
			}
			
		} catch(Exception e1){
			System.out.printf("%s\n", e1.getMessage());
			e1.printStackTrace();
		}

	}

}
