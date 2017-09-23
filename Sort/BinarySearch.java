package sort;

import java.util.Arrays;

public class BinarySearch {
	// Collection.binarySearch()
	// Arrays.binarySearch() does not guarantee the target place (first or last)
	// Besides, if target is not found, return - (index + 1), where nums[index] is the first element > target
	public int binarySearch(int[] nums, int target) {
		Arrays.sort(nums);
		// Assume nums is sorted
		int n = nums.length;
		int lo = 0, hi = n - 1;
		while (lo <= hi) {
			// Only apply when (lo + hi) > 0
			int mid = (lo + hi) >>> 1;
			// hi -> last occurence  of x < target
			if (nums[mid] >= target) hi = mid - 1;
			// lo -> first occurance of x >= target
			else lo = mid + 1;
			// hi -> last occurence of x <= target
			// if (nums[mid] > target) hi = mid - 1;
			// lo -> first occurence of x > target
			// else lo = mid + 1;
		}
		return lo;
	}
	
	public static void main(String[] args) {
		int lo = -5;
		int hi = -10;
		int mid = (lo + hi) >>> 1;
		int[] A = {1, 2, 2, 2, 2, 3};
		System.out.println(Arrays.binarySearch(A, 2));
	}
}
