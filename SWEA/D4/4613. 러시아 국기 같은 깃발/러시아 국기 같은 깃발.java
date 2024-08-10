import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken()); // N개의 줄
			int M = Integer.parseInt(st.nextToken()); // M개의 숫자

			Character[][] arr = new Character[N][M];

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			int cntW = 0; // W칠하는 갯수
			int cntB = 0; // B칠하는 갯수
			int cntR = 0; // R칠하는 갯수
			int result = N*M;
			for (int i = 0; i < N - 2; i++) {
				// 반복될때 cntW는 누적
				cntR = 0; // cntR 는 0으로 초기화
				
				// W개수 카운트
				for (int j = 0; j < M; j++) {
					if (arr[i][j] != 'W') {
						cntW++; 
					}
				}
				// R을 뒤부터 늘려나가며 센다.
				// N-1부터, i+2까지 반복
				for (int k = N - 1; k >= i + 2; k--) {
					cntB = 0; // cntB 는 0으로 초기화
					
					// R개수 카운트
					for (int j = 0; j < M; j++) {
						if (arr[k][j] != 'R') {
							cntR++;
						}
					}
					// k-1 부터 i+1까지
					for (int l = k - 1; l >= i+1; l--) {
						
						// B개수 카운트
						for (int j = 0; j < M; j++) {
							if (arr[l][j] != 'B') {
								cntB++;
							}
						}
					}
					result = Math.min(cntW+cntB+cntR,result);
				}
			}
			System.out.println("#"+tc+" "+result);
		}
	}
}