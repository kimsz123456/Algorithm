import java.io.*;
import java.util.*;

public class Solution {
	static int N,M,K,result,cost,count;
	static boolean[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			

			map = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					if(Integer.parseInt(st.nextToken())==1) {
						map[i][j] = true;
					}
				}
			}
			int K = N+1;
			result = 0;
			while(result==0) {
				cost = (K*K)+(K-1)*(K-1);
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						result = Math.max(countHouse(i,j,K),result);
					}
				}
				K--;
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	static int countHouse(int r,int c, int K) {
		count=0;
		
		int num=0;
		for (int i = r-(K-1); i <= r+(K-1); i++) {
			for(int j = c-num;j<=c+num;j++) {
				if(i>=0 && i<N && j>=0 && j<N&&map[i][j]) {
					count++;
				}
			}
			if( i<r) {
				num++;
			}
			else {
				num--;
			}
		}
		if(cost<=count*M) {
			return count;
		}
		else {
			return 0;
		}
	}
}