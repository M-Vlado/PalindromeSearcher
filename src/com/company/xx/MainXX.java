package com.company.xx;

public class MainXX {
  public static void main(String[] args) {

    Person lukas = new Person("Lukas", 30);
    Person vlado = new Person("Vlado", 34);
    Person peto = new Person("Peto", 35);

    lukas.addHobbies("hockey");

    ClassRoom room4b = new ClassRoom();



    System.out.println(room4b);

    room4b.addStudent(lukas);

    System.out.println(room4b);

    room4b.addStudent(vlado);
    room4b.addStudent(peto);

    System.out.println(room4b.getRoom());

  }
}
