import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 재료의 수
			int L = Integer.parseInt(st.nextToken()); // 칼로리 제한
			
			int[] score = new int[N];
			int[] cal = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			int[] resultscore = new int[1<<N];
			int[] resultcal = new int[1<<N];
			for(int i =0; i<(1 << N);i++) {
				for(int j = 0 ; j<N; j++) {
					if((i & (1 << j)) > 0) {
						resultscore[i]+=score[j];
						resultcal[i]+=cal[j];
					}
				}
			}
			
			int max = 0;
			for(int i=0;i<(1<<N);i++) {
				if(resultcal[i]<=L) {
					max = Math.max(resultscore[i], max);
				}
			}
			System.out.println("#"+tc+" "+max);
		}
	}
}
