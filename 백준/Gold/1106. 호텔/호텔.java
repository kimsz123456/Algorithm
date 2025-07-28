import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] hotels = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            hotels[i][0] = Integer.parseInt(st.nextToken());
            hotels[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[C+101];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;

        for(int i=0;i<N;i++){
            int cost = hotels[i][0];
            int people = hotels[i][1];
            for(int j = people; j<C+101; j++){
                if(dp[j- people]!=Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j- people]+cost,dp[j]);
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int i=C;i<C+101;i++){
            answer = Math.min(answer,dp[i]);
        }
        System.out.print(answer);
    }
}