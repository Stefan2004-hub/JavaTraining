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

    // Given an integer x, return true if x is a palindrome, and false otherwise.
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false; // Negative numbers are not palindromes
        }
        String str = Integer.toString(x);
        String reversedStr = new StringBuilder(str).reverse().toString();
        return str.equals(reversedStr);
    }

        public boolean isPalindrome2(int x) {
        String str = Integer.toString(x);
        int right = str.length() - 1;
        int left = 0;
        for (char s : str.toCharArray()){
            if (s != str.charAt(right)) {
                return false;
            }
            right--;
            left++;
            if (right == left) break;
        }
        return true;
    }
}
