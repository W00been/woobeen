import java.net.*;//TCP/IP 응용프로그램 구현에 필요


class Ex1001_2{
  //속성(멤버변수)

  //생성자
  // 반드시 클래스명과 동일해야 함
  // 반환값이 없음
  // 공개가 원칙(public)
  public Ex1001_2(){
    //System.out.println("나 생성자");
    ServerSocket serv; //서버소켓(대기용)
    try{
      //예외가 발생할 가능성이 있는 코드를 작성
      serv = new ServerSocket(7777); //서버소켓 생성
      System.out.println("서버가 시작되었습니다.");
      while(true){
        Socket sock = serv.accept();//이 부분에서 무한 대기하다가 신호가 올 경우 다음 라인으로 내려감
        String ipaddr = sock.getInetAddress().toString(); //접속소켓의 IP정보를 획득
        System.out.println("누군가 접속함: " + ipaddr);
      }
    }catch(Exception e){
      //만약 예외가 발생하면 처리할 내용을 작성
      System.out.println(e.toString());
    }
  }

  //메소드(멤버함수)

  public static void main(String[] args) {
    //진입점
    //객체 생성
    //클래스명 객체명 = new 생성자;
    Ex1001_2 obj1 = new Ex1001_2();

  }
}
