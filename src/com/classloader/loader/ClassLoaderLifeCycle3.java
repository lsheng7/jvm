package com.classloader.loader;


//TraceClassLoding:
//    [Loaded com.classloader.loader.ClassLoaderLifeCycle3 from file:/C:/alipay/jvm/out/production/HelloWorld/]
//    [Loaded sun.launcher.LauncherHelper$FXHelper from C:\Program Files\Java\jdk1.8.0_162\jre\lib\rt.jar]
//    [Loaded java.lang.Class$MethodArray from C:\Program Files\Java\jdk1.8.0_162\jre\lib\rt.jar]
//    [Loaded java.lang.Void from C:\Program Files\Java\jdk1.8.0_162\jre\lib\rt.jar]
//    ClassLoader3 static block invoked
//    [Loaded java.net.URI from C:\Program Files\Java\jdk1.8.0_162\jre\lib\rt.jar]
//    [Loaded java.net.URI$Parser from C:\Program Files\Java\jdk1.8.0_162\jre\lib\rt.jar]
//    [Loaded com.classloader.loader.Parent3 from file:/C:/alipay/jvm/out/production/HelloWorld/]
//    [Loaded com.classloader.loader.Child3 from file:/C:/alipay/jvm/out/production/HelloWorld/]
//    [Loaded sun.net.spi.DefaultProxySelector$NonProxyInfo from C:\Program Files\Java\jdk1.8.0_162\jre\lib\rt.jar]
//    Parent3 static block invoked

public class ClassLoaderLifeCycle3 {

  static {
    System.out.println("ClassLoader3 static block invoked");
  }

  public static void main(String[] args) {

//    ClassLoader3 static block invoked//main method相当于调用奔类的静态方法会导致初始化
//    Parent3 static block invoked
//    Child3 static block invoked
//    4

    System.out.println(Child3.b);
  }


}

class Parent3{

  static int a=3;

  static{

    System.out.println("Parent3 static block invoked");
  }


}

class Child3 extends Parent3{

  static int b=4;

  static {

    System.out.println("Child3 static block invoked");
  }

}
