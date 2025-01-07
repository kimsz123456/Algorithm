import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[] stones = new int[3];
		st = new StringTokenizer(br.readLine());

		int sum = 0;
		for (int i = 0; i < 3; i++) {
			stones[i] = Integer.parseInt(st.nextToken());
			sum += stones[i];
		}

		if (sum % 3 != 0) {
			sb.append(0);
		} else {
			boolean flag = false;
			Arrays.sort(stones);
			Queue<int[]> queue = new ArrayDeque<>();
			boolean[][] visited = new boolean[1001][1001];
			queue.add(stones);

			while (!queue.isEmpty()) {
				int[] cur = queue.poll();
				Arrays.sort(cur);
				int A = cur[0];
				int B = cur[1];
				int C = cur[2];
				if (A == B && B == C) {
					sb.append(1);
					flag = true;
					break;
				}
				if (visited[A][B])
					continue;
				visited[A][B] = true;
				if (A != B) {
					int[] nextone = { A + A, B - A, C };
					Arrays.sort(nextone);
					queue.add(nextone);
				}
				if (A != C) {
					int[] nexttwo = { A + A, B, C - A };
					Arrays.sort(nexttwo);
					queue.add(nexttwo);
				}
				if (B != C) {
					int[] nextthree = { A, B + B, C - B };
					Arrays.sort(nextthree);
					queue.add(nextthree);
				}
			}
			if (!flag) {
				sb.append(0);
			}
		}
		System.out.println(sb);
	}
}