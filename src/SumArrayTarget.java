// Write a function that takes in a non-empty array of distinct integers and an integer representing
// a
// target sum. If any two numbers in the input array sum up to the target sum, the function should
// return them in an array, in any order. If no numbers sum up to the target sum the function should
// return an empty array. Note that the target sum has to be obtained by summing two different
// integers in the array.
// You can't add a single integer to itself in order to obtain the target sum.
// You can assume that there will be at most one pair of numbers summing up to the target sum.

// Sample input,: [3, 5, -4, 8, 11, 1, -1, 6]
// Target sum = 10

// Sample output = [-1, 11]

import java.util.HashSet;

public class SumArrayTarget {
  public static int[] twoSum(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] + arr[j] == target) {
          return new int[] {arr[i], arr[j]};
        }
      }
    }
    return new int[] {-1, -1}; // Return -1, -1 if no solution is found
  }

  public static int[] twoSumHash(int[] arr, int target) {
    HashSet<Integer> seen = new HashSet<>();
    for (int num : arr) {
      int complement = target - num;
      if (seen.contains(complement)) {
        return new int[] {complement, num};
      }
      seen.add(num);
    }
    return new int[] {-1, -1}; // Return -1, -1 if no solution is found
  }
}
