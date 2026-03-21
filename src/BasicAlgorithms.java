import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BasicAlgorithms {

  // algorithm for Check if a string is a palindrome (reads the same backward)
  public boolean isPalindrome(String s) {
    if (s == null) return false;
    String reversed = new StringBuilder(s).reverse().toString();
    return s.equalsIgnoreCase(reversed);
  }

  // optimal aproach for Check if a string is a palindrome (reads the same backward)
  public boolean isPalindromeOptimal(String s) {
    if (s == null) return false;
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  // algorithm for Find the maximum element in an array
  public int findMax(int[] arr) {
    if (arr == null || arr.length == 0) {
      throw new IllegalArgumentException("Array cannot be null or empty");
    }
    int max = arr[0];
    for (int num : arr) {
      if (num > max) {
        max = num;
      }
    }
    return max;
  }

  //   algorithm for Check if two strings are anagrams
  public boolean areAnagrams(String s1, String s2) {
    if (s1 == null || s2 == null) return false;
    char[] arr1 = s1.toLowerCase().toCharArray();
    char[] arr2 = s2.toLowerCase().toCharArray();
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    return Arrays.equals(arr1, arr2);
  }

  // Check if two strings are anagrams  The "Standard" Interview Approach: Frequency Array/Map
  public boolean areAnagramsFrequency(String s1, String s2) {
    if (s1 == null || s2 == null) return false;
    if (s1.length() != s2.length()) return false;

    int[] freq = new int[26]; // Assuming only lowercase letters
    for (char c : s1.toLowerCase().toCharArray()) {
      freq[c - 'a']++;
    }
    for (char c : s2.toLowerCase().toCharArray()) {
      freq[c - 'a']--;
    }
    for (int count : freq) {
      if (count != 0) {
        return false;
      }
    }
    return true;
  }

  //   algorithm for Check if two strings are anagrams (contain the same letters in different
  // order), please do not transform the characters into ASCII numeric values
  public static boolean areAnagramsNoAscii(String str1, String str2) {
    // 1. Basic normalization (optional depending on requirements)
    str1 = str1.toLowerCase().replace(" ", "");
    str2 = str2.toLowerCase().replace(" ", "");

    // 2. Length check
    if (str1.length() != str2.length()) {
      return false;
    }

    // 3. Use a HashMap to store character frequencies
    Map<Character, Integer> charCounts = new HashMap<>();

    // Increment counts for the first string
    for (char c : str1.toCharArray()) {
      charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
    }

    // Decrement counts for the second string
    for (char c : str2.toCharArray()) {
      if (!charCounts.containsKey(c)) {
        return false; // Character doesn't exist in first string
      }
      charCounts.put(c, charCounts.get(c) - 1);
    }

    // 4. Check if all frequencies are zero
    for (int count : charCounts.values()) {
      if (count != 0) {
        return false;
      }
    }

    return true;
  }

  //   algorithm, in java, to Find the first non-repeating character in a string, please do not
  // transform the characters into ASCII numeric values
  public Character firstNonRepeatingCharacter(String s) {
    if (s == null || s.isEmpty()) {
      return null; // or throw an exception based on your needs
    }

    Map<Character, Integer> charCounts = new HashMap<>();

    // Count the frequency of each character
    for (char c : s.toCharArray()) {
      charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
    }

    // Find the first non-repeating character
    for (char c : s.toCharArray()) {
      if (charCounts.get(c) == 1) {
        return c;
      }
    }

    return null; // No non-repeating character found
  }

  public static Character firstNonRepeatingCharacter2(String input) {
    if (input == null || input.isEmpty()) {
      return null;
    }

    // A standard Map to store character -> frequency
    Map<Character, Integer> counts = new HashMap<>();

    // 1. Manually count each character
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);

      if (counts.containsKey(c)) {
        // If we've seen it, get the current count and add 1
        int currentCount = counts.get(c);
        counts.put(c, currentCount + 1);
      } else {
        // If it's new, start the count at 1
        counts.put(c, 1);
      }
    }

    // 2. Re-scan the string from the beginning
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);

      // The first character we find with a count of 1 is our answer
      if (counts.get(c) == 1) {
        return c;
      }
    }

    return null; // No unique characters found
  }

  //   algorithm for Bubble Sort: Slow (O(n^2)). Good for explaining why nested loops are bad.
  public void bubbleSort(int[] arr) {
    if (arr == null || arr.length == 0) {
      return;
    }
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          // Swap arr[j] and arr[j+1]
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }

  public void sort(int[] arr, int left, int right) {
    if (left < right) {
      int mid = left + (right - left) / 2;

      // Divide: Recursively sort first and second halves
      sort(arr, left, mid);
      sort(arr, mid + 1, right);

      // Combine: Merge the sorted halves
      merge(arr, left, mid, right);
    }
  }

  private void merge(int[] arr, int left, int mid, int right) {
    // Create temp arrays
    int n1 = mid - left + 1;
    int n2 = right - mid;
    int[] L = new int[n1];
    int[] R = new int[n2];

    for (int i = 0; i < n1; ++i) L[i] = arr[left + i];
    for (int j = 0; j < n2; ++j) R[j] = arr[mid + 1 + j];

    // Merge the temp arrays
    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        arr[k] = L[i++];
      } else {
        arr[k] = R[j++];
      }
      k++;
    }
    // Copy remaining elements
    while (i < n1) arr[k++] = L[i++];
    while (j < n2) arr[k++] = R[j++];
  }

  //   Frequency Array/Map
  public int[] frequencyArray(int[] arr) {
    if (arr == null || arr.length == 0) {
      return new int[0];
    }
    int max = findMax(arr);
    int[] freq = new int[max + 1];
    for (int num : arr) {
      freq[num]++;
    }
    return freq;
  }
}
