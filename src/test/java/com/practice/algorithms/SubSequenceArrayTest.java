package com.practice.algorithms;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SubSequenceArrayTest {

  @Test
  void isValidSubsequence_ShouldReturnTrue_ForHappyPath() {
    assertTrue(
        SubSequenceArray.isValidSubsequence(
            new int[] {5, 1, 22, 25, 6, -1, 8, 10}, new int[] {1, 6, -1, 10}));
  }

  @Test
  void isValidSubsequence_ShouldReturnFalse_WhenOrderIsBroken() {
    assertFalse(SubSequenceArray.isValidSubsequence(new int[] {1, 2, 3, 4}, new int[] {1, 4, 3}));
  }

  @Test
  void isValidSubsequence_ShouldReturnTrue_ForEmptySequence() {
    assertTrue(SubSequenceArray.isValidSubsequence(new int[] {1, 2, 3}, new int[] {}));
  }
}
