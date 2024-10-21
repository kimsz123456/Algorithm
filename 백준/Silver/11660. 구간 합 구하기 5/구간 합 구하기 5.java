import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N + 1][N + 1];
        int[][] sumArr = new int[N + 1][N + 1];
        
        // 배열 입력 및 누적합 배열 생성
        int sum=0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                sumArr[i][j] = arr[i][j] 
                             + sumArr[i - 1][j] 
                             + sumArr[i][j - 1] 
                             - sumArr[i - 1][j - 1];
            }
        }
        // 쿼리 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int xOne = Integer.parseInt(st.nextToken());
            int yOne = Integer.parseInt(st.nextToken());
            int xTwo = Integer.parseInt(st.nextToken());
            int yTwo = Integer.parseInt(st.nextToken());
            
            int result = sumArr[xTwo][yTwo]
                       - sumArr[xOne - 1][yTwo]
                       - sumArr[xTwo][yOne - 1]
                       + sumArr[xOne - 1][yOne - 1];
            
            sb.append(result).append("\n");
        }
        
        System.out.println(sb);
    }
}
