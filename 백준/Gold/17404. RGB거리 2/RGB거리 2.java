import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] cost = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = Integer.MAX_VALUE;

		for (int firstColor = 0; firstColor < 3; firstColor++) {
			int[][] dp = new int[N + 1][3];
			dp[1][firstColor] = cost[1][firstColor];

			for (int i = 0; i < 3; i++) {
				if (i == firstColor) {
					dp[1][firstColor] = cost[1][firstColor];
				} else {
					dp[1][i] = 123456789;
				}
			}

			for (int i = 2; i <= N; i++) {
				dp[i][0] = cost[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
				dp[i][1] = cost[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
				dp[i][2] = cost[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
			}

			for (int lastColor = 0; lastColor < 3; lastColor++) {
				if (lastColor != firstColor) {
					result = Math.min(result, dp[N][lastColor]);
				}
			}
		}

		System.out.println(result);
	}
}
