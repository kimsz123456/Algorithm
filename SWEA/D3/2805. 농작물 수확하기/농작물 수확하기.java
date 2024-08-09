import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트케이스
		

		for (int tc = 1; tc <= T; tc++) { // 10개의 테스트케이스
			int N = Integer.parseInt(br.readLine()); // 농장의 크기
			int[][] arr = new int[N][N];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				String str = (br.readLine());
				for (int j = 0; j < N; j++) {
					if (i <= N / 2) {
						arr[i][j] = Integer.parseInt(str.valueOf(str.charAt(j)));
						if (j >= N / 2 - i && j <= N / 2 + i) {
						sum += arr[i][j];
						}
					}
					else {
						arr[i][j] = Integer.parseInt(str.valueOf(str.charAt(j)));
						if (j >= N / 2 - (N-i-1) && j <= N/2 + (N-i-1)) {
						sum += arr[i][j];
						}
					}
				}
			}
			System.out.println("#"+tc+" "+sum);
		}
	}
}
