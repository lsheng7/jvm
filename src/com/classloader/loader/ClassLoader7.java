package com.classloader.loader;

/**
 *
 *
 * Lession21
 **/
public class ClassLoader7 {



  public static void main(String[] args) {

    //获取类加载器的加载类的绝对路径
    System.out.println(System.getProperty("sun.boot.class.path"));
    System.out.println("------------------------");
    System.out.println(System.getProperty("java.ext.dirs"));
    System.out.println("------------------------");
    System.out.println(System.getProperty("java.class.path"));

  }
}
