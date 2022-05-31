package com.company.Testing.extension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Extension {

  // Check out the folder. There's a work file and a test file.

  //  -  Run the tests, all 10 should be green (passing).
  //  -  The implementations though are not quite good.
  //  -  Create tests that'll fail, and will show how the implementations are wrong(You can assume that the implementation of join and split are good)
  //  -  After creating the tests, fix the implementations
  //  -  Check again, if you can create failing tests
  //  -  Implement if needed


  int add(int a, int b) {
    return a + b;
  }

  int maxOfThree(int a, int b, int c) {
    if (a > b && a > c) {
      return a;
    } else if (b > c) {
      return b;
    } else {
      return c;
    }
  }

  float median(List<Integer> pool) {
    ArrayList<Integer> sorted = new ArrayList<>(pool);
    Collections.sort(sorted);
    if (pool.size() % 2 == 0) {
      int firstNumber = sorted.get((sorted.size() / 2) - 1);
      int secondNumber = sorted.get((sorted.size() / 2));

      return (float) (firstNumber + secondNumber) / 2;

    } else {
      return sorted.get((sorted.size() - 1) / 2);
    }
  }

  boolean isVowel(char c) {
    return Arrays.asList('a', 'u', 'o', 'e', 'i').contains(c);
  }

  String translate(String hungarian) {
    String teve = hungarian;
    int length = teve.length();
    for (int i = 0; i < length; i++) {
      char c = teve.charAt(i);
      if (isVowel(c)) {
        teve = String.join(c + "v" + c, teve.split("" + c));
        i += 2;
        length += 2;
      }
    }
    return teve;
  }
}
