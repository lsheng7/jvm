package com.classloader.loader;

/**
 * @Description TODO
 * @Author Harry
 * @Date 2019/1/31 21:04
 **/
public class MyCat {


  public MyCat() {
    System.out.println("MyCat is loaded by:" + this.getClass().getClassLoader());
    System.out.println("from myCar:"+MySample.class);
  }


}
