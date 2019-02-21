package com.classloader.lifecycle;

/**
 * 常量在编译阶段会存入到调用这个常量方法所在的类的常量池中
 * 本质上调用类并没有直接引用到调用常量的类,因此并不会触发
 * 定义常量的类的初始化
 * 注意:这里指的是将常量存放到了ClassLoader2的常量池中,
 * 之后ClassLoader2和Parent2就没有任何关系了
 * 甚至我们可以将Parent2的.class文件删除(未被加载是可以删除
 * 如果被加载是不行的)
 *
 * 助记符:
 * ldc表示将int、float或者String类型的常量从常量池中推送至栈顶
 * bipush 表示将单字节(-128-127)的常量值推送至栈顶
 * sipush 表示将短整型常量值(-32768-32767)的常量值推送至栈顶
 * iconst_1 表示将int型1推送至栈顶
 * iconst_2 表示将int型2推送至栈顶
 * iconst_3 表示将int型3推送至栈顶
 * iconst_4 表示将int型4推送至栈顶
 * iconst_5 表示将int型5推送至栈顶
 * [iconst_1-iconst_5]
 *
 */
public class ClassLoader2 {

  public static void main(String[] args) {

//    Parent2 static block
//    hello world
//    System.out.println(Parent2.str);//public static  String str = "hello world";

//    hello world
    System.out.println(Parent2.a);//public static final String str = "hello world";
  }
}

class Parent2 {

//  public static  String str = "hello world";

//    public static final String str = "hello world";
  public static final int a = 7;

  static {
    System.out.println("Parent2 static block");
  }
}

