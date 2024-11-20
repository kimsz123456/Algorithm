import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 동전 배열
		int[] coin = new int[N];

		// 동전 입력
		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[K + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0]=0;
		for (int i = 0; i < N; i++) {
			for (int j = coin[i]; j <= K; j++) {
				if(dp[j-coin[i]]!=Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j - coin[i]] + 1,dp[j]);
				}
			}
		}
		int result = (dp[K]==Integer.MAX_VALUE) ? -1 : dp[K];
		System.out.println(result);
	}
}