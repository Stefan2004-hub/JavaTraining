package com.practice.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * General utility helpers.
 */
public final class Utils {

  private Utils() {}

  /**
   * Reverses a string using manual character traversal.
   *
   * <p>Time Complexity: O(n)
   *
   * <p>Space Complexity: O(n)
   *
   * @param str input string
   * @return reversed string
   */
  public static String reverseString(String str) {
    StringBuilder reversed = new StringBuilder();
    for (int i = str.length() - 1; i >= 0; i--) {
      reversed.append(str.charAt(i));
    }
    return reversed.toString();
  }

  /**
   * Counts occurrences of a target word in an array of words.
   *
   * <p>Time Complexity: O(n)
   *
   * <p>Space Complexity: O(1)
   *
   * @param words input words
   * @param wordToCount target word
   * @return number of exact matches
   */
  public static int countWordOccurences(String[] words, String wordToCount) {
    int count = 0;
    for (String word : words) {
      if (word.equals(wordToCount)) {
        count++;
      }
    }
    return count;
  }

  /**
   * Removes duplicate items while preserving insertion order.
   *
   * <p>Time Complexity: O(n)
   *
   * <p>Space Complexity: O(n)
   *
   * @param list input list
   * @return de-duplicated list
   */
  public static List<String> removeDuplicates(List<String> list) {
    Set<String> seen = new LinkedHashSet<>(list);
    return new ArrayList<>(seen);
  }

  /**
   * Removes duplicates by converting to a set.
   *
   * <p>Time Complexity: O(n)
   *
   * <p>Space Complexity: O(n)
   *
   * @param list input list
   * @return set containing unique values
   */
  public static Set<String> removeDuplicatesSet(List<String> list) {
    return new HashSet<>(list);
  }
}
