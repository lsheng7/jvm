package com.classloader.lifecycle;

import java.util.Random;

/**
 * Lsession8 有疑问
 *
 * 通过删除.class文件来解释这个问题  不妥
 * 因为.class文件和类的加载是相关的
 *
 * 当一个接口在初始化时 并不要求其父接口
 * 都完成初始化 这和类是不同的
 *
 * 只有真正使用父接口的时候 (如引用父接口定义的常量) 才会被初始化
 *
 **/
public class ClassLoader5 {


  public static void main(String[] args) {
    System.out.println(Child5.b);
    System.out.println(Parent5.a);
  }

}

interface Parent5{

//  public static final

//  int a=5;

  int a=new Random().nextInt(3);
}

interface Child5 extends Parent5{

//  public static final
  int b=6;



}
