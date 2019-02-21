package com.classloader.loader;

//1. 在运行期间，一个java类加载器是由该类的完全限定名（bytecode name，二进制名）
// 和用于加载该类的定义类加载器（defining loader）所共同决定的。

//2. 如果同样名字的（即相同的完全限定名）是由不同的类加载器加载的 那么这些类是
// 不同的。即便.class文件完全相同，并且从相同的位置加载亦如此。

//如果修改sun.boot.class.path （系统类加载器的加载路径）会出现什么问题?
//Error occured during initialization of VM
//    java/lang/NoClassDefoundError: java/lang/Object
//原因:在oracle的hotspot实现中系统属性sun.boot.class.path
// 如果修改错了会提示如上信息，因为尝试加载类的时候会尝试加载父类，
// 直至加载顶层的Object.class 会出现上述错误。

import com.sun.crypto.provider.AESKeyGenerator;
import sun.misc.Launcher;

public class ClassLoader13 {


  //可以通过 使用cmd命令来运行该类比较路径的区别
  //将运行地址设定到class类所在的目录
  public static void main(String[] args) {

    //获取类加载器的加载类的绝对路径
    System.out.println(System.getProperty("sun.boot.class.path"));
    System.out.println("------------------------");
    System.out.println(System.getProperty("java.ext.dirs"));
    System.out.println("------------------------");
    System.out.println(System.getProperty("java.class.path"));

//1. 这些类加载器都是由根类加载器加载的，而根类加载器是通过c或者c++编写的，
// 是内置于JVM当中的，不需要加载 是JVM在启动的时候自动创建。
//2. 内建于JVM中的启动类加载器，会加载java.lang.ClassLoader
// 以及其他的Java平台类，当JVM启动时，一块特殊的机器码会运行，它会加载
// 扩展类加载器和系统类加载器，这块特殊的机器码叫做启动类加载器(BootStrap)，
// 启动类加载器并不是java类，而其他的加载器则都是java类，启动类加载器是特定于
// 平台的机器指令（因此是平台相关的），负责开启整个的加载过程，所有的类加载器
// （除了启动类加载器）都被实现为java类。不过总归要有一个组件加载第一个类加载器，
// 从而保证整个加载过程进行下去，那么加载第一个纯java类的类加载器就是启动类加载器的职责
// 。除此之外，启动类加载器还会负责加载供JRE正常运行所需要的基本组件，这包括java.util与
// java.lang包中的类等等。

//    null
//    sun.misc.Launcher$AppClassLoader@18b4aac2
//    null
//    null
//    null
    System.out.println(ClassLoader.class.getClassLoader());
    System.out.println(ClassLoader5.class.getClassLoader());
    //外界无法ExClassLoader 因为是静态内部类(非public)
    System.out.println(Launcher.class.getClassLoader());
    System.out.println(ClassLoader1.class.getClassLoader().getClass().getClassLoader());
    System.out.println(AESKeyGenerator.class.getClassLoader().getClass().getClassLoader());

//     * <p> The default system class loader is an implementation-dependent
//        * instance of this class.
//     *
//     * <p> If the system property "<tt>java.system.class.loader</tt>" is defined
//     * when this method is first invoked then the value of that property is
//        * taken to be the name of a class that will be returned as the system
//     * class loader.  The class is loaded using the default system class loader
//     * and must define a public constructor that takes a single parameter of
//        * type <tt>ClassLoader</tt> which is used as the delegation parent.  An
//        * instance is then created using this constructor with the default system
//        * class loader as the parameter.  The resulting class loader is defined
//     * to be the system class loader.
    ClassLoader.getSystemClassLoader();

    System.out.println("---------------------------");
//   Lession24 必须看
    //null
    //未被定义会直接指向AppClassLoader
    System.out.println(System.getProperty("java.system.class.loader"));

    //将自定义的类加载器作为系统类加载器
//    public ClassLoader5(ClassLoader parent) {
//      super(parent);
//    }
//    java -Djava.system.class.loader=com.classloader.loader.ClassLoader5  com.classloader.loader.ClassLoader1
//    会报错 必须定义一个接收一个参数类型
//    The class is loaded using the default system class loader
//     * and must define a public constructor that takes a single parameter of
//     * type <tt>ClassLoader</tt> which is used as the delegation parent

//    java -Djava.system.class.loader=com.classloader.loader.ClassLoader5  com.classloader.loader.ClassLoader1
//    输出是com.classloader.loader.ClassLoader5

//    AppClassLoader
//    AppClassLoader
//    AppClassLoader(IDEA)  ClassLoader5(cmd)
    System.out.println(ClassLoader1.class.getClassLoader());
    System.out.println(ClassLoader5.class.getClassLoader());
    System.out.println(ClassLoader.getSystemClassLoader());
  }

}
