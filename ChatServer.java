import java.net.*;
import java.util.*;//vector 클래스를 사용하기 위해


public class ChatServer extends Thread {
  //속성 - C언어의 전역변수라고 이해하자
  ServerSocket serv;  //서버소켓
  Vector v; //링크드리스트 구조, 객체를 저장, 예외처리를 안해도 됨

  //생성자
  public ChatServer() {
    try{
      v = new Vector();//벡터 생성(배열처럼 사용)


      serv = new ServerSocket(8888);  //서버소켓포트 8888
      System.out.println("채팅서버 시작");  //예외가 발생하지 않으면 이것이 실행
    } catch (Exception e) {
      System.out.println(e.toString()+" 1"); //예외가 발생하면 예외를 문자열로 출력
    }
  }

  //일반 메서드
public void sendAll(String msg){
  //클라이언트로부터 수신된 문자열을 모든 접속자에게 송신
  for(int i = 0; i < v.size(); i++){//접속 클라이언트 수 만큼 반복
    ChatThread tmp = (ChatThread)v.get(i);//벡터에 저장된 원소를 반환(반드시 저장 당시의 타입으로 캐스팅 필요)
    if(tmp.chk == true){//각 스레드가 정상일 u만 전송
    tmp.sendMsg(msg);//각각의 스레드에 있는 송신 메소드를 활용
  }
}
}
  //스레드 상속일 경우 run() 메서드 반드시 구현
  public void run() {
    try {
      while (true) {
        Socket sock = serv.accept();  //소켓 대기(따로 신호가 발생하지 않으면 이부분에서 정지됨, 그러나 스레드일 경우 CPU 자원 사용가능)
        ChatThread client = new ChatThread(this, sock);  //서버객체 자신과 접속된 소켓정보를 이용하여 스레드객체를 생성
        v.add(client);//벡터에 추가
        client.start();
      }
    } catch (Exception e) {
      System.out.println(e.toString()+" 2"); //예외가 발생하면 예외를 문자열로 출력
    }
  }

  //진입점
  public static void main(String[] args) {
    ChatServer server = new ChatServer(); //객체 생성문
    server.start();  //스레드 프로그램일 경우 반드시 필요
  }
}
