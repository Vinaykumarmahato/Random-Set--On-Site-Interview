package First_Interview.Fourth_interview;

class Solution {
    public int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int prev1 = 0;
        int prev2 = 1;
        int curr = 0;

        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev1 = prev2;
            prev2 = curr;
        }

        return curr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 10;
        int result = solution.fib(n);
        System.out.println("The Fibonacci number at position " + n + " is: " + result);
    }
}
