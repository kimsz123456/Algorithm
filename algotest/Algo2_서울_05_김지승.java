import java.util.*;
import java.io.*;

public class Algo2_서울_05_김지승 {
	static int[] arr, selected;
	static int N, M, K, sum, result;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			arr = new int[N];
			selected = new int[M];
			visited = new boolean[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			result = 0;
			perm(0, 0);
			if(result==0) {
				result=-1;
				System.out.println("#"+tc+" "+result);
			}
			else {
				System.out.println("#"+tc+" "+result);
			}
		}
	}

	public static void perm(int idx, int count) {
		if (count == M) {
			sum = 0;
			for (int i = 0; i < M; i++) {
				sum += selected[i];
			}
			if (sum == K) {
				result++;
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[count] = arr[i];
				perm(i, count + 1);
				visited[i] = false;
			}
		}
	}
}
