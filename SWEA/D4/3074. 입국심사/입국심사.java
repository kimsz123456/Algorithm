import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] table = new int[N];
            long maxTime = 0;
            for (int i = 0; i < N; i++) {
                table[i] = Integer.parseInt(br.readLine());
                maxTime = Math.max(maxTime, table[i]);
            }
			
			long left = 0;
			long right = maxTime*M;
			
			long result = maxTime*M;
			while(left<=right) {
				long sum = 0;
				long mid = (left+right)/2;
				
				for(int i=0;i<N;i++) {
					sum += mid/table[i];
				}
				if(sum>=M) {
					result = Math.min(mid,result);
					right = mid-1;
				}
				else {
					left = mid+1;
				}
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
