import java.io.*;
import java.util.*;

public class Solution {
	static int[] sets, size;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			size = new int[n+1];
			sets = new int[n+1];
			for (int i = 1; i < n; i++) {
				sets[i] = i;
			}

			for (int i = 0; i < m; i++) {

				st = new StringTokenizer(br.readLine());

				int operator = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (operator == 0) {
					union(a, b);
				}
				else {
					if(find(a) == find(b)) {
						sb.append(1);
					}
					else {
						sb.append(0);
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static int find(int x) {
		if (x != sets[x])
			sets[x] = find(sets[x]);
		return sets[x];
	}

	public static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);

		sets[pb] = pa;

	}
}