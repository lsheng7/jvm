package com.classloader.loader;

public class ClassLoader2 {


  public static void main(String[] args) {

    ClassLoader classLoader = ClassLoader.getSystemClassLoader();

//    sun.misc.Launcher$AppClassLoader@18b4aac2
//    sun.misc.Launcher$ExtClassLoader@1540e19d
    while (null != classLoader) {
      System.out.println(classLoader);
      classLoader = classLoader.getParent();
    }
    //null
    System.out.println(classLoader);
  }
}
