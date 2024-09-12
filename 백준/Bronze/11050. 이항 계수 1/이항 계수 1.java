import java.util.*;
import java.io.*;

public class Main {
	static int[][] dp;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		dp = new int[N + 1][K + 1];
		
		System.out.println(BC(N,K));
	}

	static int BC(int N, int K) {
		if (dp[N][K] > 0) {
			return dp[N][K];
		}
		if (N == K || K == 0) {
			return dp[N][K] = 1;
		}
		return dp[N][K] = BC(N - 1, K - 1) + BC(N - 1, K);
	}
}
