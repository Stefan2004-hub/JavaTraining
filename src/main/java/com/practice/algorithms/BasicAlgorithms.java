package com.practice.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Collection of common interview-ready algorithm exercises.
 */
public class BasicAlgorithms {

  /**
   * Checks whether a string is a palindrome by reversing it.
   *
   * <p>Time Complexity: O(n)
   *
   * <p>Space Complexity: O(n)
   *
   * @param s input string
   * @return {@code true} if palindrome; otherwise {@code false}
   */
  public boolean isPalindrome(String s) {
    if (s == null) {
      return false;
    }
    String reversed = new StringBuilder(s).reverse().toString();
    return s.equalsIgnoreCase(reversed);
  }

  /**
   * Checks whether a string is a palindrome with two pointers.
   *
   * <p>Time Complexity: O(n)
   *
   * <p>Space Complexity: O(1)
   *
   * @param s input string
   * @return {@code true} if palindrome; otherwise {@code false}
   */
  public boolean isPalindromeOptimal(String s) {
    if (s == null) {
      return false;
    }
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  /**
   * Finds the maximum element in an integer array.
   *
   * <p>Time Complexity: O(n)
   *
   * <p>Space Complexity: O(1)
   *
   * @param arr input array
   * @return largest value in the array
   * @throws IllegalArgumentException if array is null or empty
   */
  public int findMax(int[] arr) {
    if (arr == null || arr.length == 0) {
      throw new IllegalArgumentException("Array cannot be null or empty");
    }
    int max = arr[0];
    for (int num : arr) {
      if (num > max) {
        max = num;
      }
    }
    return max;
  }

  /**
   * Checks whether two strings are anagrams by sorting their characters.
   *
   * <p>Time Complexity: O(n log n)
   *
   * <p>Space Complexity: O(n)
   *
   * @param s1 first input string
   * @param s2 second input string
   * @return {@code true} if anagrams; otherwise {@code false}
   */
  public boolean areAnagrams(String s1, String s2) {
    if (s1 == null || s2 == null) {
      return false;
    }
    char[] arr1 = s1.toLowerCase().toCharArray();
    char[] arr2 = s2.toLowerCase().toCharArray();
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    return Arrays.equals(arr1, arr2);
  }

  /**
   * Checks whether two strings are anagrams using a frequency array for letters a-z.
   *
   * <p>Time Complexity: O(n)
   *
   * <p>Space Complexity: O(1)
   *
   * @param s1 first input string
   * @param s2 second input string
   * @return {@code true} if anagrams; otherwise {@code false}
   */
  public boolean areAnagramsFrequency(String s1, String s2) {
    if (s1 == null || s2 == null) {
      return false;
    }
    if (s1.length() != s2.length()) {
      return false;
    }

    int[] freq = new int[26];
    for (char c : s1.toLowerCase().toCharArray()) {
      freq[c - 'a']++;
    }
    for (char c : s2.toLowerCase().toCharArray()) {
      freq[c - 'a']--;
    }
    for (int count : freq) {
      if (count != 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Checks whether two strings are anagrams without ASCII-based indexing.
   *
   * <p>Time Complexity: O(n)
   *
   * <p>Space Complexity: O(n)
   *
   * @param str1 first input string
   * @param str2 second input string
   * @return {@code true} if anagrams; otherwise {@code false}
   */
  public static boolean areAnagramsNoAscii(String str1, String str2) {
    str1 = str1.toLowerCase().replace(" ", "");
    str2 = str2.toLowerCase().replace(" ", "");

    if (str1.length() != str2.length()) {
      return false;
    }

    Map<Character, Integer> charCounts = new HashMap<>();
    for (char c : str1.toCharArray()) {
      charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
    }

    for (char c : str2.toCharArray()) {
      if (!charCounts.containsKey(c)) {
        return false;
      }
      charCounts.put(c, charCounts.get(c) - 1);
    }

    for (int count : charCounts.values()) {
      if (count != 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Returns the first non-repeating character in a string.
   *
   * <p>Time Complexity: O(n)
   *
   * <p>Space Complexity: O(n)
   *
   * @param s input string
   * @return first non-repeating character, or {@code null} if none exists
   */
  public Character firstNonRepeatingCharacter(String s) {
    if (s == null || s.isEmpty()) {
      return null;
    }

    Map<Character, Integer> charCounts = new HashMap<>();
    for (char c : s.toCharArray()) {
      charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
    }

    for (char c : s.toCharArray()) {
      if (charCounts.get(c) == 1) {
        return c;
      }
    }
    return null;
  }

  /**
   * Returns the first non-repeating character using explicit map updates.
   *
   * <p>Time Complexity: O(n)
   *
   * <p>Space Complexity: O(n)
   *
   * @param input input string
   * @return first non-repeating character, or {@code null} if none exists
   */
  public static Character firstNonRepeatingCharacter2(String input) {
    if (input == null || input.isEmpty()) {
      return null;
    }

    Map<Character, Integer> counts = new HashMap<>();
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (counts.containsKey(c)) {
        int currentCount = counts.get(c);
        counts.put(c, currentCount + 1);
      } else {
        counts.put(c, 1);
      }
    }

    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (counts.get(c) == 1) {
        return c;
      }
    }
    return null;
  }

  /**
   * Sorts an array in ascending order using bubble sort.
   *
   * <p>Time Complexity: O(n^2)
   *
   * <p>Space Complexity: O(1)
   *
   * @param arr input array to sort in place
   * @return same array reference after sorting
   */
  public int[] bubbleSort(int[] arr) {
    if (arr == null || arr.length == 0) {
      return arr;
    }
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
    return arr;
  }

  /**
   * Sorts an array in ascending order using merge sort recursion.
   *
   * <p>Time Complexity: O(n log n)
   *
   * <p>Space Complexity: O(n)
   *
   * @param arr input array to sort in place
   * @param left left boundary index
   * @param right right boundary index
   * @return same array reference after sorting
   */
  public int[] sort(int[] arr, int left, int right) {
    if (left < right) {
      int mid = left + (right - left) / 2;
      sort(arr, left, mid);
      sort(arr, mid + 1, right);
      merge(arr, left, mid, right);
    }
    return arr;
  }

  /**
   * Merges two sorted halves of an array.
   *
   * <p>Time Complexity: O(n)
   *
   * <p>Space Complexity: O(n)
   *
   * @param arr array containing two sorted halves
   * @param left left boundary index
   * @param mid midpoint index
   * @param right right boundary index
   */
  private void merge(int[] arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;
    int[] leftArray = new int[n1];
    int[] rightArray = new int[n2];

    for (int i = 0; i < n1; ++i) {
      leftArray[i] = arr[left + i];
    }
    for (int j = 0; j < n2; ++j) {
      rightArray[j] = arr[mid + 1 + j];
    }

    int i = 0;
    int j = 0;
    int k = left;
    while (i < n1 && j < n2) {
      if (leftArray[i] <= rightArray[j]) {
        arr[k++] = leftArray[i++];
      } else {
        arr[k++] = rightArray[j++];
      }
    }
    while (i < n1) {
      arr[k++] = leftArray[i++];
    }
    while (j < n2) {
      arr[k++] = rightArray[j++];
    }
  }

  /**
   * Builds a frequency array for values from 0 to max(input).
   *
   * <p>Time Complexity: O(n)
   *
   * <p>Space Complexity: O(k), where k is max value in input + 1
   *
   * @param arr input array of non-negative integers
   * @return frequency array, or empty array for null/empty input
   */
  public int[] frequencyArray(int[] arr) {
    if (arr == null || arr.length == 0) {
      return new int[0];
    }
    int max = findMax(arr);
    int[] freq = new int[max + 1];
    for (int num : arr) {
      freq[num]++;
    }
    return freq;
  }
}
