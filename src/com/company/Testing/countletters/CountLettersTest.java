package com.company.Testing.countletters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountLettersTest {

  @Test
  void countLetters() {
    String input = "green fox academy";

    Assertions.assertAll(() -> assertEquals(1, CountLetters.countLetters(input).get("g")),
        () -> assertEquals(1, CountLetters.countLetters(input).get("r")),
        () -> assertEquals(3, CountLetters.countLetters(input).get("e")),
        () -> assertEquals(1, CountLetters.countLetters(input).get("n")),
        () -> assertEquals(1, CountLetters.countLetters(input).get("f")),
        () -> assertEquals(1, CountLetters.countLetters(input).get("o")),
        () -> assertEquals(1, CountLetters.countLetters(input).get("x")),
        () -> assertEquals(2, CountLetters.countLetters(input).get("a")),
        () -> assertEquals(1, CountLetters.countLetters(input).get("c")),
        () -> assertEquals(1, CountLetters.countLetters(input).get("d")),
        () -> assertEquals(1, CountLetters.countLetters(input).get("m")),
        () -> assertEquals(1, CountLetters.countLetters(input).get("y")),
        () -> assertNull(CountLetters.countLetters(input).get("z")));
  }

  @Test
  void emptyInput(){
    String emptyString = "";
    assertNull(CountLetters.countLetters(emptyString).get(""));
  }
}