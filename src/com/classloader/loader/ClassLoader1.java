package com.classloader.loader;

public class ClassLoader1 {

  public static void main(String[] args) throws ClassNotFoundException {

    Class<?> strClazz=Class.forName("java.lang.String");

    //返回加载这个类的类加载器
    //null
    System.out.println(strClazz.getClassLoader());


    //sun.misc.Launcher$AppClassLoader@18b4aac2
    Class<?> cClazz=Class.forName("com.classloader.loader.C");
//    cClazz=C.class;
//    cClazz=new C().getClass();
    System.out.println(cClazz.getClassLoader());

  }
}

class C{


}
