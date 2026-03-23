import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class App {
  private static final Logger logger = Logger.getLogger(App.class.getName());

  public static void main(String[] args) throws Exception {
    logger.info("Print target array");
    int[] arr = {2, 7, 11, 15};
    int target = 9;
    // int[] res = SumArrayTarget.twoSum(arr, target);
    int[] res = SumArrayTarget.twoSumHash(arr, target);
    logger.info(String.format("Target array is: %d, %d", res[0], res[1]));

    logger.info("Reversed string: " + Utils.reverseString("Hello, World!"));
    logger.info(
        "Count word occurences: "
            + Utils.countWordOccurences(
                new String[] {"apple", "banana", "apple", "orange"}, "apple"));
    logger.info(
        "Remove duplicates: "
            + Utils.removeDuplicates(List.of("apple", "banana", "apple", "orange")));

    // reservation system test
    // Example: 5 seats, 4 operations (Reserve, Reserve, Cancel seat 1, Reserve)
    int[] ops = {0, 0, 1, 0};
    int[] result = ReservationSystem.reserveSeats2(5, 4, ops);
    System.out.println(Arrays.toString(result)); // Expected: [1, 2, 1]

    // Test Case for CommentsCount
    String[] comments = {"bad_word_here", "this_is_Fine", "BAD_news", "no_bad_vibes"};
    String keyword = "bad";
    System.out.println(
        CommentsCount.countDerogatoryComments2(4, keyword, comments)); // Expected Output: 3

    // Test Case for BasicProblems
    BasicProblems bp = new BasicProblems();
    int[] nums = {2, 7, 11, 15};
    int targetSum = 9;
    int[] resultBasicProblems = bp.twoSum(nums, targetSum);
    System.out.println(Arrays.toString(resultBasicProblems)); // Expected: [0, 1]
  }
}
