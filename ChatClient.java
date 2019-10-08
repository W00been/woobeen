import java.net.*; // 소켓 관련
import java.io.*; // 스트림 관련
import java.awt.*; // Gui 컴포넌트 관련
import java.awt.event.*; //이벤트 처리 관련

// Frame을 반드시 상속 받아야 하며, 스레드 관련 라이브러리는
// 인터페이스 방식으로 구현해야 함
// Thread 클래스와 동일한 기능을 가진 인터페이스는 Runnable
// Runnable 인터페이스 사용 시에도 run() 메소드 구현

public class ChatClient extends Frame implements Runnable{
//속성
TextField tf;
TextArea ta;
Socket sock;
DataInputStream din;//수신용 스트림 생성
DataOutputStream dout; //송신용 스트림 생성

//생성자
public ChatClient(){
  this.setLayout(null); //컴포넌트 배치를 프로그래머가 직접 지정
  this.setSize(500,600); //윈도우 크기 지정
  this.setVisible(true); //화면에 보이기
  //-----------------------객체 생성 및 배치------------------------------
  tf = new TextField();//텍스트 상자 생성
  tf.setBounds(10,30, 430, 30);//x,y, width, height
  tf.setBackground(Color.yellow);
  this.add(tf);//프레임에 부착
  ta = new TextArea();//x,y, width, height
  ta.setBounds(10,60, 450, 500);
  ta.setBackground(Color.green);
  this.add(ta);//프레임에 부착

  Thread t = new Thread(this); //스레드 클래스를 이용해서 정식으로 생성
  t.start();

  tf.addActionListener(new TfHandler());//이벤트 핸들러 연결

  // try{
  //
  // }catch (Exception e) {
  //   System.out.println(e.toString());
  // } run()에서 생성하였으므로, 필요없음
}
//메소드
public void SendMsg(String msg){//msg: 지역변수
 try {
   dout.writeUTF(msg);//문자열 송신
 }catch (Exception e) {
   System.out.println(e.toString()+" 6");
 }
}
//run
public void run(){
  try{
 while(true){
   sock = new Socket("192.168.0.105",8888);
   din = new DataInputStream(sock.getInputStream());
   dout = new DataOutputStream(sock.getOutputStream());
   while(true){
     String msg = din.readUTF();//문자열 수신
     ta.append(msg + "\n");
   }
 }
  }catch (Exception e) {
    System.out.println(e.toString()+ " 7");
  }
}

//이벤트 핸들러
class TfHandler implements ActionListener{
  public void actionPerformed(ActionEvent ev){
    //컴포넌트(텍스트 상자, 버튼)에서 엔터 또는 클릭 이벤트가 발생할 경우 위 메소드 호출
    String msg = tf.getText();//텍스트 상자의 문자열 반환
    SendMsg(msg);//문자열 전송 메소드 호출
    tf.setText("");//공백문자열로 지우기효과

  }
}

//진입점
public static void main(String[] args) {
    ChatClient client = new ChatClient();//아직 완전한 스레드가 아님


}
}
