import java.util.*;
import java.io.*;

public class Main {

	static class Point implements Comparable<Point> {
		int r, c, nearCount, likeCount;

		public Point(int r, int c, int nearCount, int likeCount) {
			this.r = r;
			this.c = c;
			this.nearCount = nearCount;
			this.likeCount = likeCount;
		}

		@Override
		public int compareTo(Point other) {
			if (this.likeCount != other.likeCount)
				return -Integer.compare(this.likeCount, other.likeCount);

			if (this.nearCount != other.nearCount)
				return -Integer.compare(this.nearCount, other.nearCount);

			if (this.r != other.r)
				return Integer.compare(this.r, other.r);

			return Integer.compare(this.c, other.c);
		}
	}

	static int[][] table;
	static int[] students;
	static int[][] like;
	static PriorityQueue<Point> queue = new PriorityQueue<>();
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		table = new int[N+1][N+1];
		students = new int[N * N];
		like = new int[N * N+1][4];
		for (int num = 0; num < N * N; num++) {
			st = new StringTokenizer(br.readLine());
			students[num] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < 4; i++) {
				like[students[num]][i] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N * N; i++) {
			solve(students[i]);
			queue.clear();
		}

		int result = 0;
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				result += getScore(r, c);
			}
		}
		System.out.print(result);
	}

	private static int getScore(int r, int c) {
		int number = table[r][c];
		int nr, nc, likeCount = 0;
		for (int now : like[number]) {
			for (int d = 0; d < 4; d++) {
				nr = r + dr[d];
				nc = c + dc[d];
				if (nr < 1 || nc < 1 || nr > N || nc > N) continue;
				if (table[nr][nc] == now) {
					likeCount++;
				}
			}
		}
		return calculateScore(likeCount);
	}

	private static int calculateScore(int likeCount) {
		if (likeCount == 0) {
			return 0;
		} else if (likeCount == 1) {
			return 1;
		} else if (likeCount == 2) {
			return 10;
		} else if (likeCount == 3) {
			return 100;
		} else {
			return 1000;
		}
	}

	private static void solve(int number) {
		int nr, nc, nearCount, likeCount;
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				nearCount = 0;
				likeCount = 0;
				if (table[r][c] != 0) continue;
				for (int d = 0; d < 4; d++) {
					nr = r + dr[d];
					nc = c + dc[d];
					if (nr < 1 || nc < 1 || nr > N || nc > N) continue;
					for (int now : like[number]) {
						if (now == table[nr][nc]) {
							likeCount++;
						}
					}
					if (table[nr][nc] == 0) {
						nearCount++;
					}
				}
            queue.add(new Point(r, c, nearCount, likeCount));
			}
		}
		Point point = queue.poll();
		table[point.r][point.c] = number;
	}
}
