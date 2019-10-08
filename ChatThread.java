import java.net.*;
import java.io.*; //송수신 스트림 관련 라이브러리

class ChatThread extends Thread {
  //속성(전역변수와 유사)
  ChatServer serv;//Owner
  Socket sock;
  DataInputStream din;  //데이터 수신을 위한 객체
  DataOutputStream dout;  //데이터 송신을 위한 객체
  boolean chk; //상대방 소켓과 접속 연결 여부(ture : 연결 / false : 미연결)



  //생성자
  public ChatThread(ChatServer serv, Socket sock) { //ChatServer 가 생성하며 Owner의 정보가 전달되도록 함
    try {
      this.serv = serv; // 왼쪽 this-> 속성 = 오른쪽 -> 매개변수
      this.sock = sock;
      chk = true;//일단 정산으로 판정
    } catch (Exception e) {
      chk = false;
      System.out.println(e.toString()+" 3");
    }
  }

  //메서드
  public void sendMsg(String msg){//msg: 지역변수
   try {
     dout.writeUTF(msg);//문자열 송신
   }catch (Exception e) {
     chk = false;
     System.out.println(e.toString()+" 4");
   }
  }
  //run() 메서드
  public void run() {
    try {
      din = new DataInputStream(sock.getInputStream()); //수신 스트림객체 생성
      dout = new DataOutputStream(sock.getOutputStream());  //송신 스트림객체 생성
      System.out.println(sock.getInetAddress().toString()); //소켓에 접속한 ip를 문자열로 출력
      while (true) {
        String msg = din.readUTF(); //수신스트림으로부터 문자열(한글 포함) 수신(무한 대기) - ChatServer의 accept 부분과 유사
        String msg2 = "[" +sock.getInetAddress().toString()+"]" + msg;
      //  SendMsg(msg);//echo 처리
       serv.sendAll(msg2);//서버측에 일괄전송을 부탁
        System.out.println(msg);
      }
    } catch (Exception e) {
      chk = false; // 오류판정
      System.out.println(e.toString() +" 5");
    }
  }

  //진입점 불필요
}
