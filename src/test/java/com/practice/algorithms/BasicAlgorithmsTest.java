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
}
