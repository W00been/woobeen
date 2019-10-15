import java.net.*;//TCP/IP 응용프로그램 구현에 필요

class Ex1001_3{
  //생성자
  public Ex1001_3(){
  try{
    Socket sock = new Socket("192.168.0.105", 7777); //서버에 접속신호 보냄
  } catch(Exception e){
    System.out.println(e.toString());
    }
  }

  public static void main(String[] args) {
    Ex1001_3 obj = new Ex1001_3(); //객체 생성

  }
}
