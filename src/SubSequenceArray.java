// Given two non-empty arrays of integers write a function that determines 
// wether the second array is a subsequence of the first one. 
// A subsequence of an array is a set of numbers that aren't necessarily adjacent in the array 
// but they are in the same order as they appear in the array. 
// For instance, the numbers [1, 3, 4] form a subsequence of the array [1, 2, 3, 4], and so do the numbers [2, 4]. 
// Note that a single number in an array and the array itself are both valid subsequences of the array.
// Sample input:
// Array = [5, 1, 22, 25, 6, -1, 8, 10]
// Sequence = [1, 6, -1, 10]
// Sample output= true
public class SubSequenceArray {
    public static boolean isValidSubsequence(int[] array, int[] sequence) {
        int seqIndex = 0;
        for (int num : array) {
        if (seqIndex == sequence.length) {
            break;
        }
        if (num == sequence[seqIndex]) {
            seqIndex++;
        }
        }
        return seqIndex == sequence.length;
    }
}
