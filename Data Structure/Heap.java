public class Heap
{
  public static void buildHeap(int[] a) {
  	int last_tree_node = (a.length - 1 - 1) / 2;
    for (int i=last_tree_node; i>=0; i--){
    	heapify(a, i);
    }
  }
  
  public static void heapify(int[] a, int k) {
  	int lt_index = k*2 + 1;
    int rt_index = k*2 + 2;
    int lt_val = Integer.MIN_VALUE;
    int rt_val = Integer.MIN_VALUE;
    if (lt_index < a.length) { lt_val = a[lt_index]; }
    if (rt_index < a.length) { rt_val = a[rt_index]; }
    if (lt_val > a[k] && lt_val > rt_val) {
      Heap.swap(a, k, lt_index);
      heapify(a, lt_index);
    } else if (a[k] < rt_val && lt_val < rt_val) {
      Heap.swap(a, k, rt_index);
      heapify(a, rt_index);
    }
    return;
  }
  
  public static void swap(int[] a, int i, int j){
  	int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
