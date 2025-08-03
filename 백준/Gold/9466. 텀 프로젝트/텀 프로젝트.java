import java.util.*;
import java.io.*;

public class Main {
	static int[] arr;
	static boolean[] team, done;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = stoi(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = stoi(br.readLine());
			arr = new int[N + 1];
			team = new boolean[N + 1];
			done = new boolean[N + 1];
			cnt = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				arr[i] = stoi(st.nextToken());
			}

			for (int i = 1; i <= N; i++) {
				if (!team[i]) {
					dfs(i);
				}
			}

			sb.append(N - cnt).append("\n");
		}

		System.out.print(sb);
	}

	public static void dfs(int node) {
		team[node] = true;
		int next = arr[node];

		if (!team[next]) {
			dfs(next);
		} else if (!done[next]) {
			cnt++;
			for (int i = next; i != node; i = arr[i]) {
				cnt++;
			}
		}

		done[node] = true;
	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
