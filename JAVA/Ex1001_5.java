class Ex1001_5{
  //속성
  String name;
  //생성자
  public Ex1001_5(String name){
    this.name = name; //속성 = 지역변수(인수)
  }
  //메소드
  public void run(){
    for (int i=0; i<10; i++ ) {
      System.out.println(this.name + ":" + i);
    }
  }
  //진입점
  public static void main(String[] args) {
    Ex1001_5 obj1 = new Ex1001_5("호랑이");
    Ex1001_5 obj2 = new Ex1001_5("사자");
    Ex1001_5 obj3 = new Ex1001_5("토끼");
    Ex1001_5 obj4 = new Ex1001_5("곰");
    obj1.run();
    obj2.run();
    obj3.run();
    obj4.run();

  }
}

//Tread 없는 경우
