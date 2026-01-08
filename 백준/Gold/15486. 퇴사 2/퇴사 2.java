import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        int[][] schedule = new int[N+2][2];
        for(int i=1; i<=N;i++) {
            schedule[i][0] = nextInt();
            schedule[i][1] = nextInt();
        }

        int[] dp = new int[N+2];
        int max = -1;
        for(int i=1; i<=N+1; i++) {
            max = Math.max(max, dp[i]);
            int next = i +schedule[i][0];
            if(next < N+2) {
                dp[next] = Math.max(dp[next], max+schedule[i][1]);
            }
        }
        System.out.println(dp[N+1]);
    }

    static int nextInt() throws IOException {
        int c;
        while (!Character.isDigit(c = System.in.read()));
        int value = c & 15;
        while (Character.isDigit(c = System.in.read())) {
            value = value * 10 + (c & 15);
        }
        return value;
    }
}