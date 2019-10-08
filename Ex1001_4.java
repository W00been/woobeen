class Ex1001_4 extends Thread{
//속성
  String name;
 //  생성자
  public Ex1001_4(String name){
    this.name = name;
  }
  public void run(){//오버라이딩(부모클래스에 존재하는 동일한 이름의 메소드를 재정의)
    //Thread 클래스를 상속받을 경우 반드시 구현해야 함
    //예외처리와 무한루프로 구성
    //이 메소드를 빠져나오는 순간, Thread는 종료됨
    //대분의 동작코드는 이 부분에 작성함
    try{
        for(int i = 0; i<10; i++){
          System.out.println(this.name +":"+i);
          Thread.sleep(500);
        }
    }catch(Exception e){
      System.out.println(e.toString());
    }
  }
 public static void main(String[] args) {
    Ex1001_4 obj1 = new Ex1001_4("호랑이");
    Ex1001_4 obj2 = new Ex1001_4("사자");
    Ex1001_4 obj3 = new Ex1001_4("토끼");
    Ex1001_4 obj4 = new Ex1001_4("곰");
    obj1.start();//내부적으로 run() 메소드를 호출
    obj2.start();//내부적으로 run() 메소드를 호출
    obj3.start();//내부적으로 run() 메소드를 호출
    obj4.start();//내부적으로 run() 메소드를 호출(Thread는 run 메소드를 호출할 수 없음!)
}
}

// Tcp/IP 통신 구현 >>>> 단일통신
// Thread 생성 >>> 다중통신
// GUI 구성
