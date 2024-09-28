import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N =Integer.parseInt(br.readLine());
		
		if(N<5) {
            if(N==3) System.out.println(1);
            else System.out.println(-1);
            return;
        }
        int dp[] = new int[N+1];
        Arrays.fill(dp, 9999);
        dp[3] = 1;
        dp[5] = 1;
        for(int i=6; i<dp.length; i++) {
            dp[i] = Math.min(dp[i-3]+1, dp[i-5]+1);
        }
        if(dp[N] > 9999) {
            System.out.println(-1);
        }else {
            System.out.println(dp[N]);
        }
    }
}