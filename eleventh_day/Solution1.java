import java.util.Arrays;

public class Solution1 {

    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] result = new int[n];
        
        // Find the closest occurrence of character c on the left side
        int prev = -n;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            result[i] = i - prev;
        }
        
        // Find the closest occurrence of character c on the right side
        prev = 2 * n;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            result[i] = Math.min(result[i], prev - i);
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        
        String s1 = "loveleetcode";
        char c1 = 'e';
        int[] result1 = solution.shortestToChar(s1, c1);
        System.out.println(Arrays.toString(result1));
        
        String s2 = "aaab";
        char c2 = 'b';
        int[] result2 = solution.shortestToChar(s2, c2);
        System.out.println(Arrays.toString(result2));
    }
}