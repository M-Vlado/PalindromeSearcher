package com.company.Testing.anagram;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnagramTest {


  @Test
  void isAnagram() {
    assertTrue(Anagram.isAnagram("anagram", "anagram"));
  }

  @Test
  void isNotAnagram() {
    assertFalse(Anagram.isAnagram("anagram", "anagraa"));
  }

  @Test
  void isAnagramNull() {
    assertFalse(Anagram.isAnagram("", "anagraa"));
  }

  @Test
  void isAnagramDifferentLength() {
    assertFalse(Anagram.isAnagram("anagram222", "anagraa"));
  }

}