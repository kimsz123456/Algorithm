import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[1001];
        
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        
        for(int i=3;i<=N;i++) {
        	dp[i] = (dp[i-1]+dp[i-2]) % 10007;
        }
        
        System.out.println(dp[N]);
    }
}