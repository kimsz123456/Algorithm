import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int right = N-1;
        int sum;
        int result = Integer.MAX_VALUE;
        while(left<right) {
        	sum = arr[left]+arr[right];
        	
        	if(Math.abs(sum)<Math.abs(result)) {
        		result = sum;
        	}
            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(result);
    }
}