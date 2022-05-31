package com.company.Testing.countletters;

import java.util.HashMap;

public class CountLetters {

  public static HashMap<String, Integer> countLetters(String input) {
    HashMap<String, Integer> dictionary = new HashMap<>();
    char[] inputChar = input.toCharArray();
    for (int i = 0; i < inputChar.length; i++) {
      if (dictionary.containsKey(String.valueOf(inputChar[i]))) {
        boolean b = dictionary.replace(String.valueOf(inputChar[i]),
            dictionary.get(String.valueOf(inputChar[i])),
            dictionary.get(String.valueOf(inputChar[i])) + 1);
      } else {
        dictionary.put(String.valueOf(inputChar[i]), 1);
      }
    }
    return dictionary;

  }
}
