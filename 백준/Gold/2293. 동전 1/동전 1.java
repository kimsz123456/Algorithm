import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] coin = new int[N];
        int[] dp = new int[K+1];
        
        for(int i=0;i<N;i++) {
        	coin[i]= Integer.parseInt(br.readLine());
        }
        
        dp[0]=1;
        for(int i=0;i<N;i++) {
        	for(int j=coin[i];j<=K;j++) {
        		dp[j]+=dp[j-coin[i]];
        	}
        }
        
        System.out.println(dp[K]);
    }
}
