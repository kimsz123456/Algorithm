import java.io.*;
import java.util.*;

public class Solution {
	static int N, sum, count, min;
	static boolean[][] visited;
	static List<Core> coreList;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static boolean result;

	// 코어클래스
	static class Core {
		int r, c, length;

		Core(int r, int c, int length) {
			this.r = r;
			this.c = c;
			this.length = length;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			// 방문배열과 코어리스트
			visited = new boolean[N][N];
			coreList = new ArrayList<>();

			// 입력받을때 코어들은 visited, 가장자리가 아닌 코어들은 count를세고 리스트에 추가.
			count = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int core = Integer.parseInt(st.nextToken());
					if (core == 1) {
						visited[i][j] = true;
						if (i != 0 && i != N - 1 && j != 0 && j != N - 1) {
							count++;
							coreList.add(new Core(i, j, 0));
						}
					}
				}
			}
			// 코어개수 많은거부터
			int num = count;

			// 최소값과 결과출력 초기화
			min = Integer.MAX_VALUE;
			result = false;

			boolean[][] tmp = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				System.arraycopy(visited[i], 0, tmp[i], 0, N);
			}
			// num=count부터 하나씩 줄여나가고 연결되면 break
			while (num != 0) {
				comb(0, num);
				for (int i = 0; i < N; i++) {
					System.arraycopy(tmp[i], 0, visited[i], 0, N);
				}
				if (result) {
					break;
				}
				num--;
			}
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	// 조합생성
	static void comb(int idx, int cnt) {

		// 카운트가 0이되면 최소값 저장
		if (cnt == 0) {
			sum = 0;
			for (Core c : coreList) {
				sum += c.length;
			}
			min = Math.min(sum, min);
			result = true;
			return;
		}

		// cnt==0이아니고 idx==count이면 연결안된거라 return
		if (idx == count) {
			return;
		}

		// 코어정보를 가져옴
		Core core = coreList.get(idx);
		int originalLength = core.length;

		// visited정보를 담은 tmp배열을 만듦
		boolean[][] tmpVisited = new boolean[N][N];
		// 카피
		for (int k = 0; k < N; k++) {
			System.arraycopy(visited[k], 0, tmpVisited[k], 0, N);
		}
		// 4방향돌며체크, visited배열을 보냄
		for (int j = 0; j < 4; j++) {
			if (canConnect(idx, j)) {
				comb(idx + 1, cnt - 1);
				for (int k = 0; k < N; k++) {
					System.arraycopy(tmpVisited[k], 0, visited[k], 0, N);
				}
				core.length = originalLength;
				// visited배열 초기화
			}
			for (int k = 0; k < N; k++) {
				System.arraycopy(tmpVisited[k], 0, visited[k], 0, N);
			}
		}
		comb(idx + 1, cnt);
	}

	// 연결됐는지 체크 코어의num과 방향, 방문체크가 넘어옴.
	static boolean canConnect(int num, int dir) {
		Core core = coreList.get(num);
		int r = core.r;
		int c = core.c;
		int length = 0;
		// 그방향으로 쭉
		while (true) {
			r += dr[dir];
			c += dc[dir];

			// 경계넘어가면 멈추기
			if (r < 0 || r >= N || c < 0 || c >= N) {
				core.length = length;
				return true;
			}

			// 방문했으면 false
			if (visited[r][c]) {
				return false;
			}
			// 방문체크
			visited[r][c] = true;
			length++;
		}
	}
}
