package com.practice.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UtilsTest {
  private final PrintStream originalOut = System.out;
  private ByteArrayOutputStream outContent;

  @BeforeEach
  void setUpOutputCapture() {
    outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  void restoreSystemOut() {
    System.setOut(originalOut);
  }

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

  @Test
  void concat_ShouldConcatenateStrings() {
    assertEquals("Hello, World!", Utils.concat(new String[] {"Hello, ", "World!"}));
  }

  @Test
  void findSmallestInterval_ShouldReturnCorrectCount_ForHappyPath() {
    // The smallest positive interval is between 7 and 10 (3)
    List<Integer> numbers = List.of(1, 15, 7, 22, 10);
    assertEquals(3, Utils.findSmallestInterval(numbers));
  }

  @Test
  void findSmallestInterval_ShouldReturnZero_ForDuplicateValues() {
    assertEquals(0, Utils.findSmallestInterval(List.of(4, 2, 4, 10)));
  }

  @Test
  void findSmallestInterval_ShouldThrowException_ForNullInput() {
    assertThrows(IllegalArgumentException.class, () -> Utils.findSmallestInterval(null));
  }

  @Test
  void findSmallestInterval_ShouldThrowException_ForSingleElementList() {
    List<Integer> singleElement = List.of(7);
    assertThrows(IllegalArgumentException.class, () -> Utils.findSmallestInterval(singleElement));
  }

  @Test
  void print_ShouldOutputCorrectContent_ForStringReader() throws IOException {
    String input = "Hello, CGM!";
    Reader reader = new StringReader(input);

    Utils.print(reader);

    assertEquals(input, outContent.toString());
  }
}
