package com.practice.algorithms;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SumArrayTargetTest {

  @Test
  void twoSumHash_ShouldReturnPair_WhenSolutionExists() {
    assertArrayEquals(new int[] {2, 7}, SumArrayTarget.twoSumHash(new int[] {2, 7, 11, 15}, 9));
  }

  @Test
  void twoSum_ShouldReturnNotFoundPair_WhenSolutionMissing() {
    assertArrayEquals(new int[] {-1, -1}, SumArrayTarget.twoSum(new int[] {1, 2, 3}, 100));
  }

  @Test
  void twoSumHash_ShouldHandleEmptyArray() {
    assertArrayEquals(new int[] {-1, -1}, SumArrayTarget.twoSumHash(new int[] {}, 5));
  }
}
