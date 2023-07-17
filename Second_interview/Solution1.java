package First_Interview.Second_interview;

public class Solution1 {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1; // Left shift result to make space for the next bit
            result = result | (n & 1); // Set the least significant bit of result with the current bit of n
            n = n >> 1; // Right shift n to get the next bit
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1(); // Create an instance of the Solution class
        int n = 43261596;
        System.out.println("Input: " + Integer.toBinaryString(n));
        int reversed = solution.reverseBits(n); // Call the reverseBits method using the instance
        System.out.println("Output: " + Integer.toBinaryString(reversed));
    }
}
