package com.classloader.loader;


public class ClassLoader15 implements Runnable {

  private Thread thread;


  public ClassLoader15() {
    this.thread = new Thread(this);
    thread.start();
  }

  @Override
  public void run() {

    //获取当前线程的上下文类加载器
    ClassLoader classLoader = this.thread.getContextClassLoader();

    this.thread.setContextClassLoader(classLoader);

//    class=class sun.misc.Launcher$AppClassLoader
//    parent class=class sun.misc.Launcher$ExtClassLoader
    System.out.println("class=" + classLoader.getClass());
    System.out.println("parent class=" + classLoader.getParent().getClass());

  }

  public static void main(String[] args) {
    new ClassLoader15();
  }
}
