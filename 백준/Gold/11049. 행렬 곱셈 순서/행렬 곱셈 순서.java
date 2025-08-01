import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = stoi(br.readLine());
        int[][] dp = new int[N+1][N+1];

        int[][] matrix = new int[N+1][2];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = stoi(st.nextToken());
            matrix[i][1] = stoi(st.nextToken());
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i==j)
                    dp[i][j]=0;
                else
                    dp[i][j]=Integer.MAX_VALUE;
            }
        }

        for (int l = 2; l <= N; l++) {
            for (int i = 1; i + l - 1 <= N; i++) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + (matrix[i][0] * matrix[k][1] * matrix[j][1]);
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        System.out.print(dp[1][N]);
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }
}