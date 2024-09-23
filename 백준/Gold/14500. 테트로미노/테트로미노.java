import java.io.*;
import java.util.*;

public class Main {
	static int N, M, sum, result;
	static int[][] paper;
	static boolean[][] visited;
	static Stack<int[]> stack = new Stack<>();
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		paper = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		result = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				tetromino(i, j, 1,paper[i][j]); // 탐색 시작
				visited[i][j] = false;
			}
		}

		System.out.println(result);
	}
	static void tetromino(int r, int c, int count,int sum) {
		if (count == 4) { // 4개의 셀을 선택한 경우
			result = Math.max(sum, result); // 최대 합 갱신
			return; // 재귀 종료
		}
		
		stack.push(new int[] { r, c });
		for (int i = 0; i < stack.size(); i++) {
			int[] now = stack.get(i);
			for (int d = 0; d < 4; d++) {
				int nextr = now[0] + dr[d];
				int nextc = now[1] + dc[d];
				if (nextr >= 0 && nextr < N && nextc >= 0 && nextc < M && !visited[nextr][nextc]) {
					visited[nextr][nextc] = true;
					tetromino(nextr, nextc, count + 1,sum+paper[nextr][nextc]); // 다음 칸 탐색
					visited[nextr][nextc] = false;
				}
			}
		}
		stack.pop(); // 탐색 완료 후 스택에서 제거
	}
}