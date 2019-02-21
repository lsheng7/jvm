package com.classloader.lifecycle;

/**
 * 实例代码块是和构造函数相关的
 * 构造函数的多次调用会导致实例代码块的多次调用
 *
 * 静态代码块仅会被执行一次
 *
 **/
public class InstanceBlockAndStaticBlock {


  {
    System.out.println("instance block invoked");
  }


  static{
    System.out.println("static block invoked");
  }

  public static void main(String[] args) {

    new InstanceBlockAndStaticBlock();
    new InstanceBlockAndStaticBlock();
  }
}
