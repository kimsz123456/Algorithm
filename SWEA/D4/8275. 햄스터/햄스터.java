import java.util.*;
import java.io.*;

public class Solution {
	static int N, X, M,max;
	static int[] ham;
	static int[][] record;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken()); // 우리의 수
			X = Integer.parseInt(st.nextToken()); // 최대 햄스터

			ham = new int[N + 1];
			result = new int[N + 1];
			result[1] = -1;

			M = Integer.parseInt(st.nextToken()); // 경근이의 기록

			record = new int[M][3];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int l = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				record[i][0] = l;
				record[i][1] = r;
				record[i][2] = s;
			}
			
			max = Integer.MIN_VALUE;
			
			comb(1, 0);
			sb.append("#").append(tc);
			if (result[1] == -1) {
				sb.append(" ").append(-1);
			} else {

				for (int i = 1; i <= N; i++) {
					sb.append(" ").append(result[i]);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void comb(int idx, int count) {
		if (count == N) {
			int hamsum = 0;
			for (int i = 1; i <= N; i++) {
				hamsum += ham[i];
			}
			for (int i = 0; i < M; i++) {
				int sum = 0;
				for (int num = record[i][0]; num <= record[i][1]; num++) {
					sum += ham[num];
				}
				if (sum != record[i][2]) {
					return;
				}
			}
			if (hamsum > max) {
				result = ham.clone();
				max = hamsum;
			}
			return;
		}
		for (int i = 0; i <= X; i++) {
			ham[idx] = i;
			comb(idx + 1, count + 1);
		}
	}
}
