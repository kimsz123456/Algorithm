import java.io.*;
import java.util.*;

public class Main {
	static int[][] dp = new int[41][2];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<=40;i++) {
			Arrays.fill(dp[i], -1);
		}
		dp[0][0]=1;
		dp[0][1]=0;
		dp[1][0]=0;
		dp[1][1]=1;
		
		for(int i=0;i<N;i++) {
			int[] arr = fibo(Integer.parseInt(br.readLine()));
			sb.append(arr[0]).append(" ").append(arr[1]).append("\n");
		}
		System.out.println(sb);
	}
	
	static int[] fibo(int n) {
		if( dp[n][0]==-1 || dp[n][1]==-1) {
				dp[n][0]= fibo(n-1)[0]+fibo(n-2)[0];
				dp[n][1]= fibo(n-1)[1]+fibo(n-2)[1];
		}
		return dp[n];
	}
}