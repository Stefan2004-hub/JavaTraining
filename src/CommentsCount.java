public class CommentsCount {
  // Problem 2: a new video about recent developments in coding has been published on the social
  // media handle.
  // After some time it is seen that there are N comments added.
  // The admin wants to see if there are any derogatory comments.
  // Hence he searched the comment section with a key word S.
  // Give the count of the comments that will be returned as a result of the search.
  // The count can be 0, the algorithm searches the keyword irrespective of the case of the word.
  // The separator here is _. The function(static int solution) takes 3 parameters
  // and returns the solution. int N represents the number of comments,
  // String S represents the key word String[] comments represents the array of comments

  public static int countDerogatoryComments(int N, String S, String[] comments) {
    int count = 0;
    S = S.toLowerCase();
    for (String comment : comments) {
      if (comment.toLowerCase().contains(S)) {
        count++;
      }
    }
    return count;
  }

  static int countDerogatoryComments2(int N, String S, String[] comments) {
    if (comments == null || N == 0 || S == null) {
      return 0;
    }

    int count = 0;
    // Convert keyword to lowercase for case-insensitive comparison
    String keyword = S.toLowerCase();

    for (int i = 0; i < N; i++) {
      // 1. Convert the entire comment to lowercase
      String currentComment = comments[i].toLowerCase();

      // 2. Split the comment into words based on the underscore '_'
      // We use "\\" to escape in regex if needed, but for a single char split works fine
      String[] words = currentComment.split("_");

      // 3. Check if any word in the comment matches the keyword exactly
      for (String word : words) {
        if (word.equals(keyword)) {
          count++;
          // We break here because the question asks for the count of COMMENTS
          // that contain the word, not how many times the word appears total.
          break;
        }
      }
    }

    return count;
  }
}
