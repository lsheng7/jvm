package com.classloader.lifecycle.questions;



public class Loader2 {


  public static void main(String[] args) {

    //1 通过-XX:TranceClassLoading 可以看出
    //类的加载log中不存在Loader2Child和LoaderParent2的日志信息
    //所以这个也是被视为确定常量来存储到常量池中

//    只有程序首次主动使用特定接口的静态变量时，才会导致接口的初始化
    //这句话是不是存在问题呢？
    //接口中的静态变量分为两种看待(编译期间确定、编译期间不确定)
    //对于编译期间确定的常量应该被常量池接受,常量不确定的情况下
//    比如 接口常量是 Object object=new Object();
    //这种在编译期间不能确定 会导致初始化
    //类加载信息也会暴露出来
//    [Loaded com.classloader.lifecycle.questions.Loader2Parent from file:/C:/alipay/jvm/out/production/HelloWorld/]
//[Loaded com.classloader.lifecycle.questions.Loader2Child from file:/C:/alipay/jvm/out/production/HelloWorld/]
//    java.lang.Object@4c3e4790

    System.out.println(Loader2Child.object);
  }
}


interface  Loader2Parent{


  int b=2;

}

interface  Loader2Child extends Loader2Parent{

   //int a=1;
  Object object=new Object();


}