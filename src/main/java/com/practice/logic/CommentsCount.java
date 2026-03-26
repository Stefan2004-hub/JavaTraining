package com.practice.logic;

/**
 * Comment moderation counting helpers.
 */
public final class CommentsCount {

  private CommentsCount() {}

  /**
   * Counts comments containing a keyword as a case-insensitive substring.
   *
   * <p>Time Complexity: O(n * m), where n is number of comments and m average comment length
   *
   * <p>Space Complexity: O(1) excluding lowercase temporary strings
   *
   * @param keyword search keyword
   * @param comments input comments
   * @return number of comments that contain the keyword
   */
  public static int countDerogatoryComments(String keyword, String[] comments) {
    int count = 0;
    String normalizedKeyword = keyword.toLowerCase();
    for (String comment : comments) {
      if (comment.toLowerCase().contains(normalizedKeyword)) {
        count++;
      }
    }
    return count;
  }

  /**
   * Counts comments where underscore-separated words contain an exact keyword match
   * (case-insensitive).
   *
   * <p>Time Complexity: O(n * m), where n is number of processed comments and m average words
   *
   * <p>Space Complexity: O(m) due to split arrays
   *
   * @param n number of comments to process
   * @param keyword search keyword
   * @param comments input comments
   * @return number of comments containing the exact keyword token
   */
  public static int countDerogatoryComments2(int n, String keyword, String[] comments) {
    if (comments == null || n == 0 || keyword == null) {
      return 0;
    }

    int count = 0;
    String normalizedKeyword = keyword.toLowerCase();

    for (int i = 0; i < n; i++) {
      String currentComment = comments[i].toLowerCase();
      String[] words = currentComment.split("_");
      for (String word : words) {
        if (word.equals(normalizedKeyword)) {
          count++;
          break;
        }
      }
    }
    return count;
  }
}
