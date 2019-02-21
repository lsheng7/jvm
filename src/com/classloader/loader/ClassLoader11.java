package com.classloader.loader;

import java.lang.reflect.Method;

/**
 * @Description TODO
 * @Author Harry
 * @Date 2019/2/1 21:06
 **/
public class ClassLoader11 {


  public static void main(String[] args) throws Exception{


//    findClass invokedcom.classloader.loader.MyPerson
//        classLoaderName=loader1
//    findClass invokedcom.classloader.loader.MyPerson
//        classLoaderName=loader2
//    false
//    Exception in thread "main" java.lang.reflect.InvocationTargetException
//    at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
//    at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
//    at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
//    at java.lang.reflect.Method.invoke(Method.java:498)
//    at com.classloader.loader.ClassLoader11.main(ClassLoader11.java:45)
//    Caused by: java.lang.ClassCastException: com.classloader.loader.MyPerson cannot be cast to com.classloader.loader.MyPerson
//    at com.classloader.loader.MyPerson.setPerson(MyPerson.java:16)
//	... 5 more
    ClassLoader5 loader1 = new ClassLoader5("loader1");
    ClassLoader5 loader2 = new ClassLoader5("loader2");

    loader1.setPath("D:\\jvmclasses\\");
    loader2.setPath("D:\\jvmclasses\\");

    //删除MyPerson.class 并拷贝到jvmclasses目录下面
    //根本的区别是命名空间的不同
    //loader1的命名空间 loader1 初始类加载器和定义类加载器
    Class<?> clazz1 = loader1.loadClass("com.classloader.loader.MyPerson");
    //loader2的命名空间 loader2 初始类加载器和定义类加载器
    Class<?> clazz2 = loader2.loadClass("com.classloader.loader.MyPerson");

    System.out.println(clazz1 == clazz2);//false
    Object object1 = clazz1.newInstance();
    Object object2 = clazz2.newInstance();

    Method method = clazz1.getMethod("setPerson", Object.class);
    method.invoke(object1, object2);//调用失败

  }

}
