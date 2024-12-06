import java.io.*;
import java.util.*;

public class Main {
	static class Edge {
		int e, t;

		public Edge(int e, int t) {
			this.e = e;
			this.t = t;
		}
	}

	static final long INF = Long.MAX_VALUE;
	static int N, M, W;
	static List<Edge>[] adjList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			adjList[s].add(new Edge(e, t));
		}
		bellmanFord();
	}

	public static void bellmanFord() {
		long[] dist = new long[N + 1];
		Arrays.fill(dist, INF);
		dist[1] = 0;
		// N-1번의 반복작업 + 확인작업
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (Edge edge : adjList[j]) {
					if (dist[j] != INF && dist[edge.e] > dist[j] + edge.t) {
						dist[edge.e] = dist[j] + edge.t;

						if (i == N) {
							System.out.println(-1);
							return;
						}
					}
				}
			}
		}
		for (int i = 2; i <= N; i++) {
			if (dist[i] == Long.MAX_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println(dist[i]);
			}
		}
	}
}
