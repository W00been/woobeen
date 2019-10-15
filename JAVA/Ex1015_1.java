import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.* ;
import javax.swing.*;

public class Ex1015_1 extends JFrame{

//속성
Container cp;//윈도우의 클라이언트 영역
JButton btn1; //on
JButton btn2;//off


//생성자
public Ex1015_1(){
  super("스윙테스트"); //타이틀 바의 문자열
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//창닫기 가능하도록
  cp = this.getContentPane(); //컨테이너 획득
  cp.setBackground(Color.yellow);
  cp.setLayout(null);//프로그래머가 객체의 위치를 직접 설정

  btn1 = new JButton("켜기");
  btn1.setBounds(0,0,400,100);
  btn1.setBackground(Color.green);
  cp.add(btn1);
  btn1.addActionListener(new Btn1Handler()); //이벤트 선언

  btn2 = new JButton("끄기");
  btn2.setBounds(400,0,400,100);
  btn2.setBackground(Color.green);
  cp.add(btn2);

  this.setSize(800,600); //크기지정
  this.setVisible(true); //보이기
}

//메소드

//이벤트핸들러
class Btn1Handler implements ActionListener{
  //엔터 또는 클릭 이벤트
  public void actionPerformed(ActionEvent ev){
    //이벤트가 발생하면 이 부분을 호출
    JOptionPane.showMessageDialog(null,"메시지창","테스트", JOptionPane.INFORMATION_MESSAGE);
    //owner, 출력내용, 타이틀바, 아이콘모양
  }
}

//진입점
public static void main(String[] args) {
Ex1015_1 obj = new Ex1015_1();
}


}
