package com.classloader.loader;


import java.util.Random;

public class ClassLoaderLifeCycle2 {

  public static void main(String[] args) {
    //  常量池
    System.out.println(FinalTest.a);
  }

}

class FinalTest{
//  iconst_3
//  public static final int a=3;//未被初始化[编译期间确定 编译常量]
//  public static int a=3;//初始化

//  3: getstatic     #3   // Field com/classloader/loader/FinalTest.a:I
  public static final int a =new Random().nextInt(3);//初始化[运行期确定 动态常量]
  static {
    System.out.println("FinalTest static block invoked");
  }

}


