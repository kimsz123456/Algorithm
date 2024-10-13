import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];

		int[] start = new int[2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());

				map[i][j] = num;
				if (num == 0) {
					visited[i][j] = true;
				}
				if (num == 2) {
					start[0] = i;
					start[1] = j;
				}
			}
		}

		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { start[0], start[1], 0 });
		visited[start[0]][start[1]] = true;
		map[start[0]][start[1]] = 0;
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nextr = current[0] + dr[d];
				int nextc = current[1] + dc[d];
				int nextcnt = current[2] + 1;
				if (nextr >= 0 && nextr < N && nextc >= 0 && nextc < M && !visited[nextr][nextc]) {
					queue.add(new int[] { nextr, nextc, nextcnt });
					visited[nextr][nextc] = true;
					map[nextr][nextc] = nextcnt;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j]) {
					sb.append(map[i][j]).append(" ");
				}
				else {
					sb.append(-1).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
