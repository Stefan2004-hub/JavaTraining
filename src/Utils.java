import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {
  public static String reverseString(String str) {
    StringBuilder reversed = new StringBuilder();
    for (int i = str.length() - 1; i >= 0; i--) {
      reversed.append(str.charAt(i));
    }
    return reversed.toString();
  }

  // count how mmany times a word exists in a list of words
  public static int countWordOccurences(String[] words, String wordToCount) {
    int count = 0;
    for (String word : words) {
      if (word.equals(wordToCount)) {
        count++;
      }
    }
    return count;
  }

  // remove duplicates from a list
  public static List<String> removeDuplicates(List<String> list) {
    Set<String> seen = new HashSet<>();
    List<String> result = new ArrayList<>();
    for (String item : list) {
      //   if (!seen.contains(item)) {
      //     seen.add(item);
      //     result.add(item);
      //   }
      seen.add(item);
    }
    for (String item : seen) {
      result.add(item);
    }
    return result;
  }

  public static Set<String> removeDuplicatesSet(List<String> list) {
    return new HashSet<>(list);
  }
}
//test push git