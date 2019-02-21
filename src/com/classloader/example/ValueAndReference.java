package com.classloader.example;


import java.util.Arrays;

public class ValueAndReference {


  public static void main(String[] args) {

    User u1 = new User();
    u1.setUname("1");
    u1.setUpass("1");

    User u2 = new User();
    u2.setUpass("2");
    u2.setUname("2");
    new ValueAndReference().swap(u1, u2);

    System.out.println("u1=" + u1);
    System.out.println("u2=" + u2);
    System.out.println("-------------");

    Integer[] arr = {
        1, 2, 3, 4, 5, 6, 7, 8, 9, 0
    };

    new ValueAndReference().bubble(arr);

//    for (int item : arr) {
//      System.out.println(item);
//    }

    new ValueAndReference().mutableParam(arr);

  }


  void mutableParam(Integer... args) {

    Arrays.asList(args).forEach(System.out::println);

  }


  void swap(User u1, User u2) {

    User temp = u1;
    u1 = u2;
    u2 = temp;
    System.out.println(u1);
    System.out.println(u2);

  }


  void bubble(Integer[] arr) {

    for (int i = 0; i < arr.length; i++) {

      for (int j = i + 1; j < arr.length; j++) {

        if (arr[i] < arr[j]) {
          swap(i, j, arr);
        }
      }
    }
  }


  void swap(Integer i, Integer j, Integer[] arr) {
    int temp = arr[j];
    arr[j] = arr[i];
    arr[i] = temp;
  }
}

class User {


  private String uname;
  private String upass;
  public String getUname() {
    return uname;
  }

  public void setUname(String uname) {
    this.uname = uname;
  }

  public String getUpass() {
    return upass;
  }

  public void setUpass(String upass) {
    this.upass = upass;
  }

  @Override
  public String toString() {
    return "User{" +
        "uname='" + uname + '\'' +
        ", upass='" + upass + '\'' +
        '}';
  }
}
