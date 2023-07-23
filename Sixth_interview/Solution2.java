package First_Interview.Sixth_interview;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public int distributeCandies(int[] candyType) {
        int maxCandies = candyType.length / 2;
        Set<Integer> uniqueCandies = new HashSet<>();

        for (int candy : candyType) {
            uniqueCandies.add(candy);
        }

        return Math.min(uniqueCandies.size(), maxCandies);
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int[] candyType1 = { 1, 1, 2, 2, 3, 3 };
        int result1 = solution.distributeCandies(candyType1);
        System.out.println("Maximum number of unique candies for candyType1: " + result1);

        int[] candyType2 = { 1, 1, 2, 3 };
        int result2 = solution.distributeCandies(candyType2);
        System.out.println("Maximum number of unique candies for candyType2: " + result2);
    }
}
