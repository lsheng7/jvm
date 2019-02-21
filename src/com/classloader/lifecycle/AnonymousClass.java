package com.classloader.lifecycle;

/**
 * @Description TODO
 * @Author Harry
 * @Date 2019/1/27 10:26
 **/
public class AnonymousClass
{

  public static void main(String[] args) {


    Object object=new Object(){{

      System.out.println("anonymous class instance block invoked");
    }};

//    anonymous class instance block invoked
//    class com.classloader.lifecycle.AnonymousClass$1
    System.out.println(object.getClass());

  }


}
