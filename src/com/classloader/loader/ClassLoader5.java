package com.classloader.loader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


//自定义类加载器
public class ClassLoader5 extends ClassLoader {


  //自定义类加载器的名字
  private String classLoaderName;
  //加载类的路径[桌面和路径]
  private String path;
  //二进制文件的拓展名
  private static final String fileExtension = ".class";

  public ClassLoader5(String classLoaderName) {
    super();//使用系统类加载作为委托双亲
    this.classLoaderName = classLoaderName;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public ClassLoader5(ClassLoader parent) {
    super(parent);
  }


  public ClassLoader5(ClassLoader parent, String classLoaderName) {
    super(parent);//使用自定义的类加载器作为委托双亲
    this.classLoaderName = classLoaderName;
  }


  @Override
  public String toString() {
    return "[" + this.classLoaderName + "]";
  }


  /**
   * 类的全路径com.classloader.loader..*
   */
  private byte[] loadClassData(String name) {
    byte[] data = null;
    InputStream inputStream = null;
    ByteArrayOutputStream baos = null;
    name = name.replace(".", "\\");
    try {
      inputStream = new FileInputStream(new File(this.path + name + fileExtension));
      int ch;
      baos = new ByteArrayOutputStream();
      while (-1 != (ch = inputStream.read())) {
        baos.write(ch);
      }
      data = baos.toByteArray();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {

      try {
        inputStream.close();
        baos.close();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
    return data;
  }

  @Override
  protected Class<?> findClass(String className) {

    System.out.println("findClass invoked" + className);
    System.out.println("classLoaderName=" + classLoaderName);
    byte[] classBytes = this.loadClassData(className);
    return defineClass(className, classBytes, 0, classBytes.length);
  }

//  public static void test(ClassLoader loader) throws Exception {
//    //loadClass中会调用findClass方法
//    Class<?> clazz = loader.loadClass("com.classloader.loader.ClassLoader4");
//    Object object = clazz.newInstance();
//    System.out.println(clazz.getClassLoader());
//    System.out.println(object);
//  }

  public static void main(String[] args) throws Exception {

    //父加载器是系统类加载器器
    ClassLoader5 loader1 = new ClassLoader5("loader1");
    loader1.setPath("D:\\jvmclasses\\");
    Class<?> clazz = loader1.loadClass("com.classloader.loader.ClassLoader4");
    System.out.println("clazz=" + clazz.hashCode());
    System.out.println(clazz.getClassLoader());
    Object object = clazz.newInstance();
    System.out.println(object);

    System.out.println("-------------------------------");

    loader1 = null;
    clazz = null;
    object = null;
    System.gc();//垃圾回收 查看类的卸载

    Thread.sleep(20000);

    //观察类的卸载
    loader1 = new ClassLoader5("loader1");
    loader1.setPath("D:\\jvmclasses\\");
    clazz = loader1.loadClass("com.classloader.loader.ClassLoader4");
    System.out.println("clazz=" + clazz.hashCode());
    System.out.println(clazz.getClassLoader());
    object = clazz.newInstance();
    System.out.println(object);

//    System.out.println("-----------------------------");
//    ClassLoader5 loader2 = new ClassLoader5("loader2");
//    loader2.setPath("D:\\jvmclasses\\");
//    Class<?> clazz2 = loader2.loadClass("com.classloader.loader.ClassLoader4");
//    System.out.println("clazz2=" + clazz2.hashCode());
//    System.out.println(clazz2.getClassLoader());
//    Object object2 = clazz2.newInstance();
//    System.out.println(object2);

//    ClassLoader5 loader2 = new ClassLoader5(loader1, "loader2");
//    loader2.setPath("D:\\jvmclasses\\");
//    Class<?> clazz2 = loader2.loadClass("com.classloader.loader.ClassLoader4");
//    System.out.println("clazz2=" + clazz2.hashCode());
//    System.out.println(clazz2.getClassLoader());
//    Object object2 = clazz2.newInstance();
//    System.out.println(object2);
//
//    System.out.println("-----------------------------");
//    ClassLoader5 loader3 = new ClassLoader5("loader3");
//    loader3.setPath("D:\\jvmclasses\\");
//    Class<?> clazz3 = loader3.loadClass("com.classloader.loader.ClassLoader4");
//    System.out.println("clazz3=" + clazz3.hashCode());
//    System.out.println(clazz3.getClassLoader());
//    Object object3 = clazz3.newInstance();
//    System.out.println(object3);

  }

}
