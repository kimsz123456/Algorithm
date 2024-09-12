import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력받기

        // 각 테스트 케이스마다 처리
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 재료의 수
            int L = Integer.parseInt(st.nextToken()); // 제한 칼로리
            
            int[] taste = new int[N];
            int[] calorie = new int[N];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                taste[i] = Integer.parseInt(st.nextToken());
                calorie[i] = Integer.parseInt(st.nextToken());
            }
            
            int[][] dp = new int[N + 1][L + 1]; // i번째 물건까지 고려할거야
            
            for(int i = 1; i <= N; i++) {
                for(int l = 0; l <= L; l++) {
                    if(calorie[i - 1] <= l) {
                        dp[i][l] = Math.max(dp[i - 1][l], dp[i - 1][l - calorie[i - 1]] + taste[i - 1]);
                    } else {
                        dp[i][l] = dp[i - 1][l];
                    }
                }
            }
            
            System.out.println("#"+tc+" "+dp[N][L]);
        }
    }
}