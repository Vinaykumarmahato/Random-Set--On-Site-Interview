package First_Interview.Fourth_interview;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int distributeCandies(int[] candyType) {
        int maxCandies = candyType.length / 2;
        Set<Integer> uniqueCandies = new HashSet<>();

        for (int candy : candyType) {
            uniqueCandies.add(candy);
        }

        return Math.min(uniqueCandies.size(), maxCandies);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candyType = {1, 1, 2, 2, 3, 3};
        int maxUniqueCandies = solution.distributeCandies(candyType);
        System.out.println("The maximum number of unique candies that can be distributed is: " + maxUniqueCandies);
    }
}

