package com.classloader.lifecycle;

import java.util.UUID;

/**
 *当一个常量值并非编译期间可以确定的,那么其值不会被放到
 * 调用类的常量池中,这时在程序运行时,会导致主动使用这
 * 个常量所在的类,从而导致常量所在类的初始化
 *
 *
 **/
public class ClassLoader3 {

  public static void main(String[] args) {

    //    Parent3 static  invoked
    //    09847f2c-659c-4036-a923-17e1b3b44433
    System.out.println(Parent3.str);


  }

}


class Parent3 {

  public static final String str = UUID.randomUUID().toString();


  static {
    System.out.println("Parent3 static  invoked");
  }

}