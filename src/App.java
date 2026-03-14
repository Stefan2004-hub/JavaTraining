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
  }
}
