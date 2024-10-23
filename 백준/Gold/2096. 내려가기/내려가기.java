import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] num = new int[N][3];
		int[][] maxdp = new int[N][3];
		int[][] mindp = new int[N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 3; i++) {
			maxdp[0][i] = num[0][i];
			mindp[0][i] = num[0][i];
		}
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					maxdp[i][j] = Math.max(maxdp[i - 1][j], maxdp[i - 1][j + 1]) + num[i][j];
					mindp[i][j] = Math.min(mindp[i - 1][j], mindp[i - 1][j + 1]) + num[i][j];
				} else if (j == 2) {
					maxdp[i][j] = Math.max(maxdp[i - 1][j - 1], maxdp[i - 1][j]) + num[i][j];
					mindp[i][j] = Math.min(mindp[i - 1][j - 1], mindp[i - 1][j]) + num[i][j];
				} else {
					maxdp[i][j] = Math.max(maxdp[i - 1][j - 1], Math.max(maxdp[i - 1][j], maxdp[i - 1][j + 1]))
							+ num[i][j];
					mindp[i][j] = Math.min(mindp[i - 1][j - 1], Math.min(mindp[i - 1][j], mindp[i - 1][j + 1]))
							+ num[i][j];
				}
			}
		}
		sb.append(Math.max(maxdp[N - 1][0], Math.max(maxdp[N - 1][1], maxdp[N - 1][2])));
		sb.append(" ");
		sb.append(Math.min(mindp[N - 1][0], Math.min(mindp[N - 1][1], mindp[N - 1][2])));
		System.out.println(sb);
	}
}