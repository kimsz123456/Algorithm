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
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		long left = 0;
		long right = 0;
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			if(num>right) {
				right = num;
			}
		}
		
		long result=0;
		while(left<=right) {
			long mid = (left+right) >>1;
			long sum =0;
			for (int i = 0; i < N; i++) {
                sum += Math.max(0, arr[i] - mid);
            }
			if(sum>=M) {
				result = mid;
				left = mid+1;
			}
			else{
				right = mid-1;
			}
		}
		System.out.println(result);
	}
}