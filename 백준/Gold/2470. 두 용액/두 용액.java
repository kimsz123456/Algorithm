import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        int left = 0;
        int right = N-1;
        
        int resultL=0;
        int resultR=0;
        
        int sum = 0;
        int summin = Integer.MAX_VALUE;
        while(left<right) {
        	sum = arr[left]+arr[right];
        	if(Math.abs(sum)<summin) {
        		summin=Math.abs(sum);
        		resultL=arr[left];
        		resultR=arr[right];
        	}
        	if(sum>0) {
        		right--;
        	}
        	else {
        		left++;
        	}
        }
        sb.append(resultL).append(" ").append(resultR);
        System.out.println(sb);
    }
}