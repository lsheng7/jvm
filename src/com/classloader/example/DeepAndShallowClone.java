package com.classloader.example;

public class DeepAndShallowClone {


  public static void main(String[] args) {

    Teacher teacher = new Teacher("王老师", "英语");
    Student student = new Student("小明", 11, teacher);

    Student clone = student.clone();
    clone.setName("小强");
    clone.setAge(20);
    clone.getTeacher().setName("李老师");

//    小明 11
//    小强 20
//    true
    System.out.println(student.getName() + " " + student.getAge());
    System.out.println(clone.getName() + " " + clone.getAge());
    System.out.println(clone.getTeacher() == student.getTeacher());
    System.out.println("总结:从上面结果可知,克隆出来的Student对象里的name和age是新的,但是teacher是和原来的共享的,这就是浅克隆");







  }
}


class Student implements Cloneable {

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  private String name;
  private int age;
  private Teacher teacher;

  public Student(String name, int age, Teacher teacher) {
    this.name = name;
    this.age = age;
    this.teacher = teacher;
  }

  public Student clone() {
    Student student = null;
    try {
      student = (Student) super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return student;
  }

}

class Teacher implements Cloneable {

  private String name;
  private String course;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCourse() {
    return course;
  }

  public void setCourse(String course) {
    this.course = course;
  }

  public Teacher(String name, String course) {
    this.name = name;
    this.course = course;
  }

}