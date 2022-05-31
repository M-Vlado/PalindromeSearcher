package com.company.Testing.apples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApplesTest {

  Apples apples;

  @BeforeEach
  void init(){
    apples = new Apples();
  }

  @Test
  void getApple() {
    assertEquals("apple", apples.getApple());
  }
}