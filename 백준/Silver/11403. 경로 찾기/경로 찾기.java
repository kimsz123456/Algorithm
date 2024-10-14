import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N][N];
        
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
        		arr[i][j]= Integer.parseInt(st.nextToken());
        	}
        }
        
        
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][k] ==1  && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }
                }
            }
        }
        
        for(int i=0;i<N;i++) {
        	for(int j=0;j<N;j++) {
        		sb.append(arr[i][j]).append(" ");
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
	}
}