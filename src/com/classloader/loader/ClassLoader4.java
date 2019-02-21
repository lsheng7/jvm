package com.classloader.loader;

/**
 * 14
 *
 * 数组对象Class对象不是由类加载器创建的
 * 而是由jvm在运行期间动态生成的 对应的classLoader 是和其中包含的元素
 * 对应的类加载器相同的
 */
public class ClassLoader4 {


  public static void main(String[] args) {

    // If this object represents a primitive type or void, null is returned.
    //上面的这句话是从getClassLoader() java doc获取的
    int[] arr = new int[1];
    ClassLoader intClassLoader = arr.getClass().getClassLoader();

    // 这个null并不是表示根类加载器 而是表示没有类加载器
    //null
//     * Returns the class loader for the class.  Some implementations may use
//     * null to represent the bootstrap class loader. This method will return
//     * null in such implementations if this class was loaded by the bootstrap
//     * class loader.
//     启动类返回null hotspot 是由虚拟机创建的
    System.out.println(intClassLoader);

    String[] strings = new String[1];
//    null 表示根类加载器
    System.out.println(strings.getClass().getClassLoader());

//    sun.misc.Launcher$AppClassLoader@18b4aac2

    ClassLoader4[] classLoader4s = new ClassLoader4[1];
    System.out.println(classLoader4s.getClass().getClassLoader());

//    null
    System.out.println(Void.class.getClassLoader());


  }
}



