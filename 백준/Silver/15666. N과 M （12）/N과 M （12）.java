import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static boolean[] visited;
	static int[] selected, num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		num = new int[N];
		visited = new boolean[N];
		selected = new int[M];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st2.nextToken());
		}
		Arrays.sort(num);
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
		if (idx >= N) {
			return;
		}

		int duplicate = 0;
		for (int i = idx; i < N; i++) {
			if (duplicate!=num[i]) {
				selected[count] = num[i];
				duplicate = num[i];
				select(i,count+1);
			}
		}
	}
}
