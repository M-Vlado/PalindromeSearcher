package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromeSearcher {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(palindromeSearcher("dog goat dad duck doodle never")));
    System.out.println(Arrays.toString(palindromeSearcher("apple")));
    System.out.println(Arrays.toString(palindromeSearcher("racecar")));
    System.out.println(Arrays.toString(palindromeSearcher("")));

  }

  public static String[] palindromeSearcher(String input) {
    List<String> foundedPalindromes = new ArrayList<>();

    // iterate each letter in the input String
    for (int i = 0; i < input.length(); i++) {
      // check if the character is not ' ' just space
      if (input.charAt(i) != ' ') {
        // creating a new String from iterating character (iterating character is NOT included)
        String remainingString = input.substring(i + 1);
        int nextSameLetter;
        // check if is there any other character
        // System.out.println(remainingString.indexOf('t'));
        if (remainingString.indexOf(input.charAt(i)) == -1) {
          continue;       // if not just continue in the for loop
        } else {
          // if there is a same character - save his index number
          nextSameLetter = remainingString.indexOf(input.charAt(i)) + 1 + i;

        }

        // check if is between same characters only one more character
        if (i + 2 == nextSameLetter) {
          // if yes it means that the word is Palindrome and save it to Array list
          foundedPalindromes.add(input.substring(i, nextSameLetter + 1));
          // check if between the first and last same character is some characters at least one
        } else if (i + 1 != nextSameLetter) {
          boolean isSame = true;
          int indexFirst = i;
          int indexLast = nextSameLetter;
          while (isSame) {
            // check if first character and the last are not on same index
            if (indexFirst != indexLast) {
              // check if the characters are same - if they are mirroring =do___od= first==last, second==second last
              if (input.charAt(indexFirst) == input.charAt(indexLast)) {
                indexFirst++;
                indexLast--;
                // check if the last check wasn't the last pair of characters to check
                if ((indexFirst > indexLast)) {
                  //if yes save word as next Palindrome - this check is because the Palindromes with countable amount of characters
                  foundedPalindromes.add(input.substring(i, nextSameLetter + 1));
                  isSame = false; // finish while loop to set condition to false

                }
              } else {
                isSame = false;
              }
            } else {
              // this is for uncountable Palindromes - if all letters are mirroring except the middle one
              foundedPalindromes.add(input.substring(i, nextSameLetter + 1));
              isSame = false;
            }
          }
        }

      }
    }

    return foundedPalindromes.toArray(new String[foundedPalindromes.size()]);
  }
}
