import java.util.*;
import java.io.*;

public class Main {
    static int K,M,maxScore;
    static int[][] ruins;
    final static int SIZE = 5;
    static Queue<Integer> spare;
    static List<Integer> scoreList;
    static List<int[]> list,temp;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ruins = new int[SIZE][SIZE];

        for(int i=0;i<SIZE;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<SIZE;j++){
                ruins[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        spare = new ArrayDeque<>();
        for(int i=0;i<M;i++){
            spare.add(Integer.parseInt(st.nextToken()));
        }

        simulation();

        for (int value : scoreList){
            sb.append(value + " ");
        }
		sb.append("\n");

		System.out.println(sb);
    }

    private static void simulation() {
		scoreList = new ArrayList<>();
		for (int t = 0; t < K; t++) {
			maxScore = 0;
			list = new ArrayList<>();
			temp = new ArrayList<>();
			// 가장 점수를 많이 획득할 수 있는 지점을 구하자
			int[] expect = getExpectPosition();

			// 점수를 획득할 수 없던 경우 바로 종료
			if (list.size() == 0)
				return;
			
			// rotate(x,y,degree) 특정 좌표를 기준으로 구한 각도로 회전
			ruins = rotate(expect[0], expect[1], expect[2]);

			// 지우기
			for (int[] pos : list)
				removeItem(pos[0], pos[1]);

			// 채우기
			fillItem();

			// 추가 점수 획득
			while (true) {
				visited = new boolean[SIZE][SIZE];
				int count = 0;
				temp.clear();
				for (int i = 0; i < SIZE; ++i) {
					for (int j = 0; j < SIZE; ++j) {
						count += bfs(i, j, ruins);
					}
				}
				if (count == 0)
					break;

				visited = new boolean[SIZE][SIZE];
				for (int[] pos : temp)
					removeItem(pos[0], pos[1]);
				fillItem();
				maxScore += count;
			}
			scoreList.add(maxScore);
		}

	}
    private static void removeItem(int x, int y) {
		visited = new boolean[SIZE][SIZE];
		visited[x][y] = true;
		int base = ruins[x][y];
		ruins[x][y] = 0;
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x, y});

		while (!q.isEmpty()) {
			int[] pos = q.poll();
			for (int d = 0; d < 4; ++d) {
				int nx = pos[0] + dx[d];
				int ny = pos[1] + dy[d];
				if (!isInRange(nx, ny))
					continue;
				if (!visited[nx][ny] && ruins[nx][ny] == base) {
					visited[nx][ny] = true;
					ruins[nx][ny] = 0;
					q.add(new int[] {nx, ny});
				}
			}
		}
	}

	private static void fillItem() {
		for (int j = 0; j < SIZE; ++j) {
			for (int i = 4; i >= 0; --i)
				if (ruins[i][j] == 0)
					ruins[i][j] = spare.poll();
		}
	}

	private static int[] getExpectPosition() {
		int max = 0;
		int rx = -1;
		int ry = -1;
		int rd = -1;

		// 우선순위를 고려하여 위치 찾기.
		for (int d = 1; d < 4; ++d) {
			for (int j = 1; j < 4; ++j) {
				for (int i = 1; i < 4; ++i) {
					int[][] rotateArr = rotate(i, j, d);
					visited = new boolean[SIZE][SIZE];
					temp.clear();
					int score = 0;
					for (int r = 0; r < 3; ++r) {
						for (int c = 0; c < 3; ++c) {
							if (!visited[r + i - 1][c + j - 1])
								score += bfs(r + i - 1, c + j - 1, rotateArr);
						}
					}
					if (score > max) {
						list.clear();
						list.addAll(temp);
						rx = i;
						ry = j;
						rd = d;
						max = score;
					}
				}
			}
		}
		maxScore += max;
		return new int[] {rx, ry, rd};
	}

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	private static int bfs(int x, int y, int[][] rotateArr) {
		int count = 1;

		visited[x][y] = true;
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x, y});

		while (!q.isEmpty()) {
			int[] pos = q.poll();
			for (int d = 0; d < 4; ++d) {
				int nx = pos[0] + dx[d];
				int ny = pos[1] + dy[d];
				if (!isInRange(nx, ny))
					continue;
				if (!visited[nx][ny] && rotateArr[nx][ny] == rotateArr[x][y]) {
					count++;
					visited[nx][ny] = true;
					q.add(new int[] {nx, ny});
				}
			}
		}

		if (count > 2) {
			temp.add(new int[] {x, y});
			return count;
		}
		return 0;
	}

	public static int[][] rotate(int x, int y, int d) {
		int[][] copy = new int[3][3];
		int[][] rotateArr = new int[SIZE][SIZE];

		for (int i = 0; i < SIZE; ++i) {
			for (int j = 0; j < SIZE; ++j)
				rotateArr[i][j] = ruins[i][j];
		}

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j)
				if (d == 1) // 90도 회전
					copy[i][j] = ruins[3 - j + x - 2][i + y - 1];
				else if (d == 2) // 180도 회전
					copy[i][j] = ruins[3 - i + x - 2][3 - j + y - 2];
				else // 270도 회전
					copy[i][j] = ruins[j + x - 1][3 - i + y - 2];
		}

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j)
				rotateArr[i + x - 1][j + y - 1] = copy[i][j];
		}
		return rotateArr;
	}

	public static boolean isInRange(int x, int y) {
		if (x >= 0 && x < SIZE && y >= 0 && y < SIZE)
			return true;
		return false;
	}
}