package com.classloader.loader;


public class ClassLoaderLifeCycle6 {



//  class com.classloader.loader.CL
//------------------------
//  CL static block invoked
//  class com.classloader.loader.CL

  public static void main(String[] args) throws ClassNotFoundException {

    ClassLoader loader=ClassLoader.getSystemClassLoader();

    //仅仅加载类 并不会导致类的初始化
    Class<?> clazz=loader.loadClass("com.classloader.loader.CL");

    System.out.println(clazz);
    System.out.println("------------------------");

    clazz=Class.forName("com.classloader.loader.CL");
    System.out.println(clazz);
  }
}

class CL{

  static {

    System.out.println("CL static block invoked");
  }
}
