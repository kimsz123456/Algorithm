import java.util.*;
import java.io.*;

public class Solution {
	static boolean[][] arr;
	static int[][] ladder;
	static int startx,moveCount;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = 10;

		for (int t = 1; t <= T; t++) {
			int tc = Integer.parseInt(br.readLine()); // 테스트케이스 번호

			ladder = new int[100][100];

			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int minMove=Integer.MAX_VALUE;
			int bestStartx = -1;
			for (int i = 99; i >= 0; i--) {
				if (ladder[0][i] == 1) {
					arr = new boolean[100][100];
					moveCount = 0;
					down(0, i);
					
					if(moveCount<minMove) {
						minMove = moveCount;
						bestStartx = startx;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(bestStartx).append("\n");
		}
		System.out.println(sb);
	}

	static void down(int r, int c) {
		Queue<Integer[]> queue = new ArrayDeque<>();
		// 방문체크
		arr[r][c] = true;
		startx = c;
		queue.offer(new Integer[] { r, c });
		while (!queue.isEmpty()) {
			Integer[] current = queue.poll();
			int row = current[0];
			int col = current[1];
			
			// 오른쪽으로 갈 수 있을 때
			if (col + 1 < 100 && !arr[row][col + 1] && ladder[row][col+1]==1) {
				queue.add(new Integer[] { row, col+1 });
				arr[row][col+1] = true;
				moveCount++;
			}
			// 왼쪽으로 갈 수 있을 때
			else if (col - 1 >= 0 && !arr[row][col - 1] && ladder[row][col-1]==1) {
				queue.add(new Integer[] { row, col-1 });
				arr[row][col-1] = true;
				moveCount++;
			// 아래로 갈 때
			} 
			else if( row + 1 < 100 && !arr[row + 1][col] && ladder[row+1][col]==1)	{ 
				queue.add(new Integer[] { row+1, col });
				arr[row+1][col] = true;
				moveCount++;
				
				if (row+1 == 99) {
					break;
				}
			}
		}
	}
}
