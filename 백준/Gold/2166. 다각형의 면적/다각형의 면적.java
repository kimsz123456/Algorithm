import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        arr[N][0] = arr[0][0];
        arr[N][1] = arr[0][1];

        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += 1l*arr[i][0]*arr[i+1][1] - 1l*arr[i+1][0]*arr[i][1];
        }
        sum = Math.abs(sum);
        System.out.printf("%.1f", 1d*sum/2);
    }
}