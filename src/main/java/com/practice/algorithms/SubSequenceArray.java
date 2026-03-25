package com.practice.algorithms;

/**
 * Subsequence validation helper.
 */
public final class SubSequenceArray {

  private SubSequenceArray() {}

  /**
   * Checks whether {@code sequence} is a subsequence of {@code array}.
   *
   * <p>Time Complexity: O(n), where n is {@code array.length}
   *
   * <p>Space Complexity: O(1)
   *
   * @param array source array
   * @param sequence candidate subsequence
   * @return {@code true} when the sequence appears in order; otherwise {@code false}
   */
  public static boolean isValidSubsequence(int[] array, int[] sequence) {
    int seqIndex = 0;
    for (int num : array) {
      if (seqIndex == sequence.length) {
        break;
      }
      if (num == sequence[seqIndex]) {
        seqIndex++;
      }
    }
    return seqIndex == sequence.length;
  }
}
