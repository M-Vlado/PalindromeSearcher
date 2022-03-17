package com.company;

import java.util.Arrays;

public class SortThatList {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(bubble(new int[] {34, 12, 24, 9, 5})));
    System.out.println(Arrays.toString(advancedBubble(new int[] {34, 12, 24, 9, 5}, true)));
  }

  public static int[] bubble(int[] arrForSorting) {
    int[] sortedArr = arrForSorting;
    Arrays.sort(sortedArr);

    return sortedArr;
  }

  public static int[] advancedBubble(int[] arrForSorting, boolean shouldReversed) {
    int[] sortedArr = arrForSorting;
    Arrays.sort(sortedArr);
    int[] revers = new int[sortedArr.length];

    if (shouldReversed) {
      int helper = 0;
      for (int i = sortedArr.length - 1; i >= 0; i--) {
        revers[helper] = sortedArr[i];
        helper++;
      }

      sortedArr = revers;
    }
    return sortedArr;
  }
}
