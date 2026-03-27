package com.practice.algorithms;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class BasicProblemsTest {

  private final BasicProblems subject = new BasicProblems();

  @Test
  void twoSum_ShouldReturnIndices_ForHappyPath() {
    assertArrayEquals(new int[] {0, 1}, subject.twoSum(new int[] {2, 7, 11, 15}, 9));
  }

  @Test
  void twoSum_ShouldThrow_ForNullInput() {
    assertThrows(IllegalArgumentException.class, () -> subject.twoSum(null, 9));
  }

  @Test
  void isPalindrome_ShouldReturnFalse_ForNegativeNumber() {
    assertFalse(subject.isPalindrome(-121));
  }

  @Test
  void isPalindrome2_ShouldReturnTrue_ForPalindromeNumber() {
    assertTrue(subject.isPalindrome2(1221));
  }

  @Test
  void countSignalPeaks_ShouldReturnCorrectCount_ForHappyPath() {
    List<Double> values = List.of(10.0, 15.0, 10.0, 2.0, 10.0);
    assertEquals(2, BasicProblems.countSignalPeaks(values));
  }
}
