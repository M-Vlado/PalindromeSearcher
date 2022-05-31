package com.company.Testing.sum;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SummingTest {

  Summing summing;

  @BeforeEach
  void init(){
    summing = new Summing();
  }

  @Test
  void sum() {
    ArrayList<Integer> inputs = new ArrayList<>(Arrays.asList(1,2,3,4,5));
    assertEquals(15, summing.sum(inputs));
  }

  @Test
  void sumEmptyListTest() {
    ArrayList<Integer> inputs = new ArrayList<>();
    assertEquals(0, summing.sum(inputs));
  }

  @Test
  void sumOneElementTest() {
    ArrayList<Integer> inputs = new ArrayList<>(Arrays.asList(1));
    assertEquals(1, summing.sum(inputs));
  }

  @Test
  void sumWithNullList() {
    ArrayList<Integer> inputs = null;
    assertEquals(0, summing.sum(inputs));
  }


}