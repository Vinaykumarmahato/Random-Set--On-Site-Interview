package First_Interview.Seventh_interview.Tenth_interview;

public class Solution1 {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] < arr[mid + 1]) {
                // The peak is to the right of mid
                left = mid + 1;
            } else {
                // The peak is to the left of mid (or at mid)
                right = mid;
            }
        }
        
        return left; // Index of the peak element
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] arr1 = {0, 1, 0};
        System.out.println("Output 1: " + solution.peakIndexInMountainArray(arr1)); // Output: 1
        
        int[] arr2 = {0, 2, 1, 0};
        System.out.println("Output 2: " + solution.peakIndexInMountainArray(arr2)); // Output: 1
        
        int[] arr3 = {0, 10, 5, 2};
        System.out.println("Output 3: " + solution.peakIndexInMountainArray(arr3)); // Output: 1
    }
}
