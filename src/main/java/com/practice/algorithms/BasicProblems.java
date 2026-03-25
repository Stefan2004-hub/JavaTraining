package com.practice.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Core interview problems with concise implementations.
 */
public class BasicProblems {

  /**
   * Returns the indices of two numbers that sum to the target.
   *
   * <p>Time Complexity: O(n)
   *
   * <p>Space Complexity: O(n)
   *
   * @param nums input array
   * @param target target sum
   * @return indices of the matching pair
   * @throws IllegalArgumentException if input is invalid or no solution exists
   */
  public int[] twoSum(int[] nums, int target) {
    if (nums == null || nums.length < 2) {
      throw new IllegalArgumentException("Input array must have at least two elements");
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] {map.get(complement), i};
      }
      map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution found");
  }

  /**
   * Checks whether an integer is a palindrome by reversing its string form.
   *
   * <p>Time Complexity: O(d), where d is the number of digits
   *
   * <p>Space Complexity: O(d)
   *
   * @param x input integer
   * @return {@code true} if palindrome; otherwise {@code false}
   */
  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    String str = Integer.toString(x);
    String reversedStr = new StringBuilder(str).reverse().toString();
    return str.equals(reversedStr);
  }

  /**
   * Checks whether an integer is a palindrome with two-pointer character comparison.
   *
   * <p>Time Complexity: O(d), where d is the number of digits
   *
   * <p>Space Complexity: O(d)
   *
   * @param x input integer
   * @return {@code true} if palindrome; otherwise {@code false}
   */
  public boolean isPalindrome2(int x) {
    String str = Integer.toString(x);
    int right = str.length() - 1;
    int left = 0;
    for (char s : str.toCharArray()) {
      if (s != str.charAt(right)) {
        return false;
      }
      right--;
      left++;
      if (right == left) {
        break;
      }
    }
    return true;
  }
}
