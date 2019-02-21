package com.classloader.loader;


import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

//     * Returns the context ClassLoader for this Thread. The context
//     * ClassLoader is provided by the creator of the thread for use
//     * by code running in this thread when loading classes and resources.
//     * If not {@linkplain #setContextClassLoader set}, the default is the
//     * ClassLoader context of the parent Thread. The context ClassLoader of the
//     * primordial thread is typically set to the class loader used to load the
//     * application.
//返回针对这个线程的上下文ClassLoader
//这个上下文ClassLoader是由线程的创建者提供的
//当加载类及资源的时候 通过在这个线程运行代码
//如果没有被设置的话默认的是 父线程对应的ClassLoader的上下文
//通常这个类加载器被设置成加载这个应用的类加载器
public class ClassLoader3 {

  public static void main(String[] args) throws IOException {

    //获取当前线程上下文类加载器
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//    sun.misc.Launcher$AppClassLoader@18b4aac2
//    System.out.println(classLoader);
//    file:/C:/alipay/jvm/out/production/HelloWorld/com/classloader/loader/ClassLoaderLifeCycle2.class

    String resources = "com/classloader/loader/ClassLoaderLifeCycle2.class";
    Enumeration<URL> urls = classLoader.getResources(resources);

    while (urls.hasMoreElements()) {
      System.out.println(urls.nextElement());
    }

    System.out.println("------------------------");
    Class<?> clazz = ClassLoader3.class;
    //sun.misc.Launcher$AppClassLoader@18b4aac2
    System.out.println(clazz.getClassLoader());

    //null
    Class<?> strClazz = String.class;
    System.out.println(strClazz.getClassLoader());
  }
}
