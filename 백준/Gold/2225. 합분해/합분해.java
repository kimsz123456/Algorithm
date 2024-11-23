import java.io.*;
import java.util.*;

public class Main {
	static final int MOD = 1000000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		System.out.println(combination(N,K)%MOD);
	}

    public static long combination(int n, int k) {

    	long[][] dp = new long[n + k][k + 1];
        
        for (int i = 0; i < n + k; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < n + k; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j] % MOD;
            }
        }

        return dp[n + k - 1][k - 1];
    }
}