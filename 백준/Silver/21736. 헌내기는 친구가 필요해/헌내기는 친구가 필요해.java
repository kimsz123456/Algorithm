import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static char[][] campus;
	static boolean[][] visited;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		campus = new char[N][M];
		visited = new boolean[N][M];

		int result = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			campus[i] = str.toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (campus[i][j] == 'I') {
					result = bfs(i, j);
				}
			}
		}

		if (result > 0) {
			System.out.println(result);
		} else {
			System.out.println("TT");
		}
	}

	static int bfs(int r, int c) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { r, c });
		visited[r][c] = true;
		int count = 0;
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nextr = current[0] + dr[d];
				int nextc = current[1] + dc[d];
				if (nextr < 0 || nextr >= N || nextc < 0 || nextc >= M) {
					continue;
				}
				if (visited[nextr][nextc] || campus[nextr][nextc] == 'X') {
					continue;
				}
				if (campus[nextr][nextc] == 'P') {
					count++;
				}
				queue.add(new int[] { nextr, nextc });
				visited[nextr][nextc] = true;
			}
		}
		return count;
	}
}