import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[N+2];
        
        for(int day=1; day<=N; day++) {
            dp[day] = Math.max(dp[day], dp[day-1]);
            
            if(day + T[day] - 1 <= N) {
                int endDay = day + T[day];
                dp[endDay] = Math.max(dp[endDay], dp[day] + P[day]);
            }
        }
        
        dp[N+1] = Math.max(dp[N+1], dp[N]);
        
        System.out.println(dp[N+1]);
    }
}