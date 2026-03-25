package com.practice.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class UtilsTest {

  @Test
  void reverseString_ShouldReturnReversedValue() {
    assertEquals("!dlroW ,olleH", Utils.reverseString("Hello, World!"));
  }

  @Test
  void countWordOccurences_ShouldCountMatches() {
    assertEquals(
        2, Utils.countWordOccurences(new String[] {"apple", "banana", "apple", "orange"}, "apple"));
  }

  @Test
  void removeDuplicates_ShouldHandleDuplicatesAndPreserveOrder() {
    assertIterableEquals(
        List.of("apple", "banana", "orange"),
        Utils.removeDuplicates(List.of("apple", "banana", "apple", "orange")));
  }

  @Test
  void removeDuplicatesSet_ShouldReturnUniqueElements() {
    Set<String> result = Utils.removeDuplicatesSet(List.of("a", "b", "a"));
    assertEquals(2, result.size());
    assertTrue(result.contains("a"));
    assertTrue(result.contains("b"));
  }
}
