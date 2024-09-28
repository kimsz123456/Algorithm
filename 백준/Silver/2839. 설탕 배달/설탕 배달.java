import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		
		
		int[] sugar = { 3, 5 };
		int dp[] = new int[N + 1];
		Arrays.fill(dp, -1);
		dp[0]=0;
		for (int i = 0; i < 2; i++) {
			for (int j = sugar[i]; j <= N; j++) {
				if (dp[j - sugar[i]] != -1) {
					dp[j] = dp[j - sugar[i]] + 1;
				}
			}
		}
		System.out.println(dp[N]);
	}
}