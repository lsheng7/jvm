package com.classloader.loader;


/*
 * 线程上下文类加载器的一般使用模式(获取-使用-还原)
 *
 *
 * ClassLoader loader=Thread.currentThread().getContextClassLoader()
 * try{
 *
 *   Thread.currentThread().setContextClassLoader(targetCls);
 *   myMethod();
 *
 * }finally{
 *
 *   Thread.currentThread().setContextClassLoader(loader);
 *
 * }
 *
 * myMethod中调用了Thread.currentThread().getContextClassLoader()
 * 获取当前线程的上下文类加载器做某些事情
 *
 * 如果一个类由类加载器A加载,那么这个类的依赖类也是由相同的类加载器A加载的
 * (如果这个依赖类之前没有被加载过的话)
 *
 * ContextClassLoader的作用就是破坏java的类加载器的双亲委托模型
 *
 * 在SPI的接口中就可以通过线程上下文类加载器来获取到特定于厂商实现的类
 * 当高层提供了统一的接口让低层实现,同时又要在高层加载(或者实例化)
 * 就必须通过线程上下文类加载器来帮助高层的ClassLoader找到并加载该类
 *
 */
public class ClassLoader16 {



  public static void main(String[] args) {



  }

}
