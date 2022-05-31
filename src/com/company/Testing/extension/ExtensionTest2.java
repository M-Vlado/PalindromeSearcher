package com.company.Testing.extension;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class ExtensionTest2 {

  Extension extension = new Extension();


  @Test
  void testAdd_3and3is6() {
    assertEquals(6, extension.add(3, 3));
  }

  @Test
  void testAdd_4and4is8() {
    assertEquals(8, extension.add(4, 4));
  }

  @Test
  void testMaxOfThree_first() {
    assertEquals(5, extension.maxOfThree(5, 4, 3));
  }

  @Test
  void testMaxOfThree_second() {
    assertEquals(10, extension.maxOfThree(3, 10, 5));
  }

  @Test
  void testMaxOfThree_third() {
    assertEquals(5, extension.maxOfThree(3, 4, 5));
  }

  @Test
  void testMedian_four() {
    assertEquals(5.5, extension.median(Arrays.asList(7,4,3,9)));
  }

  @Test
  void testMedian_five() {
    assertEquals(4, extension.median(Arrays.asList(1,2,4,9,7)));
  }

  @Test
  void testIsVowel_a() {
    assertTrue(extension.isVowel('a'));
  }

  @Test
  void testIsVowel_u() {
    assertTrue(extension.isVowel('u'));
  }

  @Test
  void testIsNotVowel_x() {
    assertFalse(extension.isVowel('x'));
  }

  @Test
  @Deprecated
  void testTranslate_bemutatkozik() {
    assertEquals("bevemuvutavatkovozivik", extension.translate("bemutatkozik"));
  }

  @Test
  @Deprecated
  void testTranslate_lagopus() {
    assertEquals("lavagovopuvus", extension.translate("lagopus"));
  }
}