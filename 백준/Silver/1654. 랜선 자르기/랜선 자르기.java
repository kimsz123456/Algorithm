import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		int max = 0;
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max,arr[i]);
		}
		
		long left = 1;
		long right = Integer.MAX_VALUE;
		long count,mid;
		while(left<=right) {
			mid = (left+right)/2;
			count=0;
			for(int i=0;i<N;i++) {
				count += arr[i]/mid;
			}
			if(count<M) {
				right=mid-1;
			}
			else {
				left=mid+1;
			}
		}
		System.out.println(right);
	}
}