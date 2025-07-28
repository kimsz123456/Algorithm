import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = stoi(br.readLine());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            nums[i] = stoi(st.nextToken());
        }

        boolean[][] dp = new boolean[N+1][N+1];
        for(int i=1;i<=N;i++){
            dp[i][i]=true;
        }
        for(int i=1;i<N;i++) {
            if (nums[i-1] == nums[i]) dp[i][i+1] = true;
        }

        for(int i=2;i<N;i++){
            for(int j=1;j<=N-i;j++){
                if(nums[j-1] == nums[j-1+i] && dp[j+1][j+i-1]) dp[j][j+i] = true;
            }
        }

        int M = stoi(br.readLine());

        int S,E;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            S = stoi(st.nextToken());
            E = stoi(st.nextToken());
            if(dp[S][E]) sb.append("1\n");
            else sb.append("0\n");
        }

        System.out.print(sb);
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }
}