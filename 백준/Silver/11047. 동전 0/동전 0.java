import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] coin = new int[N];
        
        for(int i=0;i<N;i++) {
        	coin[i] = Integer.parseInt(br.readLine());
        }
        
        int[] dp = new int[K+1];
        
        dp[0]=0;
        
        for(int i=0;i<N;i++) {
        	for(int j=coin[i];j<=K;j++) {
        		dp[j]=dp[j-coin[i]]+1;
        	}
        }
        System.out.println(dp[K]);
    }
}
