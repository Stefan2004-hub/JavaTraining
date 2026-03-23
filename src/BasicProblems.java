import java.util.HashMap;
import java.util.Map;

public class BasicProblems {
//     Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
        throw new IllegalArgumentException("Input array must have at least two elements");
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[]{map.get(complement), i};
        }
        map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution found");
    }
}
