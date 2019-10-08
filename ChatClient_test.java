import java.net.*;//TCP/IP 응용프로그램 구현에 필요

class ChatClient_test{
//속성
//생성자
 public ChatClient_test(){
   try {
  Socket sock = new Socket("192.168.0.105", 8503);  //서버에 접속신호 보냄
   }catch (Exception e) {
     System.out.println(e.toString()+" 접속불가");
   }
 }
//메소드
  public static void main(String[] args) {
    ChatClient_test obj = new ChatClient_test();//객체 생성
  }
}
