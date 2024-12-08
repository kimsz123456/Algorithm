import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        int resultA = 0, resultB = 0, resultC = 0;
        long summin = Long.MAX_VALUE;
        
        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;
            
            while (left < right) {
                long sum = (long) arr[i] + arr[left] + arr[right];
                
                if (Math.abs(sum) < summin) {
                    summin = Math.abs(sum);
                    resultA = arr[i];
                    resultB = arr[left];
                    resultC = arr[right];
                }
                
                if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        sb.append(resultA).append(" ").append(resultB).append(" ").append(resultC);
        System.out.println(sb);
    }
}
