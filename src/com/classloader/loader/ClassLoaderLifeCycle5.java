package com.classloader.loader;

/**
 * 对于静态父类静态变量的引用只会导致父类的初始化并不会
 * 导致子类的初始化
 *
 * 主要看静态变量定义在什么地方
 */
public class ClassLoaderLifeCycle5 {


  public static void main(String[] args) {

    //Parent5 static block invoked
    //3
    //不会导致子类的主动使用
    System.out.println(Child5.a);
    //do Something
    Child5.doSomething();
  }

}

class Parent5{

  static int a=3;


  static {

    System.out.println("Parent5 static block invoked");
  }

  static void doSomething(){

    System.out.println("do Something");
  }

}

class Child5 extends Parent5{

  static {

    System.out.println("Child5 static block invoked");
  }
}

