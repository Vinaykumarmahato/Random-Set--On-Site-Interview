package First_Interview.Sixth_interview;

public class Solution1 {
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
        Solution1 solution = new Solution1();

        int n1 = 5;
        int result1 = solution.fib(n1);
        System.out.println("Fibonacci number for n=" + n1 + ": " + result1);

        int n2 = 10;
        int result2 = solution.fib(n2);
        System.out.println("Fibonacci number for n=" + n2 + ": " + result2);
    }
}
