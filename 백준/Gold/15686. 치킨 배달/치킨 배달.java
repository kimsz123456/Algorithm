import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static boolean[] selected;
	static int[][] chicken;
	static List<int[]> store, house;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		chicken = new int[N][N];
		store = new ArrayList<>();
		house = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				chicken[i][j] = num;
				if (num == 1) {
					house.add(new int[] { i, j });
				}
				if (num == 2) {
					store.add(new int[] { i, j });
				}
			}
		}

		selected = new boolean[store.size()];
		combination(0, 0);
		System.out.println(result);
	}

	static void combination(int idx, int count) {
		if (count == M) {
			result = Math.min(dist(selected), result);
			return;
		}

		for (int i = idx; i < store.size(); i++) {
			if (!selected[i]) {
				selected[i] = true;
				combination(i, count + 1);
				selected[i] = false;
			}
		}

	}

	static int dist(boolean[] sel) {
		int distance = 0;
		for (int[] h : house) {
			int chicDist = Integer.MAX_VALUE;
			for (int num = 0; num < store.size(); num++) {
				if (sel[num]) {
					int[] st = store.get(num);
					int x = Math.abs(st[0] - h[0]);
					int y = Math.abs(st[1] - h[1]);
					chicDist = Math.min(chicDist, x + y);
				}
			}
			distance += chicDist;
		}
		return distance;
	}
}