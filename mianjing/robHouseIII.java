import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*
 * Rob house, print out optimal positions
 * Valid input range [1, 10000)
 */
public class robHouseIII {
	public List<Integer> robHouse(int[] houses) {
		List<Integer> res = new ArrayList<>();
		if (houses == null || houses.length == 0) return res;
		int n = houses.length;
		
		int[] dp = new int[n+1];
		dp[1] = houses[0];
		for (int i = 2; i <= n; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2] + houses[i-1]);
		}
		int k = n;
		while (k > 0) {
			if (dp[k-1] < dp[k]) {
				res.add(k-1);
				k -= 2;
			} else {
				res.add(k-2);
				k -= 3;
			}
		}
		Collections.reverse(res);
		return res;
	}
	
	public static void main(String[] args) {
		robHouseIII app = new robHouseIII();
		int[] houses = {2, 2, 3, 2, 4, 5, 6, 7};
		List<Integer> res = app.robHouse(houses);
		System.out.println(Arrays.toString(res.toArray()));
	}
}
