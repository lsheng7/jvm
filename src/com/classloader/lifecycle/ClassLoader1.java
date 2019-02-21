package com.classloader.lifecycle;


/**
 * 对于静态字段来说 只有直接定义了该字段的类才会被初始化
 * 当一个类在初始化的时候,要求其全部的父类已经初始化完毕
 * -XX:+TraceClassLoading,用于追踪类的加载信息并打印出来
 * -XX:+<option>:表示开启option选项</>
 * -XX:-<option>:表示关闭option选项</>
 * -XX:<option>=<value></>:表示将option选项的值设置成value</>
 */
public class ClassLoader1 {


  public static void main(String[] args) {

//    Parent1 static  block
//    hello world
//    并没有导致子类的初始化
    System.out.println(Child1.str);

//    Parent1 static  block
//    Child1 static  block
//    welcome
//    初始化一个类的子类的时候会导致对父类的初始化
//    System.out.println(Child1.str2);

  }

}

class Parent1 {


  public static String str = "hello world";

  static {
    System.out.println("Parent1 static  block ");
  }

}

class Child1 extends Parent1 {


  public static String str2 = "welcome";

  static {
    System.out.println("Child1 static  block ");
  }

}