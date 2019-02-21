package com.classloader.loader;

/**
 * Lession20
 * 关于命名空间的重要说明:
 * 1. 子加载器所加载的类可以访问父加载器所加载的类
 * 2. 父加载器所加载的类不能访问子加载器所加载的类
 * 通过单独删除MySample和MyCat进行上述的验证
 */



public class ClassLoader6_1 {

  public static void main(String[] args) throws Exception {

    ClassLoader5 loader1 = new ClassLoader5("loader1");
    loader1.setPath("D:\\jvmclasses\\");
    //loadClass会调用findClass
    Class<?> clazz = loader1.loadClass("com.classloader.loader.MySample");
    System.out.println("class:" + clazz.hashCode());
    Object object = clazz.newInstance();
    System.out.println(object);


  }
}
