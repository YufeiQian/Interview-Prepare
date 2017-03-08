import java.io.*;

public class QuickSort2 {
	private int partition(int[] a, int lo, int hi) {
		int i = lo, j = hi+1;
		int pivot = a[i];
		while (true) {
			while(a[++i] < pivot) if (i == hi) break;
			while(a[--j] > pivot) if (j == lo) break;
			if (i>= j) break;
			// Exchange value
			swap(a, i, j);					
		}
		swap(a, lo, j);
		return j;
	}
	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	public void sort(int[] a, int lo, int hi) {
		if (hi <= lo) return;
		int j = partition(a, lo, hi);
		if (j > lo) sort(a, lo, j-1);
		if (j < hi) sort(a, j+1, hi);
		return;
	}
	public static void main(String[] args) {
		int[] test1 = new int[]{10,9,8,7,6,5,4,3,2,1};
		int[] test2 = new int[]{2,2,3,4,5,7,1,2,5,11};
		int[] test3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] result1 = new int[]{1,2,3,4,5,6,7,8,9,10};
		int[] result2 = new int[]{1,2,2,2,3,4,5,5,7,11};
		int[] result3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		QuickSort2 q = new QuickSort2();
		// Use quicksort function here
		q.sort(test1, 0, test1.length - 1);
		q.sort(test2, 0, test2.length - 1);
		q.sort(test3, 0, test3.length - 1);
		q.printArray(test1);
		q.printArray(test2);
		q.printArray(test3);

		return;
	}
	public void printArray(int[] a) {
		for (int num : a) {
			System.out.print(num + " ");
		}
		System.out.println("");
	}	
}
