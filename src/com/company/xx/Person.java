package com.company.xx;

import com.company.counter.Counter;
import java.util.ArrayList;
import java.util.List;

public class Person {

  private String name;
  private int age;
  private List<String> hobbies = new ArrayList<>();


  public Person() {
  }

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public void addHobbies(String hobie){
    hobbies.add(hobie);
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", hobbies=" + hobbies +
        '}';
  }
}
