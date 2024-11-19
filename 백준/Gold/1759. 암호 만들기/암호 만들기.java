import java.io.*;
import java.util.*;

public class Main {
	static int L, C;
	static char[] arr, selected;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[C];
		selected = new char[L];
		visited = new boolean[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			char c = st.nextToken().charAt(0);
			arr[i] = c;
		}
		Arrays.sort(arr);

		comb(0, 0);
		System.out.println(sb);
	}

	static void comb(int idx, int cnt) {
		if (cnt == L) {
			boolean flag = false;
			int count = 0;
			for (int i = 0; i < L; i++) {
				if (check(selected[i])) {
					flag = true;
				}
				else {
					count++;
				}
			}
			if (flag && count>1) {
				for (int i = 0; i < L; i++) {
					sb.append(selected[i]);
				}
				sb.append("\n");
			}
			return;
		}
		for (int i = idx; i < C; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[cnt] = arr[i];
				comb(i, cnt + 1);
				visited[i] = false;
			}
		}
	}

	static boolean check(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
			return true;
		}
		return false;
	}
}