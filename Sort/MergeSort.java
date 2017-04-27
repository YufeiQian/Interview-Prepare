import java.util.*;

class MergeSort {

	public static void mergesort(int[] nums) {
		if (nums == null || nums.length == 0) return;
		int[] a = new int[nums.length];
		sort(nums, a, 0, nums.length - 1);
	}

	public static void sort(int[] nums, int[] a, int start, int end) {
		if (start >= end) return;
		int mid = start + (end - start)/2;
		sort(nums, a, start, mid);
		sort(nums, a, mid + 1, end);
		merge(nums, a, start, mid, end);
		System.out.println(Arrays.toString(nums));
	}
	public static void merge(int[] nums, int[] a, int start, int mid, int end) {
		// Copy the array
		for (int k = start; k <= end; k++) {
			a[k] = nums[k];
		}
		int i = start, j = mid + 1;
		for (int k = start; k < end; k++) {
			if (i > mid) 			nums[k] = a[j++];
			else if (j > end) 		nums[k] = a[i++];
			else if (a[i] > a[j]) 	nums[k] = a[j++];
			else 					nums[k] = a[i++];
		}
	}




	public static void main(String[] args) {
		int[] nums = {4,5,3,2,8,98,7,6,2,34,45,32,12,45,65,3,-2,-1,0,-98};
		mergesort(nums);
		System.out.println(Arrays.toString(nums));
	}
}