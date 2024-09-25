import java.io.*;
import java.util.*;

public class Solution {
	static int N = 16;
	static boolean[][] visited;
	static int[] start, end;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static boolean result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < 10; tc++) {
			int t = Integer.parseInt(br.readLine());

			visited = new boolean[N][N];
			result = false;
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					int num = str.charAt(j) - '0';
					if (num == 1) {
						visited[i][j] = true;
					}
					if (num == 2) {
						start = new int[] { i, j };
					}
					if (num == 3) {
						end = new int[] { i, j };
					}
				}
			}

			dfs(start[0], start[1]);

			if (result) {
				sb.append("#").append(t).append(" 1\n");
			} else {
				sb.append("#").append(t).append(" 0\n");
			}
		}
		System.out.println(sb);
	}

	static void dfs(int r, int c) {
		if (r == end[0] && c == end[1]) {
			result = true;
			return;
		}
		visited[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nextr = r + dr[d];
			int nextc = c + dc[d];
			if (nextr >= 0 && nextr < N && nextc >= 0 && nextc < N && !visited[nextr][nextc]) {
				dfs(nextr, nextc);
			}
		}
	}
}