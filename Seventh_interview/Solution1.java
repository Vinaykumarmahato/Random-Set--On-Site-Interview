package First_Interview.Seventh_interview;

import java.util.*;

public class Solution1 {
    public int romanToInt(String s) {
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);
        
        int result = 0;
        int prevValue = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = romanValues.get(s.charAt(i));
            if (currentValue >= prevValue) {
                result += currentValue;
            } else {
                result -= currentValue;
            }
            prevValue = currentValue;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.romanToInt("III"));     // Output: 3
        System.out.println(solution.romanToInt("LVIII"));   // Output: 58
        System.out.println(solution.romanToInt("MCMXCIV")); // Output: 1994
    }
}