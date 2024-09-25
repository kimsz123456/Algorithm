import java.io.*;
import java.util.*;

public class Main {
	static int N, area;
	static char[][] grid, rggrid;
	static boolean[][] visited;
	static Queue<int[]> queue;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		grid = new char[N][N];
		rggrid = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				char normal = str.charAt(j);
				grid[i][j] = normal;
				if (str.charAt(j) == 'G') {
					rggrid[i][j] = 'R';
				} else {
					rggrid[i][j] = normal;
				}
			}
		}
		System.out.print(bfs(grid)+" ");
		System.out.println(bfs(rggrid));
	}

	static int bfs(char[][] grid) {
		visited = new boolean[N][N];
		queue = new ArrayDeque<>();
		area = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					queue.add(new int[] { i, j });
					visited[i][j] = true;
					char cur = grid[i][j];
					while (!queue.isEmpty()) {
						int[] current = queue.poll();
						for (int d = 0; d < 4; d++) {
							int nextr = current[0] + dr[d];
							int nextc = current[1] + dc[d];
							if (nextr >= 0 && nextr < N && nextc >= 0 && nextc < N && !visited[nextr][nextc]
									&& grid[nextr][nextc] == cur) {
								queue.add(new int[] { nextr, nextc });
								visited[nextr][nextc] = true;
							}
						}
					}
					area++; 
				}
			}
		}
		return area;
	}
}