import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
        
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int arr[] = new int[n+1];
			int sum[] = new int[n+1];
			int dp[][] = new int[n+1][n+1];
			
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				sum[j] = sum[j-1] + arr[j];
			}
			
			for (int end = 2; end <= n; end++) {
				for (int start = end-1; start > 0; start--) {
					dp[start][end] = Integer.MAX_VALUE;
					for (int pass = start; pass < end; pass++) {
						dp[start][end] = Math.min(dp[start][end], dp[start][pass] + dp[pass+1][end]+ sum[end]-sum[start-1]);
					}
				}
			}
			sb.append(dp[1][n]).append("\n");
        }
		System.out.println(sb);
    }
}