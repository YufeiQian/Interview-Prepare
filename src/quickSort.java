class quickSort {

	public void quicksort(int[] a, int left, int right) {
		if (a.length == 0) return;
		int pivot = a[left];
		int i = left, j = right;
		while (i < j) {
			while (a[i] < pivot) {
				i++;
			}
			while (a[j] > pivot) {
				j--;
			}
			if (i < j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
			i++;
			j--;
			if (i < right) {
				quicksort(a, i, right);
			}
			if (j > left) {
				quicksort(a, left, j);
			}
		}
	}
	public static void main(String[] args) {
		int[] test1 = new int[]{10,9,8,7,6,5,4,3,2,1};
		int[] test2 = new int[]{2,2,3,4,5,7,1,2,5,11};
		int[] test3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] result1 = new int[]{1,2,3,4,5,6,7,8,9,10};
		int[] result2 = new int[]{1,2,2,2,3,4,5,5,7,11};
		int[] result3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		quickSort q = new quickSort();
		// Use quicksort function here
		q.quicksort(test1, 0, test1.length - 1);
		q.quicksort(test2, 0, test2.length - 1);
		q.printArray(test1);
		q.printArray(test2);
		q.printArray(test3);

		q.compare(test1, result1);
		q.compare(test2, result2);
		return;
	}
	public boolean compare(int[] a, int[] b) {
		for (int i=0; i < a.length; i++) {
			assert(a[i] == b[i]);
		}
		return true;
	}
	public void printArray(int[] a) {
		for (int num : a) {
			System.out.print(num + " ");
		}
		System.out.println("");
	}
}