import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	// 델타는 우, 하
	static int[] dr = { 0, 1 };
	static int[] dc = { 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 단어퍼즐 가로세로 N
			int K = Integer.parseInt(st.nextToken()); // 단어의 길이 K
			int[][] arr = new int[N][N];

			// 단어퍼즐 채우기
			for (int i = 0; i < N; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st2.nextToken());
				}
			}

			//
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 흰색부분일때
					if (arr[i][j] == 1) {
						// 위가 흰색이면
						if((i >= 1 && arr[i - 1][j] == 1) && (j >= 1 && arr[i][j - 1] == 1)) {
							continue;
						}
						else if ((i >= 1 && arr[i - 1][j] == 1)) {
							// 오른쪽방향만 검사
							int d = 0;
							int length = 1;
							int nr = i + dr[d];
							int nc = j + dc[d];
							while (nr < N && nc < N && arr[nr][nc] == 1) {
								nr = nr + dr[d];
								nc = nc + dc[d];
								length++;
							}
							if (length == K) {
								count++;
							}
						} else if ((j >= 1 && arr[i][j - 1] == 1)) {
							int d = 1;
							int length=1;
							int nr = i + dr[d];
							int nc = j + dc[d];
							while (nr < N && nc < N && arr[nr][nc] == 1) {
								nr = nr + dr[d];
								nc = nc + dc[d];
								length++;
							}
							if (length == K) {
								count++;
							}
						} else {
							for (int d = 0; d < 2; d++) {
								int length = 1;
								int nr = i + dr[d];
								int nc = j + dc[d];
								while (nr < N && nc < N && arr[nr][nc] == 1) {
									nr = nr + dr[d];
									nc = nc + dc[d];
									length++;
								}
								if (length == K) {
									count++;
								}
							}
						}
					} else {
						continue;
					}
				}
			}
			System.out.println("#" + tc + " " + count);
		}
	}
}
