import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int N =Integer.parseInt(br.readLine());
			
			// 동전 배열
			int[] coin = new int[N];
			
			// 동전 입력
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				coin[i] = Integer.parseInt(st.nextToken());
			}
			
			// 목표 금액
			int M = Integer.parseInt(br.readLine());
			
			int[] dp = new int[M + 1];
            dp[0] = 1;
            
            for(int i=0;i<N;i++) {
            	for(int j=coin[i];j<=M;j++) {
            		dp[j] += dp[j-coin[i]];
            	}
            }
            System.out.println(dp[M]);
		}
		
	}
}