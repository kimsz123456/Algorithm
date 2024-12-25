import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] num;
	static boolean[] selected;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		num = new int[N + 1];
		selected = new boolean[N + 1];
		list = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= N; i++) {
			selected[i] = true;
			dfs(i, i);
			selected[i] = false;
		}

		Collections.sort(list);
		sb.append(list.size()).append("\n");
		for (int num : list) {
			sb.append(num).append("\n");
		}

		System.out.println(sb);
	}

	static void dfs(int now, int first) {
		if (num[now] == first) {
			list.add(first);
		}
		
		if (!selected[num[now]]) {
			selected[num[now]] = true;
			dfs(num[now], first);
			selected[num[now]] = false;
		}
		
	}
}
