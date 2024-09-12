import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] weight = new int[N];
		int[] value = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			for (int k = 0; k <= K; k++) {
				if (weight[i - 1] <= k) {
					dp[i][k] = Math.max(dp[i - 1][k], dp[i - 1][k - weight[i - 1]] + value[i - 1]);
				} else {
					dp[i][k] = dp[i - 1][k];
				}
			}
		}

		System.out.println(dp[N][K]);
	}
}