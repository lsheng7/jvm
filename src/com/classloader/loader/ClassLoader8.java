package com.classloader.loader;

/**
 * @Description TODO
 * @Author Harry
 * @Date 2019/2/1 20:20
 **/
public class ClassLoader8 {


  public static void main(String[] args) throws Exception {

    ClassLoader5 loader1 = new ClassLoader5("loader1");
    loader1.setPath("D:\\jvmclasses\\");
    System.out.println("将对应的class文件复制到根类加载器的加载路径");
    Class<?> clazz = loader1.loadClass("com.classloader.loader.ClassLoader1");
    System.out.println("clazz:" + clazz.hashCode());
    System.out.println("class loader:" + clazz.getClassLoader());//null


  }
}
