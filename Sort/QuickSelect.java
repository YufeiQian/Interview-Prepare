public class QuickSelect {
    public int findKthLargest(int[] nums, int k) {
        if (k > nums.length) return -1;
        return quickSelect(nums, nums.length - k, 0, nums.length - 1);
    }
    
    private int quickSelect(int[] nums, int k, int lo, int hi) {
        if (lo >= hi) return nums[lo];
        int i = lo, j = hi;
        int pivot = nums[hi];
        while (i < j) {
            if (pivot < nums[i++]) {
                swap(nums, --i, --j);
            }
        }
        swap(nums, i, hi);

        if (i == k) return pivot;
        else if (i < k) return quickSelect(nums, k, i + 1, hi);
        else return quickSelect(nums, k, lo, i - 1);
    }
    
    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}