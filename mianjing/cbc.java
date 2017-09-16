import java.util.HashMap;
import java.util.Map;
/*
 * Find minimum length after recursively removing 
 * first or last occurrence of pattern t from String s
 * Twitter
 */
public class cbc {
	public int findMinLeft(String s, String t) {
		// Check boundary condition
		if (s == null || t == null || s.length() == 0) return 0;
		if (t.length() == 0 || t.length() > s.length()) return s.length();

		return dfs(new HashMap<String, Integer>(), s, t);
	}
	
	private int dfs(Map<String, Integer> map, String s, String t) {
		// Result already computed
		if (map.containsKey(s)) return map.get(s);
		int m = t.length(), n = s.length();
		// Check boundary condition
		if (n == 0 || m > n) {
			map.put(s, n);
			return n;
		}
		// Init worst case, length left equals to len(s)
		int lenLeft = s.length();
		int firstIndex = s.indexOf(t);
		int lastIndex = s.lastIndexOf(t);
		// Removing first occurrence of String s
		if (firstIndex != -1) {
			String newString = s.substring(0, firstIndex) + s.substring(firstIndex + m, n);
			lenLeft = dfs(map, newString, t);
		}
		// Remove last occurrence of String s, skip if duplicated
		if (lastIndex != firstIndex) {
			String newString = s.substring(0, lastIndex) + s.substring(lastIndex + m, n);
			lenLeft = Math.min(lenLeft, dfs(map, newString, t));
		}
		// Add result to map
		map.put(s,  lenLeft);
		//System.out.println("String: " + s + " number left = " + lenLeft);
		return lenLeft;
	}
	
	public static void main(String[] args) {
		cbc solution = new cbc();
		System.out.println( solution.findMinLeft("cbcbcccbcbcc", "cbc") );
		System.out.println( solution.findMinLeft("cbcbcccbcbccbcc", "cbc") );
		System.out.println( solution.findMinLeft("cbcbcccbcbcccbcbcc", "cbc") );
		System.out.println( solution.findMinLeft("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "a") );
		System.out.println( solution.findMinLeft("a", "aaaa") );
		System.out.println( solution.findMinLeft("abcabcabcabcabc", "ab") );
		System.out.println( solution.findMinLeft("abcabcabcabcabc", "cd") );
		System.out.println( solution.findMinLeft(null, null) );
	}
}