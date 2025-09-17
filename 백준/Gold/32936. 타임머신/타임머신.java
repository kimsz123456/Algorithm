import java.io.*;
import java.util.*;

public class Main {
	static int N, M, a, b, c;
	static List<Integer>[] adj;
	static Queue<Integer> q = new ArrayDeque<>();
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		a = stoi(st.nextToken());
		b = stoi(st.nextToken());
		c = stoi(st.nextToken());

		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = stoi(st.nextToken());
			int v = stoi(st.nextToken());
			adj[u].add(v);
		}

		// 1번에서 시작했을 때
		bfs(1);
		int StoN = (dist[N] == 0) ? Integer.MAX_VALUE : dist[N] - 1;
		int Stoa = (dist[a] == 0) ? Integer.MAX_VALUE : dist[a] - 1;

		// b에서 시작했을 때 (타임머신 이후)
		bfs(b);
		int btoN = (dist[N] == 0) ? Integer.MAX_VALUE : dist[N] - 1;
		int btoa = (dist[a] == 0) ? Integer.MAX_VALUE : dist[a] - 1;

		// 최소 시간
		int minTime = StoN;

		// 타임머신을 사용하는 경우
		if (Stoa != Integer.MAX_VALUE && btoN != Integer.MAX_VALUE) {
			int timeMachine = Stoa + btoN - c;
			minTime = Math.min(minTime, timeMachine);
			
			// 타임머신을 타서 도착시간을 무한히 작게 만들 수 있는 경우
			if (btoa != Integer.MAX_VALUE && btoa < c) {
				System.out.print("-inf");
				return;
			}
		}

		// 도달 불가능한 경우
		if (minTime == Integer.MAX_VALUE) {
			System.out.print("x");
			return;
		}

		System.out.print(minTime);
	}

	public static void bfs(int S) {
		dist = new int[N + 1];
		dist[S] = 1;
		q.clear();
		q.add(S);

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : adj[cur]) {
				if (dist[next] != 0)
					continue;
				dist[next] = dist[cur] + 1;
				q.add(next);
			}
		}
	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}