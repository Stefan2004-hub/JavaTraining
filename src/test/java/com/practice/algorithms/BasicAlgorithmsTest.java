package com.practice.algorithms;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BasicAlgorithmsTest {

  private final BasicAlgorithms subject = new BasicAlgorithms();

  @Test
  void isPalindrome_ShouldReturnTrue_ForPalindrome() {
    assertTrue(subject.isPalindrome("Level"));
  }

  @Test
  void isPalindromeOptimal_ShouldReturnFalse_ForNullInput() {
    assertFalse(subject.isPalindromeOptimal(null));
  }

  @Test
  void findMax_ShouldThrow_ForEmptyArray() {
    assertThrows(IllegalArgumentException.class, () -> subject.findMax(new int[] {}));
  }

  @Test
  void areAnagrams_ShouldReturnTrue_ForSameLetters() {
    assertTrue(subject.areAnagrams("listen", "silent"));
  }

  @Test
  void firstNonRepeatingCharacter_ShouldReturnNull_ForEmptyInput() {
    assertNull(subject.firstNonRepeatingCharacter(""));
  }

  @Test
  void bubbleSort_ShouldSortValuesAscending() {
    assertArrayEquals(new int[] {1, 2, 3, 4}, subject.bubbleSort(new int[] {4, 2, 1, 3}));
  }

  @Test
  void frequencyArray_ShouldReturnCounts() {
    assertArrayEquals(new int[] {0, 1, 2, 1}, subject.frequencyArray(new int[] {1, 2, 2, 3}));
  }

  @Test
  void sort_ShouldUseMergeSort() {
    int[] input = {5, 2, 9, 1};
    assertArrayEquals(new int[] {1, 2, 5, 9}, subject.sort(input, 0, input.length - 1));
  }

  @Test
  void firstNonRepeatingCharacter2_ShouldReturnFirstUnique() {
    assertEquals('w', BasicAlgorithms.firstNonRepeatingCharacter2("swiss"));
  }

  @Test
  void scoreRewrite4_NullInputs_ReturnsMinusOne() {
    assertEquals(-1, BasicAlgorithms.scoreRewrite4(null, null));
  }

  @Test
  void scoreRewrite4_OneNullInput_ReturnsMinusOne() {
    assertEquals(-1, BasicAlgorithms.scoreRewrite4(null, "abc"));
    assertEquals(-1, BasicAlgorithms.scoreRewrite4("abc", null));
  }

  @Test
  void scoreRewrite4_BothEmpty_Returns100() {
    assertEquals(100, BasicAlgorithms.scoreRewrite4("", ""));
  }

  @Test
  void scoreRewrite4_OneEmptyInput_ReturnsMinusOne() {
    assertEquals(-1, BasicAlgorithms.scoreRewrite4("", "abc"));
    assertEquals(-1, BasicAlgorithms.scoreRewrite4("abc", ""));
  }

  @Test
  void scoreRewrite4_ExactMatch_Returns100() {
    assertEquals(100, BasicAlgorithms.scoreRewrite4("abc", "abc"));
    assertEquals(100, BasicAlgorithms.scoreRewrite4("hello", "hello"));
  }

  @Test
  void scoreRewrite4_NoCommonSubstringLength3OrMore_Returns0() {
    assertEquals(0, BasicAlgorithms.scoreRewrite4("abc", "xyz"));
  }

  @Test
  void scoreRewrite4_StringsShorterThanMinMatchLength_Returns0() {
    assertEquals(0, BasicAlgorithms.scoreRewrite4("ab", "ac"));
    assertEquals(0, BasicAlgorithms.scoreRewrite4("a", "b"));
  }

  @Test
  void scoreRewrite4_OneStringContainsTheOther_Returns100() {
    assertEquals(100, BasicAlgorithms.scoreRewrite4("abcd", "abcdef"));
  }

  @Test
  void scoreRewrite4_PartialPrefixMatch_CalculatesCorrectScore() {
    assertEquals(60, BasicAlgorithms.scoreRewrite4("abcde", "abcXY"));
  }

  @Test
  void scoreRewrite4_MultipleSeparateMatches_AccumulatesScore() {
    assertEquals(67, BasicAlgorithms.scoreRewrite4("abcXYZdef", "abcLMNdef"));
  }

  @Test
  void scoreRewrite4_GreedyPicksLongestMatchFirst() {
    assertEquals(57, BasicAlgorithms.scoreRewrite4("XXXXabc", "XXXXdef"));
  }

  @Test
  void scoreRewrite4_ScoreRounding_RoundsCorrectly() {
    assertEquals(67, BasicAlgorithms.scoreRewrite4("abcdEF", "abcdGH"));
  }

  @Test
  void scoreRewrite4_IsSymmetric() {
    assertEquals(
        BasicAlgorithms.scoreRewrite4("abcde", "abcXY"),
        BasicAlgorithms.scoreRewrite4("abcXY", "abcde"));
  }
}
