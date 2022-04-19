package com.company.xx;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom {

  private List<Person> room = new ArrayList<>();

  public void addStudent(Person student){
    room.add(student);
  }

  public List<Person> getRoom() {
    return room;
  }

  @Override
  public String toString() {
    return "ClassRoom{" +
        "room=" + room +
        '}';
  }
}
