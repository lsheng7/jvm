package com.classloader.lifecycle;

/**
 * @Description TODO
 * @Author Harry
 * @Date 2019/1/26 18:51
 **/
public class ClassLoader6 {


  public static void main(String[] args) {

    Singleton singleton = Singleton.getInstance();
    //1
    System.out.println("counter1:" + singleton.counter1);
    //0
    System.out.println("counter2:" + singleton.counter2);

  }
}


class Singleton {

  public static int counter1;
// case1 public static int counter2 = 0;

// case2 public static  int counter2;

  private static Singleton singleton = new Singleton();

  static {
//  case2  counter2=0;
    //再调用静态代码块
    System.out.println("singleton static block invoked");
  }

  private Singleton() {

    //先调用构造函数
    System.out.println("singleton constuctor invoked");
    counter1++;
    counter2++;//准备阶段的重要意义
    System.out.println("counter1:" + counter1);
    System.out.println("counter2:" + counter2);
  }

  public static int counter2 = 0;

  public static Singleton getInstance() {
    return singleton;
  }


}