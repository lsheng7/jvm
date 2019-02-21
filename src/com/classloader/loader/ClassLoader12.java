package com.classloader.loader;

/**
 * Lession23 类加载器双亲委托模型的好处:
 *
 * 1. 可以确保java核心库的类型安全：所有的Java应用都至少引用java.lang.Object类， 也就是说在运行期间，java.lang.Object这个类会加载到JVM中，如果这个加载过程是由
 * java应用自己的类加载器加载完成的，就会在JVM中存在多个版本的java.lang.Object类而 且这些类之间是相互不兼容的及相互不可见的[正是命名空间在发挥着作用]。借助于双亲委托机制，
 * 可以很好的保证java核心类库中的类加载工作都是由根类加载器来统一完成，从而确保了java 应用所使用的都是同一个版本的java核心类库，它们之间是相互兼容的。
 *
 * 2. 可以保证java核心类库所提供的类不会被自定义的类所替代。
 *
 * 3. 不同的类加载器可以为相同名称[bytecode name]的类创建命名空间， 那么相同名称的类可以并存在JVM内存中，只需要使用不同的类加载器来
 * 加载它们即可。不同的类加载器之间是不兼容的。这就相当于在JVM内部创建 了一个又一个的相互隔离的类空间，这类技术在多框架中都得到了大量应用。
 **/
public class ClassLoader12 {


  static {

    System.out.println("ClassLoader12 initializer");
  }

  public static void main(String[] args) {

//    ClassLoader12 initializer
//    sun.misc.Launcher$AppClassLoader@18b4aac2
//    sun.misc.Launcher$AppClassLoader@18b4aac2
//    同一个系统类加载器实例加载以下两个类的class文件
    System.out.println(ClassLoader12.class.getClassLoader());
    System.out.println(ClassLoader1.class.getClassLoader());
    System.out.println("------------------------------------");








  }

}
