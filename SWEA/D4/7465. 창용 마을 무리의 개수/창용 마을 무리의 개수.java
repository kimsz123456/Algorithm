import java.io.*;
import java.util.*;

public class Solution {
	static int[] sets, size;
	static int n, m;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			sets = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				sets[i] = i;
			}
			for (int i = 0; i < m; i++) {

				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				union(a, b);
			}
			Set<Integer> set = new HashSet<>();
			for (int i = 1; i <= n; i++) {
				set.add(find(sets[i]));
			}
			sb.append("#").append(tc).append(" ").append(set.size()).append("\n");
		}
		System.out.println(sb);
	}

	public static int find(int x) {
		if (x != sets[x])
			sets[x] = find(sets[x]); // 경로 압축
		return sets[x];
	}

	public static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);

		sets[pb] = pa;
	}
}