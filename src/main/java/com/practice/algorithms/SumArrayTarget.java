package com.practice.algorithms;

import java.util.HashSet;

/**
 * Two-sum interview helpers.
 */
public final class SumArrayTarget {

  private SumArrayTarget() {}

  /**
   * Finds two values whose sum equals the target using brute force.
   *
   * <p>Time Complexity: O(n^2)
   *
   * <p>Space Complexity: O(1)
   *
   * @param arr input array of integers
   * @param target desired target sum
   * @return pair of values if found; otherwise {@code [-1, -1]}
   */
  public static int[] twoSum(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] + arr[j] == target) {
          return new int[] {arr[i], arr[j]};
        }
      }
    }
    return new int[] {-1, -1};
  }

  /**
   * Finds two values whose sum equals the target using a hash set.
   *
   * <p>Time Complexity: O(n)
   *
   * <p>Space Complexity: O(n)
   *
   * @param arr input array of integers
   * @param target desired target sum
   * @return pair of values if found; otherwise {@code [-1, -1]}
   */
  public static int[] twoSumHash(int[] arr, int target) {
    HashSet<Integer> seen = new HashSet<>();
    for (int num : arr) {
      int complement = target - num;
      if (seen.contains(complement)) {
        return new int[] {complement, num};
      }
      seen.add(num);
    }
    return new int[] {-1, -1};
  }
}
