import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static Character[][] field;
	static int N, M, length;
	static tank tank;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			field = new Character[N][M];
			int r = 0;
			int c = 0;
			char dir = 'A';
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					char A = str.charAt(j);
					field[i][j] = A;
					if (A == '^') {
						r = i;
						c = j;
						dir = 'U';
					} else if (A == 'v') {
						r = i;
						c = j;
						dir = 'D';
					} else if (A == '<') {
						r = i;
						c = j;
						dir = 'L';
					} else if (A == '>') {
						r = i;
						c = j;
						dir = 'R';
					}
				}
			}
			tank = new tank(r, c, dir);
			length = Integer.parseInt(br.readLine());
			String com = br.readLine();
			command(tank, com, 0);
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < N; i++) {
				for(int j=0;j<M;j++) {
					sb.append(field[i][j]);
				}
				sb.append("\n");
			}
			System.out.print(sb.toString());
		}
	}

	static void command(tank tank, String str, int count) {
		if (count == length) {
			return;
		}
		char A = str.charAt(count);
		if (A == 'S') {
			shoot(tank);
		} else {
			move(tank, A);
		}
		command(tank, str, count + 1);
	}

	static void move(tank tank, char dir) {
		tank.dir = dir;
		if (dir == 'U') {
			if (tank.r - 1 >= 0 && field[tank.r - 1][tank.c] == '.') {
				field[tank.r][tank.c] = '.';
				tank.r -= 1;
			} 
			field[tank.r][tank.c] = '^';
		} else if (dir == 'D') {
			if (tank.r + 1 < N && field[tank.r + 1][tank.c] == '.') {
				field[tank.r][tank.c] = '.';
				tank.r += 1;
			} 
			field[tank.r][tank.c] = 'v';
		} else if (dir == 'L') {
			if (tank.c - 1 >= 0 && field[tank.r][tank.c - 1] == '.') {
				field[tank.r][tank.c] = '.';
				tank.c -= 1;
			} 
			field[tank.r][tank.c] = '<';
		} else {
			if (tank.c + 1 < M && field[tank.r][tank.c + 1] == '.') {
				field[tank.r][tank.c] = '.';
				tank.c += 1;
			} 
			field[tank.r][tank.c] = '>';
		}
	}

	static void shoot(tank tank) {
		int d = 0;
		int r = tank.r;
		int c = tank.c;
		if (tank.dir == 'U') {
			d = 0;
			while (r + dr[d] >= 0) {
				r += dr[d];
				if (field[r][c] == '*') {
					field[r][c] = '.';
					break;
				}
				if (field[r][c] == '#') {
					break;
				}
			}
		} else if (tank.dir == 'D') {
			d = 1;
			while (r + dr[d] < N) {
				r += dr[d];
				if (field[r][c] == '*') {
					field[r][c] = '.';
					break;
				}
				if (field[r][c] == '#') {
					break;
				}
			}
		} else if (tank.dir == 'L') {
			d = 2;
			while (c + dc[d] >= 0) {
				c += dc[d];
				if (field[r][c] == '*') {
					field[r][c] = '.';
					break;
				}
				if (field[r][c] == '#') {
					break;
				}
			}
		} else {
			d = 3;
			while (c + dc[d] < M) {
				c += dc[d];
				if (field[r][c] == '*') {
					field[r][c] = '.';
					break;
				}
				if (field[r][c] == '#') {
					break;
				}
			}
		}
	}

	static class tank {
		int r, c;
		char dir;

		public tank(int r, int c, char dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
}

	