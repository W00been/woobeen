import java.net.*;//TCP/IP 응용프로그램 구현에 필요

class ChatServer_test extends Thread{

//속성

//생성자
public ChatServer_test(){
  ServerSocket serv;//서버 소켓
  try {
    serv = new ServerSocket(8503);// 서버 소켓 포트: 8503
    System.out.println("채팅 서버가 시작되었습니다.");
    while(true){
      Socket sock = serv.accept();//이 부분에서 무한 대기하다가 신호가 올 경우,
                                  //다음 라인으로 내려감
      String ipaddr = sock.getInetAddress().toString();
      System.out.println(ipaddr + "에서 접속하였습니다.");
    }
  }catch (Exception e) {//예외발생 시,
    System.out.println(e.toString()+" 소켓 생성");
  }
}

//메소드

//진입점
  public static void main(String[] args) {
    ChatServer_test obj = new ChatServer_test(); //클래스명 객체명 = new 생성자;
  }
}
