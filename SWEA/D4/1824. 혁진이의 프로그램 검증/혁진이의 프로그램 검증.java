import java.util.*;
import java.io.*;

public class Solution {
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	static class Now {
		int r, c, d, m;

		Now(int r, int c, int d, int m) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.m = m;
		}
	}

	static boolean arrived;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			char[][] code = new char[R][C];

			boolean flag = false;
			for (int i = 0; i < R; i++) {
				String str = br.readLine();
				for (int j = 0; j < C; j++) {
					code[i][j] = str.charAt(j);
					if (code[i][j] == '@') {
						flag = true;
					}
				}
			}
			arrived = false;

			boolean[][][][] visited = new boolean[R][C][4][16];
			Queue<Now> queue = new ArrayDeque<>();
			queue.add(new Now(0, 0, 0, 0));
			visited[0][0][0][0] = true;
			if (flag) {

				while (!queue.isEmpty()) {
					Now now = queue.poll();
					char c = code[now.r][now.c];
					
					now = command(now, c);
					if (arrived) {
						break;
					}
					if (c == '?') {
						for (int d = 0; d < 4; d++) {
							int nr = (now.r + dr[d] + R) % R;
							int nc = (now.c + dc[d] + C) % C;
							if (!visited[nr][nc][d][now.m]) {
								queue.add(new Now(nr, nc, d, now.m));
								visited[nr][nc][d][now.m] = true;
							}
						}
						continue;
					}
					
					int nr = (now.r + dr[now.d] + R) % R;
					int nc = (now.c + dc[now.d] + C) % C;
					if (!visited[nr][nc][now.d][now.m]) {
						queue.add(new Now(nr, nc, now.d, now.m));
						visited[nr][nc][now.d][now.m] = true;
					}
				}
			}
			if (arrived) {
				sb.append("#").append(tc).append(" YES\n");
			} else {
				sb.append("#").append(tc).append(" NO\n");
			}
		}
		System.out.print(sb);
	}

	static Now command(Now now, char c) {
		if (c - '0' < 10 && c - '0' >= 0) {
			now.m = c - '0';
		} else {
			switch (c) {
			case '<':
				now.d = 2;
				break;
			case '>':
				now.d = 0;
				break;
			case '^':
				now.d = 3;
				break;
			case 'v':
				now.d = 1;
				break;
			case '_':
				now.d = (now.m == 0) ? 0 : 2;
				break;
			case '|':
				now.d = (now.m == 0) ? 1 : 3;
				break;
			case '.':
				break;
			case '@':
				arrived = true;
				break;
			case '+':
				now.m = (now.m + 1) % 16;
				break;
			case '-':
				now.m = (now.m + 15) % 16;
				break;
			}
		}
		return now;
	}
}
