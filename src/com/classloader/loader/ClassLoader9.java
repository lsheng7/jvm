package com.classloader.loader;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 * @Description TODO
 * @Author Harry
 * @Date 2019/2/1 20:32
 **/
public class ClassLoader9 {

  public static void main(String[] args) {

//    sun.misc.Launcher$ExtClassLoader@29453f44
//    sun.misc.Launcher$AppClassLoader@18b4aac2

    AESKeyGenerator keyGenerator = new AESKeyGenerator();
    System.out.println(keyGenerator.getClass().getClassLoader());
    System.out.println(ClassLoader9.class.getClassLoader());

//通过修改java.ext.dirs的路径使用cmd运行观察现象
  }
}
