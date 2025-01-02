import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        
        int[] A = new int[H + 1];  
        int[] B = new int[H + 1];  
  
        for (int i = 0; i < N; i++) {
        	int num = Integer.parseInt(br.readLine());
        	if(i%2==0) {
        		A[num]++;
        	}
        	else {
        		B[num]++;
        	}
        }  
  
        for (int h = H - 1; 0 < h; h--) {  
            A[h] += A[h + 1];  
            B[h] += B[h + 1];  
        }  
  
        int count = 0;  
        int min = N;  
  
        for (int h = H; 0 < h; h--) {  
            if (A[h] + B[H - h + 1] < min) {  
                count = 1;  
                min = A[h] + B[H - h + 1];  
            } else if (A[h] + B[H - h + 1] == min) {  
                count++;  
            }  
        }
        sb.append(min).append(" ").append(count);
        System.out.print(sb);  
    }
}