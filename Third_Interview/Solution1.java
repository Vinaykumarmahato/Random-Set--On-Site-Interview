package First_Interview.Third_Interview;

public class Solution1 {
    public static int divide(int dividend, int divisor) {
        // Handle special cases
        if (divisor == 0)
            throw new ArithmeticException("Division by zero");
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        
        // Convert dividend and divisor to long to handle edge cases
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        
        // Determine the sign of the quotient
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        
        // Initialize the quotient
        int quotient = 0;
        
        // Perform division
        while (dvd >= dvs) {
            long temp = dvs;
            int multiple = 1;
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            dvd -= temp;
            quotient += multiple;
        }
        
        return sign * quotient;
    }

    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 3;
        int result = divide(dividend, divisor);
        System.out.println("Quotient: " + result);

        dividend = 7;
        divisor = -3;
        result = divide(dividend, divisor);
        System.out.println("Quotient: " + result);
    }
}
