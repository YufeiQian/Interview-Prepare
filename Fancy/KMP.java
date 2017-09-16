import java.util.Arrays;

public class KMP {
	public static int[] getNext(String s) {
		if (s == null || s.length() == 0) return null;
		int n = s.length();
		int[] p = new int[n];
		
		for (int j  = 1; j < n; j++) {
			int i = p[j-1];
			while(s.charAt(i) != s.charAt(j) && i != 0) {
				i = p[i-1];
			}
			if (s.charAt(i) == s.charAt(j)) {
				p[j] = 1 + i;
			}
		}
		
		return p;
	}
	
	public static boolean kmp(String s, String p) {
		int[] next = getNext(p);
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			while(j != 0 && p.charAt(j) != s.charAt(i)) {
				j = next[j-1];
			}
			if(s.charAt(i) == p.charAt(j)) {
				j++;
				//System.out.print(j + " ");
			}
			if (j == p.length()) return true;
		}
		return false;
	}
	
	public static void main(String args[]) {
		String s = "abcxabcdabxabcdabcdabcy";
		String p = "abcdabcy";
		int[] next = getNext(p);
		boolean res = kmp(s, p);
		System.out.println();
		System.out.println(Arrays.toString(next));
		System.out.println(res);
	}
	
}
