package com.practice.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/** General utility helpers. */
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

  /**
   * Concatenates an array of strings end-to-end.
   *
   * @param strings Array of strings to join
   * @return A single concatenated string, or empty string if input is null/empty
   */
  public static String concat(String[] strings) {
    // 1. Defensive check for null or empty input
    if (strings == null || strings.length == 0) {
      return "";
    }

    // 2. Initialize StringBuilder with an estimated capacity to avoid resizing
    StringBuilder sb = new StringBuilder();

    for (String s : strings) {
      // 3. Null check individual elements to avoid "null" text in output
      if (s != null) {
        sb.append(s);
      }
    }

    return sb.toString();
  }

  // Write a function that finds the smallest positive difference (interval) between any two
  // integers in a list.

  /**
   * Finds the smallest positive interval between any two numbers in the list.
   *
   * @param numbers List of integers (min 2, max 100,000)
   * @return The smallest positive difference
   */
  public static int findSmallestInterval(List<Integer> numbers) {
    if (numbers == null) {
      throw new IllegalArgumentException("numbers must not be null");
    }
    if (numbers.size() < 2) {
      throw new IllegalArgumentException("numbers must contain at least 2 elements");
    }

    List<Integer> sortedNumbers = new ArrayList<>(numbers);

    // 1. Sort the list: O(n log n)
    // Using Collections.sort() which uses TimSort
    Collections.sort(sortedNumbers);

    // 2. Initialize with a large value
    int minInterval = Integer.MAX_VALUE;

    // 3. Compare adjacent elements: O(n)
    for (int i = 0; i < sortedNumbers.size() - 1; i++) {
      int currentInterval = sortedNumbers.get(i + 1) - sortedNumbers.get(i);

      if (currentInterval < minInterval) {
        minInterval = currentInterval;
      }

      // Early exit optimization: if interval is 0, we can't get smaller
      if (minInterval == 0) return 0;
    }

    return minInterval;
  }

  /**
     * Prints the content of a Reader to System.out.
     * Use try-with-resources to ensure the reader is closed automatically.
     */
    public static void print(Reader reader) throws IOException {
        if (reader == null) return;

        // 1. Wrap in BufferedReader for better performance (reduces I/O overhead)
        // 2. Try-with-resources ensures the reader closes even if an exception occurs
        try (BufferedReader br = new BufferedReader(reader)) {
            int code;
            while ((code = br.read()) != -1) {
                System.out.print((char) code);
            }
        }
    }
}
