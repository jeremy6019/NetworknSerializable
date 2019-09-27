package define;

public class network {
/*
  
  **네트워크 용어 
  =Protocol: 데이터 송수신을 위한 규칙 또는 규약 
  => IP:인터넷에서 단말기를 구분하기 위해서 부여한 주소 
  IPv4: 32비트 주
  IPv6: 128비트 주소 
  아직까지는 IPv6를 IPv4형태로 변경해서 표시하는 곳이 많습니다. 
  
  IPv4는 0.0.0.0 ~ 255.255.255.255 
  32비트를 8비트씩 나누어서 10진수로 표현 
  
  127.0.0.1: 루프백 주소여서 자신을 의미 
  IPv6에서는 0::0::0::0::0::0::0::1
  =>서버 프로그램에서 자신의 컴퓨터에서 접속하면 위의 IP가 보입니다. 
  
  10.x.x.x
  172.16.x.x ~ 172.31.x.x
  192.168.x.x - 192.168.255.255
  =>실제 IP주소가 아니고 사설 IP주소   
  외부에서 접속할 수 있는 IP가 아니고 내부망에서만 사용가능한 IP
  
  =>port번호: 서비스 번호 
  하나의 IP는 물리적인 장치를 구별하기 위한 것이고 장치안에서 서로 다른 여러 개의 서비스가 네트워크를 
  사용할 때 구분하기 위한 번호 
  0 - 65535 
  
  => 어떤 서버의 응용프로그램에 접속하기 위해서는 IP주소:포트번호 형태로 접속을 해야 합니다.
  포트번호를 생략하는 경우는 기본 포트번호를 사용하는 경우 입니다. 
 http: 80, https:443 
 oracle(1521, 8080), mysql(3306), mongodb(27017) 
 tomcat(8080)
 
  => 0-1023번까지는 예약된 번호가 많습니다. 
  프로그램을 만들때 0-1023번까지는 사용하지 않는 것이 좋고 많이 사용하는 애플리케이션의 포트
  번호도 사용하지 않는 것이 좋습니다. 
 
  =>TCP/IP:인터넷 프로토콜 
  =>Domain: IP주소 대신에 사용하는 문자로 된 별명 
  =>DNS(Domain Name Service):문자로 입력한 Domain을 IP주소로 변환해주고 IP주소를
  Domain으로 변환해 주는 서비스 
  
   => 명령어 
   ping ip주소: 에코 명령 - 상대방에게 신호를 전송하고 돌려받는 것 
   ipconfig(ifconfig): 자신의 주소 정보 확인하는 명령 /all을 추가하면 자세하게 출력 
   
  인터넷 확인 
   ping 127.0.0.1: 자신의 LAN확인 
   ping 라우터주소: 인터넷 선 연결 잘못 
   ping DNS주소: 인터넷 망 문제 
 
   **InetAddress
   =>컴퓨터의 IP정보를 저장하는 클래스 
   1. 객체 생성 
   InetAddress static getLocalHost()
   InetAddress static getByName()("IP 주소나 도메인")
   InetAddress static getAllByName()("IP 주소나 도메인")
   => 잘못된 주소가 입력 되면 UnknownHostException이 발생 
   
  2.메소드 
  String getHostName()
  byte[] getAddress()
  String getHostAddress()
  String toString() 
  
 **Socket
 => 네트워크 인터페이스 카드 (NIC-LAN카드) 를 프로그램에서 사용하기 위해 추상화한 클래스 
 => 소켓의 종류는 2가지 - Stream Socket 과 Datagram Socket   
       
1.Socket생성자 
Socket()
socket(InetAddress addr , int port): 접속할 주소와 포트번호를 설정 
Socket(String addr, int port): 접속할 주소와 포트번호를 설정 
Socket(InetAddress addr, int port, InetAddress localAddr, int localPort): 접속할 주소와 포트번호를
설정하고 자신의 주소와 포트번호를 설정 - 자신에게 주소가 2개이상있는 경우에는 자신의 
주소를 설정할 수 있습니다. 
=> 주소가 잘못되면 NullPointException이 발생하고 포트번호가 잘못되면 
illegalArgumentException   

2.메소드 
void close(): 닫는 메소드 
InetAddress getInetAddress()
int getPort() 
=> 접속한 상대방의 주소와 포트번호 

InetAddress getLocalAddress()
int getLocalPort() 
=> 자신의 주소와 포트번호 

InputStream getInputStream() : 전송 되어온 데이터를 읽기 위한 스트림 리턴 
OutputStream getoutputStream(): 전송을 하기 위한 스트림 리턴  

ReceiveBufferSize: 데이터를 읽어오기 위한 버퍼의 크기 
SendBuffeSize: 데이터를 전송하기 위한 버퍼의 크기 
SoTimeout: 접속을 시도하는데 사용할 수 있는 최대 시간  

3.StreamSocket 
=>TCP프로토콜을 이용하는 연결형 소켓 
1) 클라이언트용 소켓(데이터를 요청)
Socket socket = new Socket(접속할 서버주소, 포트번호)로 생성 

2) 서버소켓(데이터를 제공) 
=> 생성자 
ServerSocket()
ServerSocket(int port): port에 접속할 수 있는 서버 소켓을 생성 
ServerSocket(int port, int backlog): backlog는 동시에 연결할 수 있는 클라이언트의 개수 

=>클라이언트의 접속을 대기하는 메소드 
Socket accept():서버는 클라이언트가 접속할 때까지 대기하고 클라이언트가 접속을 하면 클라이언트와
통신할 수 있는 Socket을 리턴 

3)서버와 클라이언트 통신 과정 
=>서버소켓을 생성하고 서버는 accept메소드로 대기
=>서버에 접속하는 소켓을 생성해서 서버와 연결 
=> 소켓의 스트림을 이용해서 통신을 하면 됩니다. 

   **프로그램 작성 및 실행 과정 
   소스코드 작성(.java - 인간과 컴파일러가 알아보는 코드 ) -> 컴파일 (.class-컴파일러가 운영체제나 
   virtual Machine이 이해할 수 있는 코드로 변경, 이과정에서 에러가 나면 문법오류- 명령은 javac파일명령.java)
   -> 실행(run - build(실행가능한 프로그램을 만드는 것)  -> load(실행을 위해서 주기억장치에 적재) -> run) 
   java main메소드를 소유한 클래스  
  
 **UDP Socket 
 =>세션연결없이 데이터를 일방적으로 전송하는 소켓 
 => 데이터만 전송하기때문에 전송효율이 TCP방식보다 좋습니다.
 받는 쪽에서 보내는 쪽에게 수신여부를 전송할 수 없기 때문에 신뢰할 수 없습니다. 
 중요하지 않은 메시지를  대량으로 전송하는 시스템에서 사용 
 Google의 FCM(구글의 안드로이드 서버에서 안드로이드 기기에게 메세지를 전송하는 기술 )
 과 Apple의 APNS(애플의 iOS서버에서 IOS기기에게 메세지를 전송하는 기술) 이 UDP Socket
 을 이용합니다. 
 
=> 통신을 하기 위해서는 DatagramPacket(데이터)과 SatagramSocket(송수신을 수행할 소켓)
클래스의 객체가 필요 

   1.DatagramSocket
   1)생성자 
   DatagramSocket(): 보내는 쪽에서 만드는 소켓 
   DatagramSocket(int port) : 받는 쪽에서 만드는 소켓 
   DatagramSocket(int port, InetAddress addr)
  
  2)메소드 
  void receive(DatagramPacket dp): 받는 메소드 -DatagramPacket변수만 연결해주면 알아서 
  객체가 대입
  void send(DatagramPacket dp): 보내는 메소드- DatagramPacket 의 내용을 채워서 전송 

2.DatagramPacket
=>전송할 데이터를 만드는 클래스 
1)생성자 
DatagramPacket(byte[] buf, int length):전송을 받기 위한 데이터를 생성 
DatagramPacket(byte[] buf, int length, InetAddress addr, int port):보내기 위한 데이터를 생성 

2) 메소드 
byte[] getData():내용 
int getlength():길이   
  
  
 
  
 
 */
	
}
