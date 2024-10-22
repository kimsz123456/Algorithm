import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		int[][] tri = new int[N][N];
		int[][] dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i + 1; j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = tri[0][0];
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i + 1; j++) {
				if(j==0) {
					dp[i][j] = dp[i - 1][j]+tri[i][j];
				}
				else {
					dp[i][j] = Math.max(dp[i - 1][j-1], dp[i - 1][j])+tri[i][j];
				}
			}
		}
		int result = 0;
		for (int i = 0; i < N; i++) {
			result = Math.max(result, dp[N-1][i]);
		}
		System.out.println(result);
	}

}