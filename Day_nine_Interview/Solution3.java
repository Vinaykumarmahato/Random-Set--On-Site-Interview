package First_Interview.Day_nine_Interview;

public class Solution3 {

    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        for (int countA = 1; countA <= n / 2; countA++) {
            if (totalSum * countA % n == 0) {
                if (isPossible(nums, countA, totalSum * countA / n, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean isPossible(int[] nums, int count, int targetSum, int startIndex) {
        if (count == 0) {
            return targetSum == 0;
        }
        
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] <= targetSum) {
                if (isPossible(nums, count - 1, targetSum - nums[i], i + 1)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Can split array with same average: " + solution.splitArraySameAverage(nums1));
        
        int[] nums2 = {3, 1};
        System.out.println("Can split array with same average: " + solution.splitArraySameAverage(nums2));
    }
}