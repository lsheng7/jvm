package com.classloader.loader;

/**
 * @Description TODO
 * @Author Harry
 * @Date 2019/1/31 21:06
 **/
public class MySample {


  static {
    System.out.println("MySample static invoked ");
  }

  public MySample() {

    System.out.println("MySample is loaded by:" + this.getClass().getClassLoader());
    System.out.println("from MySample:"+MyCat.class);
    //引用Cat类
    new MyCat();
  }


}
