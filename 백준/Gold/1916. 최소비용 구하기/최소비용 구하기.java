import java.io.*;
import java.util.*;

public class Main {

	static class Edge implements Comparable<Edge> {
		int a, b, w;

		Edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}

		@Override
		public int compareTo(Edge other) {
			return Integer.compare(this.w, other.w);
		}
	}

	static int N, M, start, end;
	static List<Edge>[] adjList;
	static int[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		adjList = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adjList[a].add(new Edge(a, b, w));
		}

		distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		dijkstra();
	}

	static void dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1];

		distance[start] = 0;
		pq.add(new Edge(0, start, 0));

		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			if (now.b == end) {
				System.out.println(now.w);
				return;
			}
			if (visited[now.b])	continue;
			visited[now.b] = true;

			for (Edge edge : adjList[now.b]) {
				if (!visited[edge.b] && distance[edge.b] > distance[now.b] + edge.w) {
					distance[edge.b] = distance[now.b] + edge.w;
					pq.add(new Edge(edge.a, edge.b, distance[edge.b]));
				}
			}
		}
	}
}