import java.awt.*; //GUI 구성을 위해 필요한 패키지
import java.awt.event.*; //이벤트 처리를 위한 패키지
class Ex1001_6 extends Frame{
  //속성
  TextField tf; //한 줄 입력상자
  TextArea ta; //여러 줄 입력상자
  Button btn1; //버튼

  //생성자
  public Ex1001_6(){
    this.setLayout(null); //개발자가 수동으로 객체 배치(선두에 코딩)
    this.setSize(800,600); //윈도우 크기 지정
    this.setVisible(true); //화면에 보이기
//    this.setBackgroud(Color.yellow);
//    Color c = new Color(78,63,105);
    Color c = new Color(0xff,0x78,0xae);
    this.setBackground(c);

    //-------객체 생성 및 배치---------------
    tf = new TextField();
    tf.setBounds(10,50, 400, 30); //x,y, width, height
    this.add(tf); //프레임에 부착
    //-----------------------------------------
    ta = new TextArea();
    ta.setBounds(10,80, 400, 400); //x,y, width, height
    Color cl = new Color(0x78,0xca,0xcF);
    ta.setBackground(cl);
    this.add(ta); //프레임에 부착
    //-----------------------------------------
    btn1 = new Button("보내기");
    btn1.setBounds(10,500, 400, 50);
    this.add(btn1);

    //이벤트 연결
    tf.addActionListener(new TfHandler());
  }
  //메소드
  //이벤트 처리용 내부 클래스 생성
  class TfHandler implements ActionListener{ //텍스트 상자 엔터 이벤트
    //반드시 이 메소드를 구현해야 함!!
    public void actionPerformed(ActionEvent ev){
      //버튼 클릭 또는 엔터 이벤트에 반응
      String msg = tf.getText();// 텍스트상자에 입력된 문자열 반환
      ta.append(msg + "\n"); //입력 후 줄바꿈
      tf.setText(""); //공백문자열로 지우기효과



    }
  }
  //진입점
  public static void main(String[] args) {
    Ex1001_6 obj = new Ex1001_6();
    }
  }
