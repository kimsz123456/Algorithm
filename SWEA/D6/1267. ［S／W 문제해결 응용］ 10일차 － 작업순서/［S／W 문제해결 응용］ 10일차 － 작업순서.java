import java.io.*;
import java.util.*;

public class Solution {
	static Stack<Integer> stack;
	static boolean[] visited;
	static int V;
	static List<Integer>[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			// 인접리스트
			arr = new ArrayList[V + 1];
			for (int i = 1; i < V + 1; i++) {
				arr[i] = new ArrayList<>();
			}
			// 진입차수
			int[] indegree = new int[V + 1];
			// 방문체크
			visited = new boolean[V + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int in = Integer.parseInt(st.nextToken());
				int out = Integer.parseInt(st.nextToken());
				arr[in].add(out);
				indegree[out]++;
			}

			stack = new Stack<>();

			sb.append("#").append(tc).append(" ");
			for (int i = 1; i < V + 1; i++) {
				if (indegree[i] == 0) {
					dfs(i);
				}
			}
			while(!stack.empty()) {
				sb.append(stack.pop()).append(" ");
			}

			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int curr) {
		visited[curr] = true;
		for (int num : arr[curr]) {
			if (!visited[num]) {
				dfs(num);
			}
		}
		stack.push(curr);
	}
}