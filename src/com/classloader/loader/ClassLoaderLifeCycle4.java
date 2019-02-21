package com.classloader.loader;

/**
 * @Description TODO
 * @Author Harry
 * @Date 2019/1/27 12:11
 **/
public class ClassLoaderLifeCycle4 {


  static {

    System.out.println("ClassLoaderLifeCycle4 static block invoked");
  }

  public static void main(String[] args) {

    Parent4 parent4;
    //ClassLoaderLifeCycle4 static block invoked
    System.out.println("-------------------------");

    parent4=new Parent4();
    //parent4 static block invoked
    System.out.println("-------------------------");
    //3
    System.out.println(parent4.a);
    System.out.println("-------------------------");
    //child4 static block invoked
    //4
    System.out.println(Child4.b);
  }

}

class Parent4{


  static int a=3;

  static {

    System.out.println("parent4 static block invoked");
  }

}
class Child4 extends Parent4{
  static  int b=4;

  static {

    System.out.println("child4 static block invoked");
  }

}
