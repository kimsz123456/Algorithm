import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int[] coin = {1,2,3};
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++){
        	int N = Integer.parseInt(br.readLine());
        	int[] dp = new int[N+1];
        	dp[0]=1;
        	
        	for(int i=0;i<coin.length;i++) {
        		for(int j=coin[i];j<=N;j++) {
        			dp[j]+=dp[j-coin[i]];
        		}
        	}
        	
        	sb.append(dp[N]).append("\n");
        }
        System.out.println(sb);
    }
}