package com.company.Testing.animal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnimalTest {

  Animal animal;

  @BeforeEach
  void init() {
    animal = new Animal();
  }

  @Test
  void eat() {
    animal.eat();
    assertEquals(49, animal.getHunger());
  }

  @Test
  void drink() {
    animal.drink();
    assertEquals(49, animal.getThirst());
  }

  @Test
  void play() {
    animal.play();
    Assertions.assertAll(() -> assertEquals(51, animal.getHunger()),
        () -> assertEquals(51, animal.getThirst()));
  }
}