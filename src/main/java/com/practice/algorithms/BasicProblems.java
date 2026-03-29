package com.practice.algorithms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Core interview problems with concise implementations. */
public class BasicProblems {

  /**
   * Returns the indices of
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

  /*
  Your company builds signal monitoring devices. You are responsible for verifying sensor stability. When a sensor is unstable, its output shows large variations.
  Create a function that counts the number of peaks in a list of measurements:
  Top Peak: A value at least 5 units higher than both its immediate neighbors.
  Bottom Peak: A value at least 5 units lower than both its immediate neighbors.
  Constraints:
  The first and last elements can never be peaks.
  The input list contains between 0 and 20 values (always defined, never null).
  Values are between 0 and 100.

  Utility for analyzing data signal stability.
  * <p>This class provides methods to identify noise and fluctuations
  in sensor data streams by detecting significant peaks and valleys.</p>
  */
  /**
   * Identifies and counts "peaks" in a sequence of measurements. *
   *
   * <p>A peak is defined as a data point that deviates by at least 5 units from both its left and
   * right neighbors. This includes both high peaks (top) and low peaks (bottom).
   *
   * @param measurements A list of signal values (expected range: 0.0 to 100.0).
   * @return The total number of detected peaks. Returns 0 if arrthere are fewer than 3 elements, as
   *     boundary elements cannot be peaks.
   */
  public static int countSignalPeaks(List<Double> measurements) {
    // Boundary elements can never be peaks; requires at least 3 points.
    if (measurements == null || measurements.size() < 3) {
      return 0;
    }

    int totalPeaks = 0;
    final double THRESHOLD = 5.0;

    // Traverse from the second element to the second-to-last element
    for (int i = 1; i < measurements.size() - 1; i++) {
      double current = measurements.get(i);
      double previous = measurements.get(i - 1);
      double next = measurements.get(i + 1);

      // Check if current value is a top peak
      boolean isTop = (current >= previous + THRESHOLD) && (current >= next + THRESHOLD);

      // Check if current value is a bottom peak
      boolean isBottom = (current <= previous - THRESHOLD) && (current <= next - THRESHOLD);

      if (isTop || isBottom) {
        totalPeaks++;
      }
    }

    return totalPeaks;
  }

  /*
    Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
  Consider the number of unique elements in nums to be k​​​​​​​​​​​​​​. After removing duplicates, return the number of unique elements k.
  The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index k - 1 can be ignored.
  */
  /**
   * Removes duplicates from a sorted array in-place and returns the count of unique elements.
   *
   * @param nums
   * @return number of unique elements after duplicates are removed
   */
  public static int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int uniqueIndex = 1; // Start from the second element
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i - 1]) {
        nums[uniqueIndex] = nums[i];
        uniqueIndex++;
      }
    }
    return uniqueIndex;
  }

  /*
    Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

  Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

  Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
  Return k.
     */
  /**
   * Removes all occurrences of a given value from an integer array in-place.
   *
   * @param nums
   * @param val
   * @return number of elements not equal to val after removal
   */
  public static int removeElement(int[] nums, int val) {
    int k = 0; // Initialize the count of elements not equal to val
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[k] = nums[i];
        k++;
      }
    }
    return k;
  }
}
