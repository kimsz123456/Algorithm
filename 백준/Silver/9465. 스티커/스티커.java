import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N =Integer.parseInt(br.readLine());
			
			int[][] sticker = new int [2][N+1];
			int[][] dp = new int[2][N+1];
			
			for(int i=0;i<2;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1;j<=N;j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dp[0][1] = sticker[0][1];
			dp[1][1] = sticker[1][1];
			
			for(int i=2;i<=N;i++) {
				dp[0][i]+=Math.max(dp[1][i-1],dp[1][i-2])+sticker[0][i];
				dp[1][i]+=Math.max(dp[0][i-1],dp[0][i-2])+sticker[1][i];
			}
			sb.append(Math.max(dp[0][N],dp[1][N])).append("\n");
		}
		System.out.println(sb);
	}
}