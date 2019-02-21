package com.classloader.lifecycle;

/**
 * 对于数组实例来说,其类型是由JVM在运行期间动态生成的,
 * 表示为[Lcom.classloader.Parent4这种形式
 * 其父类型是Object
 * 对于数组来说,JavaDoc经常将构成数组的元素称为Component
 * 实际场就是将数组降低一个维度后的类型
 *
 * 助记符:
 * anewarray:创建一个引用类型(类、接口、数组)的数组,并将其引用值压入栈顶
 * newarray:创建一个原生类型的数组,并将其引用压入栈顶
 *
 **/
public class ClassLoader4 {


  public static void main(String[] args) {
//    Parent4 static invoked
//    =====================
//    Parent4 parent4=new Parent4();
//
//    System.out.println("=====================");
//
//    Parent4 parent42=new Parent4();

    //不会导致类的主动使用
    Parent4[] parent4s = new Parent4[1];
//    class [Lcom.classloader.Parent4;
//    jvm在运行期间生成的 没有初始化但是已经被加载了
    System.out.println(parent4s.getClass());
    System.out.println(parent4s.getClass().getSuperclass());

    Parent4[][] parent4s2 = new Parent4[6][];
//    class [[Lcom.classloader.Parent4;
//    二维数组是以一维数组的作为compent的
    System.out.println(parent4s2.getClass());
    System.out.println(parent4s2.getClass().getSuperclass());

    System.out.println("========================");


//    class [I
//    class java.lang.Object
    int[] ints=new int[1];
    System.out.println(ints.getClass());
    System.out.println(ints.getClass().getSuperclass());




  }

}

class Parent4 {

  static {

    System.out.println("Parent4 static invoked");
  }
}
