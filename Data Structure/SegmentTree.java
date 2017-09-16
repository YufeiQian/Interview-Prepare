package sort;

import java.util.ArrayList;
import java.util.Arrays;

public class SegmentTree {
	int[] tree;
	public int solution(int[] nums, int start, int end) {
		if (nums == null || nums.length == 0) return 0;
		int res = minQuery(tree, start, end, 0, nums.length - 1, 0);
		return res;
	}
	
	private SegmentTree(int[] nums) {
		int n = 1;
		// Next power of 2
		while (n < nums.length) n <<= 1;
		tree = new int[(n << 1) - 1];
		Arrays.fill(tree, Integer.MAX_VALUE);
		constructTree(tree, nums, 0);		
		System.out.println(Arrays.toString(tree));
	}
	
	private int minQuery(int[] tree, int startIndex, int endIndex, int low, int high, int pos) {
		if (low > high) return Integer.MAX_VALUE;
		if (startIndex <= low && endIndex >= high) {
			return tree[pos];
		} else if (startIndex > high || endIndex < low) {
			return Integer.MAX_VALUE;
		} else {
			int mid = low + (high - low) / 2;
			
			int val = Math.min(minQuery(tree, startIndex, endIndex, low, mid, pos * 2 + 1), minQuery(tree, startIndex, endIndex, mid + 1, high, pos * 2 + 2));
			return val;
		}
	}
	
	private int constructTree(int[] tree, int[] nums, int index) {
		if (index >= tree.length / 2) {
			tree[index] = nums[index - tree.length / 2];
		} else {
			tree[index] = Math.min(constructTree(tree, nums, index * 2 + 1), constructTree(tree, nums, index * 2 + 2));
		}
		return tree[index];
	}
	
	public static void main(String[] args) {
		int[] a = {1, -2, 3, 5, -2, 7, 8, 0};
		SegmentTree ST = new SegmentTree(a);
		System.out.println(ST.solution(a,  3,  6));
	}
}
