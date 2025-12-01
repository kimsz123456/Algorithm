import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N%2==1) {
            System.out.print(0);
            return;
        }

        int[] dp = new int[N + 1];
        dp[2] = 3;
        for(int i=4;i<=N;i+=2){
            dp[i] = dp[i-2]* dp[2] + 2;
            for(int j=i-2;j>=4;j-=2){
                dp[i] += dp[i-j]*2;
            }
        }
        System.out.print(dp[N]);
    }

}
