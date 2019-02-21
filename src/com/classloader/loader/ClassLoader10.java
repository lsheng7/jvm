package com.classloader.loader;

import java.lang.reflect.Method;

/**
 *
 * Lesson22
 **/
public class ClassLoader10 {

  public static void main(String[] args) throws Exception {

    //初始类加载器
    ClassLoader5 loader1 = new ClassLoader5("loader1");
    ClassLoader5 loader2 = new ClassLoader5("loader2");

    Class<?> clazz1 = loader1.loadClass("com.classloader.loader.MyPerson");
    Class<?> clazz2 = loader2.loadClass("com.classloader.loader.MyPerson");

    //都是委托给应用类加载器加载 只会加载一次 loader2是获取上一次的加载
    //定义类加载器[ApplicationClassLoader]
    System.out.println(clazz1 == clazz2);//true
    Object object1 = clazz1.newInstance();
    Object object2 = clazz2.newInstance();

    Method method = clazz1.getMethod("setPerson", Object.class);
    method.invoke(object1, object2);//会调用成功
    method.invoke(object2, object1);//会调用成功




  }
}
