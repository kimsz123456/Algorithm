import java.util.*;
import java.io.*;

public class Solution {

	static class Edge implements Comparable<Edge> {
		int A, B;
		double W;

		public Edge(int a, int b, double w) {
			A = a;
			B = b;
			W = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.W, o.W);
		}

	}

	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int V = Integer.parseInt(br.readLine()); // 정점의 번호 0번부터 시작
			int E = V * (V - 1) / 2; // 간선의 수

			// 인접리스트
			List<Edge>[] adjList = new ArrayList[V];

			for (int i = 0; i < V; i++) {
				adjList[i] = new ArrayList<>();
			} // 실제 생성까지

			int[] x = new int[V];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < V; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}

			int[] y = new int[V];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < V; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}

			double tax = Double.parseDouble(br.readLine());

			for (int i = 0; i < V - 1; i++) {
				for (int j = i + 1; j < V; j++) {

					double W = (tax * (Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2)));
					adjList[i].add(new Edge(i, j, W));
					adjList[j].add(new Edge(j, i, W));
				}
			} // 입력 끝

			// 방문쳌
			boolean[] visited = new boolean[V]; // 해당 정점 뽑았어!

			PriorityQueue<Edge> pq = new PriorityQueue<>();
			visited[0] = true;

			double ans = 0;
			int pick = 1;

			pq.addAll(adjList[0]);

			while (pick != V) {
				Edge e = pq.poll();
				if (visited[e.B])
					continue; // 이미 뽑은 친구라면....

				ans += e.W; // 비용추가
				visited[e.B] = true;
				pick++;

				pq.addAll(adjList[e.B]);
			}
			ans = Math.round(ans*10) / 10.0;
			System.out.printf("#"+tc+" %.0f%n", ans);
		}
	}
}
