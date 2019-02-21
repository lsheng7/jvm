package com.classloader.lifecycle.questions;

/**
 * @Description TODO
 * @Author Harry
 * @Date 2019/1/27 10:08
 **/
public class Loader1 {

  public static void main(String[] args) {

    //执行结果:
//    LoaderParent1 block invoked
//    LoaderChild1 block invoked
//    java.lang.Object@1540e19d
//    System.out.println(LoaderChild1.object);

    //1
    System.out.println(LoaderChild1.a);
  }

}

class LoaderParent1{

  static{

    System.out.println("LoaderParent1 block invoked");
  }

}


class LoaderChild1 extends LoaderParent1{

  //说明这个引用值在编译期间不会确定下来
  //  public static final Object object=new Object();
  //说明这个原生类型的值在编译期间会被确定下来
  //放到调用类的常量池中
  public static final int a=1;

  static {

    System.out.println("LoaderChild1 block invoked");
  }

}
