import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 자연수 N
			int K = Integer.parseInt(st.nextToken()); // 합 K
			
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			int[] sum = new int[1<<N];
			
			for (int i = 0; i < (1 << N); i++) {
				for(int j = 0 ; j<N; j++) {
					if((i & (1 << j)) > 0) {
						sum[i] +=arr[j];
					}
				}
			}
			int count =0;
			for(int i=0;i<(1<<N);i++) {
				if(sum[i]==K) {
					count++;
				}
			}
			System.out.println("#"+tc+" "+count);
		}
	}
}
