import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static boolean[] visited;
	static int[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N];
		selected = new int[M];
		select(0, 0);
		System.out.println(sb);
	}

	private static void select(int idx, int count) {
		if (count == M) {
			for (int i = 0; i < M; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		if(idx>=N) {
			return;
		}
		if (!visited[idx]) {
			visited[idx] = true;
			selected[count] = idx + 1;
			select(idx + 1, count + 1);
			visited[idx] = false;
		}
		select(idx + 1, count);
	}
}