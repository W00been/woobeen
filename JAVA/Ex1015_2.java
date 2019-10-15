import java.awt.*;
import javax.swing.*;
import java.util.*; //난수발생

public class Ex1015_2 extends JPanel{
//속성

//생성자
public Ex1015_2(){
  Thread t = new Thread(this) //스레드 객체 생성
  t.start();// 스레드 시작을 JVM에 요청
}

//메소드
//자바 그래픽 동작 과정
/*
1. paint 메소드만 오버라이딩 할 경우 배경을 자동으로 지우고 paint 메소드 처리
2. 1번의 이유는 부모클래스의 update 메소드가 배경지우기와 paint 메소드 호출을 가지고 있음
3. paint 와 update를 모두 오버라이딩 할 경우 모든 코드는 프로그래머가 작성
4. update에 그래픽 코드를 작성하고 paint를 호출하는 방식으로 권장
5. paint는 update에서만 호출 가능
6. update 또는 paint를 호출하기 위해서는 repaint 메소드를 사용
*/

public void paint(Graphics g){
int x = Random.
}

// public void update(Graphics g){
//
// }

//run() 메소드
public void run(){
  try{
    while(true){
      Thread.sleep(30);//30ms CPU 이용 해제
      this.repaint();//그리기 작업 갱신(내부적으로 update 호출)
    }catch(Exception e){
      System.out.println(e.toString());
    }
  }
}
}
