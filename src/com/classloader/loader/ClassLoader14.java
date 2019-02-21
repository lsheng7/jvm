package com.classloader.loader;


/**
 * 当前类加载器(Current ClassLoader):
 *
 * 每个类都会使用自己的类加载器(即加载自身的类加载器)来
 * 加载其他类(指的是所依赖的类)如果ClassX引用了ClassY那么ClassX
 * 的类加载器就会去尝试加载ClassY(前提是ClassY并未被加载)
 *
 *
 * 线程上下文类加载器(Thread ContextClassLoader):
 *
 * 线程上下文类加载器是从jdk1.2开始引入的,Thread类中的getContextClassLoader()
 * 与setContextClassLoader(ClassLoader cls)分别用于获取和设置线程上下文类加载器
 *
 * 如果没有通过setContextClassLoader(ClassLoader cls)进行设置的话
 * 线程将继承其父线程的上下文类加载器
 * Java应用运行时的初始线程类加载器是系统类加载器。在线程中运行的代码可以通过该类加载器
 * 来加载类与资源
 *
 * 线程上下文类加载器的重要性(出现的原因和必要性):
 * SPI(Service Provider Interface)
 * JNDI JDBC
 * 父ClassLoader可以使用当前的线程类加载器Thread.currentThread().getContextClassLoader()
 * 所指定的classloader加载的类
 * 这就改变了父ClassLoader不能使用子ClassLoader或是其他没有父子关系的ClassLoader加载类的情况
 * 即改变了双亲委托模型
 *
 * 线程上下文类加载器其实就是当前线程的Current ClassLoader
 * 在双亲委托模型下,类加载由下向上的即下层的类加载器会委托上层的类加载器进行加载
 * 但是对于SPI来说有些接口是jdk核心库提供的,jdk核心库是由启动类加载器来加载的,
 * 而这些接口的实现却来自于不同的jar包(厂商实现)Java的启动类加载器不会加载其他来源的jar包
 * 这样传统的委托模型就无法满足SPI的要求,而通过给当前的线程设置上下文类加载器,就可以由设置的
 * 上下文类加载器来实现对于接口实现类的加载。
 *
 *
 * Lesson27
 *
 */


public class ClassLoader14 {


//  sun.misc.Launcher$AppClassLoader@18b4aac2
//  null
  public static void main(String[] args) {

    System.out.println(Thread.currentThread().getContextClassLoader());
    System.out.println(Thread.class.getClassLoader());

  }
}
