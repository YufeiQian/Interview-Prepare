import java.util.*;

/*
 * Input Array 1-N, count people after self
 * Input Array people after self, recover original array
 */
public class CountTree {
    private TreeNode root;
    
    public static int[] countPeopelAfterSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i <= n; i++) set.add(i);
        for (int i = 0; i < n; i++) {
            res[i] = set.headSet(nums[i]).size();
            set.remove(nums[i]);
        }
        return res;
    }
    
    public static int[] recoverPeoplePosition(int[] array) {
        int n = array.length;
        CountTree tree = new CountTree(n);
        int[] res = new int[n];
        
        for (int i = 0; i < n; i++) {
            res[i] = tree.findAndRemoveKthElement(array[i] + 1);
        }
        return res;
    }
    

    
    public CountTree(int size) {
        root = constructTree(1, size);
    }
    
    private TreeNode constructTree(int low, int high) {
        if (low > high) return null;
        if (low == high) return new TreeNode(low, 1);
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(mid, mid - low + 1);
        root.left = constructTree(low, mid - 1);
        root.right = constructTree(mid + 1, high);
        return root;
    }
    
    private void printTree(TreeNode root) {
        if (root == null) {
            System.out.print("#!");
            return;
        }
        printTree(root.left);
        System.out.print(root.val+ " : " + root.count + " !");
        printTree(root.right); 
    }
    

    
    public int findAndRemoveKthElement(int k) {
        int val = findKthElement(root, k);
        this.root = removeElement(this.root, val);
        return val;
    }

    private int findKthElement(TreeNode node, int k) {
        if (node == null) {
            System.out.println("Unable to find Node " + k);
            return 0;
        }
        if (k == node.count) return node.val;
        else if (k < node.count) return findKthElement(node.left, k);
        else return findKthElement(node.right, k - node.count);
    }
    
    private TreeNode removeElement(TreeNode root, int n) {
        if (root == null) return null;
        if (n > root.val) root.right = removeElement(root.right, n);
        else if (n < root.val) {
            root.left = removeElement(root.left, n);
            root.count--;
        }
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode parent = null, newRoot = root.left;
            while (newRoot.right != null) {
                parent = newRoot;
                newRoot = newRoot.right;
            }
            if (parent == null) {
                newRoot.right = root.right;
            } else {
                parent.right = newRoot.left;
                newRoot.left = root.left;
                newRoot.right = root.right;
                newRoot.count = root.count - 1;
            }
            return newRoot;
        }
        return root;
    }
    
    public static class TreeNode {
        public int val;
        public int count;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
    
    public static void main(String[] args) {
        int[] a = {7,5,4,3,1,2,6};
        int[] position = countPeopelAfterSelf(a);
        System.out.println(Arrays.toString(position));
        System.out.println(Arrays.toString(recoverPeoplePosition(position)));
    }   

}