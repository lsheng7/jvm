package com.classloader.loader;

//Lession19
//类中的相互引用的加载
//MyCat和MySample
public class ClassLoader6 {


  public static void main(String[] args) throws Exception {

//    ClassLoader5 loader1 = new ClassLoader5("loader1");

//    class:1735600054
//    MySample is loaded by:sun.misc.Launcher$AppClassLoader@18b4aac2
//    MyCat is loaded by:sun.misc.Launcher$AppClassLoader@18b4aac2
//    com.classloader.loader.MySample@14ae5a5
//    Class<?> clazz = loader1.loadClass("com.classloader.loader.MySample");
//    System.out.println("class:" + clazz.hashCode());
//    如果注释掉该行,那么并不会实例化MySample对象,即MySample构造方法不会被调用
//    因此不会实例化MyCat对象 即没有对MyCat 进行主动使用
//    这里就不会加载MyCat.class[是否加载时不一定的 类的加载不依赖于首次主动使用]
//    Object object = clazz.newInstance();
//    System.out.println(object);


//    -----------------------------------------------------


//    删除classpath下的MyCar.class和MySample.class
//    并拷贝到D:\jvmclasses下面
//    findClass invokedcom.classloader.loader.MySample
//        classLoaderName=loader2
//    class:59559151
//    MySample static invoked
//    MySample is loaded by:[loader2]
//    findClass invokedcom.classloader.loader.MyCat
//        classLoaderName=loader2
//    MyCat is loaded by:[loader2]
//    com.classloader.loader.MySample@27ddd392
    ClassLoader5 loader2 = new ClassLoader5("loader2");
    loader2.setPath("D:\\jvmclasses\\");
    Class<?> clazz2 = loader2.loadClass("com.classloader.loader.MySample");
    System.out.println("class:" + clazz2.hashCode());
    Object object = clazz2.newInstance();
    System.out.println(object);




  }
}












