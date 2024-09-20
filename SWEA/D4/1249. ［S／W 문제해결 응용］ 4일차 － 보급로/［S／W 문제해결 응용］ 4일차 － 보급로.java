import java.io.*;
import java.util.*;

public class Solution {
	public static class Info implements Comparable<Info> {
		int x, y;
		int distance; // 인덱스와 가중치를 저장한다.

		Info(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

		public int compareTo(Info other) { // 가중치를 기준으로 comparable을 선언하여 우선순위 큐의 판단 기준을 제공한다.
			if (this.distance < other.distance) {// 비교할 값보다 지금이 최소값일 때 -> 교환안함
				return -1; // 음수 일경우 : 교환안함
			}
			return 1;
		}
	}

	static int N, ans;
	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { 1, 0, -1, 0 };

	static boolean[][] visited;
	static int[][] sum;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			ans = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());

			arr = new int[N][N];
			visited = new boolean[N][N];
			sum = new int[N][N];

			for (int i = 0; i < N; i++) {
				Arrays.fill(sum[i], Integer.MAX_VALUE);
			}
			sum[0][0] = 0;

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j) - '0';
				}
			}

			dijkstra();
			sb.append("#").append(tc).append(" ").append(sum[N - 1][N - 1]).append("\n");

		}
		System.out.println(sb);

	}

	public static void dijkstra() {
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.offer(new Info(0, 0, 0));

		while (!pq.isEmpty()) {
			Info cur = pq.poll();
			if (cur.distance > sum[cur.x][cur.y])
				continue;

			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dr[d];
				int ny = cur.y + dc[d];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
					int nd = cur.distance + arr[nx][ny];
					if (sum[nx][ny] > nd) {
						sum[nx][ny] = nd;
						pq.offer(new Info(nx, ny, sum[nx][ny]));
					}
				}
			}
		}

	}
}
