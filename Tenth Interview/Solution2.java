package First_Interview.Seventh_interview.Tenth_interview;

// This is the MountainArray's API interface.
// You should not implement it, or speculate about its implementation

public class Solution2 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peakIndex = findPeakIndex(mountainArr, 0, n - 1);

        // Search the left side of the peak
        int leftResult = binarySearchIncreasing(mountainArr, target, 0, peakIndex);
        if (leftResult != -1) return leftResult;

        // Search the right side of the peak
        int rightResult = binarySearchDecreasing(mountainArr, target, peakIndex, n - 1);
        return rightResult;
    }

    // Binary search to find the peak index
    private int findPeakIndex(MountainArray mountainArr, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // Binary search on the increasing side
    private int binarySearchIncreasing(MountainArray mountainArr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            if (midVal == target) return mid;
            if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Binary search on the decreasing side
    private int binarySearchDecreasing(MountainArray mountainArr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            if (midVal == target) return mid;
            if (midVal > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}