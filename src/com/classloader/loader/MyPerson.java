package com.classloader.loader;

/**
 * @Description TODO
 * @Author Harry
 * @Date 2019/2/1 20:46
 **/
public class MyPerson {


  private MyPerson person;


  public void setPerson(Object object){

    this.person= (MyPerson) object;
    //如果不使用这种方式
    // 调用者使用MyPerson.class就找不到了
  }
}
