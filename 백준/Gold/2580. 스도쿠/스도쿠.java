import java.io.*;
import java.util.*;

public class Main {
	static int[][] sudoku;
	static List<int[]> list = new ArrayList<>();
	static final int N = 9;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		sudoku = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
				if (sudoku[i][j] == 0) {
					list.add(new int[] { i, j });
				}
			}
		}
		next(0);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(sudoku[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static boolean next(int cnt) {
		if (cnt == list.size()) {
			return true;
		}
		int r = list.get(cnt)[0];
		int c = list.get(cnt)[1];
		for (int i = 1; i <= N; i++) {
			sudoku[r][c] = i;
			if (isValid(r, c) && next(cnt + 1)) {
				return true;
			}
		}

		sudoku[r][c] = 0;
		return false;
	}

	static boolean isValid(int r, int c) {
		for (int i = 0; i < N; i++) {
			if (r != i && sudoku[i][c] == sudoku[r][c]) {
				return false;
			}
			if (c != i && sudoku[r][i] == sudoku[r][c]) {
				return false;
			}
		}
		for (int nr = (r / 3) * 3, i = 0; i < 3; i++, nr++) {
			for (int nc = (c / 3) * 3, j = 0; j < 3; j++, nc++) {
				if (nr != r && nc != c && sudoku[nr][nc] == sudoku[r][c])
					return false;
			}
		}
		return true;
	}
}