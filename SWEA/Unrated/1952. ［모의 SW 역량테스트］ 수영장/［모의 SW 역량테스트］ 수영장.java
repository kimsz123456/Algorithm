import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int quarter = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            int[] plan = new int[12];
            st = new StringTokenizer(br.readLine());

            // 1일 이용권과 1달 이용권 비교
            for (int i = 0; i < 12; i++) {
                plan[i] = Math.min(Integer.parseInt(st.nextToken()) * day, month);
            }
            
            // 3달 이용권 최적화
            int[] dp = new int[12];
            dp[0] = plan[0];
            dp[1] = dp[0] + plan[1];
            dp[2] = Math.min(dp[1] + plan[2], quarter);
            for (int i = 3; i < 12; i++) {
                dp[i] = Math.min(dp[i-1] + plan[i], dp[i-3] + quarter);
            }

            int result = Math.min(dp[11], year);
            System.out.println("#" + tc + " " + result);
        }
    }
}