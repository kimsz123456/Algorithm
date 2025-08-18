import java.io.*;
import java.util.*;

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
		
		int[] dp = new int[N];
		int max = arr[0];
		dp[0] = arr[0];
		for(int i=1;i<N;i++) {
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
			max = Math.max(dp[i], max);
		}
		System.out.print(max);
	}
}
