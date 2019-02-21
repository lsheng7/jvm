package com.classloader.lifecycle;

/**
 * 初始化验证的要点:
 * 1. JVM声明周期指出:
 * 加载是在初始化之前的一步操作,因此可以设置虚拟机参数[-XX:+TranceClassLoading]观察类的加载信息,
 * 判断是否完成初始化动作。
 * 2. 可以通过static成员引用变量的实例代码块完成验证
 * 规范指出主动使用的7种范式其一就是调用类的静态属性会导致初始化
 * 可以通过静态引用变量赋值(在赋值的时候增加实例代码块完成验证操作)
 * 3. 在验证的时候尤其要将静态常量量做一定的区分:
 *   3.1 动态常量
 *      所谓的动态常量在编译期间是不确定的,在程序的运行期确定
 *   3.2 编译常量
 *      所谓的编译常量在编译期间是确定的
 * 注:  对于String 引用类型必须了解
 * String a="hello";
 * String a=new String("hello");
 * 之前的区别
 *
 *
 **/
public class ClassLoader8 {


  public static void main(String[] args) {

    // hello
    //被没有导致Parent8的初始化 因为显示初始化代码没有被执行

//    System.out.println(Child8.str);
//    ChildInterface8 :anonymous object instance block instance
//    com.classloader.lifecycle.ChildInterface8$1@1540e19d
    System.out.println(ChildInterface8.object);
  }

}

interface  Parent8{

  //public static final
  Object object=new Object(){
    {
      System.out.println("Parent8 :anonymous object instance block instance ");
    }
  };

}
class Child8 implements Parent8{

  public static String str="hello";

}

interface  ChildInterface8 extends Parent8{

   Object object=new Object(){

     { System.out.println("ChildInterface8 :anonymous object instance block instance ");}
    };

}



