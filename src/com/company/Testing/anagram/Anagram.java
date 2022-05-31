package com.company.Testing.anagram;

import java.util.Arrays;

public class Anagram {
  public static boolean isAnagram(String string1, String string2) {

    if ((string1 == null || string2 == null) ||
        string1.trim().length() != string2.trim().length()) {
      return false;
    }
    char[] first = string1.trim().toCharArray();
    char[] second = string2.trim().toCharArray();

    Arrays.sort(first);
    Arrays.sort(second);

    return Arrays.equals(first, second);
  }

}
