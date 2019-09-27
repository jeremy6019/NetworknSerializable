package define;

public class Stream3 {
/*
  
  ** 객체 직렬화 -Serializable 
  =>객체 단위로 데이터를 전송 
  => Serializable인터페이스를 implements한 클래스의 객체는 ObjectOutputStream, 
  ObjectInputStream클래스를 이용해서 전송이 가능합니다. 
  =>ObjectInputStream 과 ObjectOutputStream은 다른 Stream객체를 매개변수로 받아서 객체를 
  생성 
  
 ** RandomAccessFile 
 => 입력과 출력을 모두 할 수 있는 스트림 
 => 읽었던 내용을 다시 읽을 수 있는 스트림 
 1. 생성자 
 RandomAccessFile(File 또는 String, String mode)
 =>mode는 r(읽기), rw(읽고 쓰기), rws(synchronized- 동기화: 동시에 기록을 못함),
 rwd(읽고 쓰고 파일의 상태를 바로 변경) 
 =>파일의 내용을 읽거나 변경할 때 close()를 하기전까지는 파일의 정보는 갱신되지 않습니다. 
 rwd를 이용하면 바로 파일의 정보가 갱신됩니다.  
 
 2.메소드 
 void seek(long pos):읽을 위치를 이동시켜주는 메소드 
 void write(배열): 파일에 기록 
 int read(배열): 현재위치부터 배열의 크기만큼 읽어서 읽은 개수를 리턴, 읽은 것이 없으면 음수를 리턴 
 long getFilePointer():현재 위치를 리턴 
 long length(): 파일의 크기를 리턴 
 String readLine(): 한줄의 텍스트를 읽어서 리턴 
 
 =>다른 언어는 대부분 이방식을 이용해서 파일의 내용을 읽거나 기록합니다. 
 
 
 **AutoCloseable 
 =>자동으로 close()메소드를 호출해주는 인터페이스 
 =>java1.7버전 이상에서 try()안에서 AutoCloseable인터페이스를 구현한 클래스의 객체를 생성하면 
 try구문 안에서 예외발생에 상관없이 마지막에 close를 호출해 줍니다. 
 try-resource구문이라고 합니다. 
 => 이 구문을 사용할때 조심할 점은 프로트를 다른 곳에서 열때입니다. 
 Eclipse버전에 따라서 프로젝트를 import하면 설정되는 자바 버전이 다릅니다. 
 1.7아래 버전으로 설정이 되면 에러가 발생합니다. 
 
 ** 프로젝트에 사용하는 자바 버전 변경 
 => 프로젝트를 선택하고 마우스 오른쪽을 클릭해서  [Build Path] -[configure Build Path]를 선택 
 고 나면 [Libraries] 탭에서 edit를 눌러서 변경 
 => 
 1.2: 자바의 확장 클래스들이 추가 -Java 2 
 1.5: Generic적용 - 웹프로그래밍에서는 이 버전이상으로 작업 
 1.8: 람다와 스트림이 추가, 현재 안드로이드의 자바 버전 
 1.12: 가장 최근버전 AWT Deprecated 
 AWT를 할 때는 1.8버전 이하로 설정해야 합니다. 
 
** 표준 입출력 스트림 
System.in : 표준 입력 스트림 -바이트 스트림 
=>키보드로부터 문자열 단위로 입력을 받고자 할 때는 이 스트림을  Scanner 또는 BufferedReader 
를 이용해서 입력 받습니다.   
Scanner sc =new Scanner(System.in); 
변수 = sc.next자료형(); 

BufferedReader br = new BufferedReader(new InputStreamReader(system.in));
String input = br. readLine(); 

Scanner는 정수나 실수 또는 boolean을 입력받는 메소드도 존재하지만 BufferedReader는 
문자열만 입력 받습니다. 

 키보드 입력은 거의 대부분 문자열로 입력받습니다. 
 Scanner 의 nextInt를 이용해서 정수를 입력 받을 려고 하면 정수를 입력하면 괜찮지만 문자를 
 입력하면 예외가 발생합니다. 
 문자열로 입력받은 후에 Integer.pardrInt와 같은 메소드를 이용해서 정수로 변경하는 것이 좋습니다.
 입력을 받으면 유효성 검사를 해서 사용하는 것이 좋습니다. 
 
  BufferdeInputStream, BufferesOutputStream(PrintStream)
  BufferedReader, BufferedWriter(PrintWriter)
  ObjectInputStream, ObjectOutputStream 
  FileInputStream, FileOutputStream 
 
 2.표준 출력 스트림 
 System.out 
 =>표준 출력 장치에 내용을 출력해주는 스트림 - 모니터 
 
System.err 
=> 표준 출력 장치에 내용을 출력해주는 스트림 - 모니터 
=> 텍스트가 빨간색으로 출력 
=> 이클립스에서 에러나 예외를 발생시킬 때 나오는 텍스트가 이 스트림을 이용 

3. 스트림의 setIn 과 setOut메소드를 이용해서 입력과 출력을 변경하는 것이 가능 
서버프로그래밍에서는 예외가 발생하면 파일에 기록을 해놓는 것이 일반적입니다. 
System.setOut(new PrintStream("파일 경로"));
System.out.println("%s:%s\n", new Date(), e.getMessage()); 

** wave, mid 파일 재생 
Applet클래스의 static메소드인 newAudioClip(URL url) 메소드를 이용해서 객체를 생성하고 play 호출 

** www.mvnrepository.com 
=>java라이브러리를 다운로드 받을 수 있고 위치를 가져다가 사용할 수 있도록 해주는 사이트 
=> C&C++, C#보다  java나 python이 좋다고 애기하는 가장 큰 이유는 이렇게 3rd party개발자가
만들어 놓은 라이브러리를 사용하기 쉽다는 것입니다. 
=> 이러한 라이브러리를 이용하면 개발속도를 향상시킬 수 있습니다. 

** jar 
=> java archive: 자바 압축파일 
이형식에 한해서는 자바 프로그램이 알아서 압축을 풀어서 사용합니다. 

=> war: 자바 웹 애플리케이션 압축파일 
이형식의 파일은 java was가 압축을 해제해서 실행을 시킵니다. 

** jar파일을 프로젝트에서 사용하는 방법 
1. 프로젝트 안에 삽입한 경우에는 파일을 선택하고 마우스 오른쪽을 클릭해서 
add to build path메뉴를 실행 

2. 프로젝트 외부에 있을때는  configure build path 메뉴에서 add external libraries를 
클릭해서 jar파일을 선택 

=> 1번을 권장 
2번으로 하게 되면 다른 컴퓨터에서는 실행이 안될 수 있습니다. 


**mp3재생 
=>JLayer라이브러리를 이용해서 재생가능 
=> JLayer라는 라이브러리를 다운로드 받아서 사용 
=> Player객체를 생성할 때 OutputStream 을 대입 
play()호출하면 재생 


 
 
 
 
 
 
 
 
  
  
  
  
  
 
 */
}
