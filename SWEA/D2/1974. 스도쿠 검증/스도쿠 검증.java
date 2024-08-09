import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트케이스
		

		for (int tc = 1; tc <= T; tc++) { 
			int N = 9;	// 배열의 크기 9
			int[][] sudoku = new int[N][N];	// 스도쿠 판
			
			// 가로 순회
			for (int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());	
				for (int c = 0; c < N; c++) {
						sudoku[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			int answer = 0;
			if (check(N,sudoku)) {
				answer = 1;
			}
			
			System.out.println("#"+tc+" "+answer);
		}
	}
	static boolean check(int N,int[][] sudoku) {
		// 행 검증
		for (int r=0;r < N;r++) {
			boolean[] count = new boolean[10];
			for (int c=0; c<N;c++) {
				int num = sudoku[r][c];
				if(count[num]) {
					return false;
				}
				else {
					count[num] = true;
				}
			}
		}
		// 열 검증
		for (int c=0;c < N;c++) {
			boolean[] count = new boolean[10];
			for (int r=0; r<N;r++) {
				int num = sudoku[r][c];
				if(count[num]) {
					return false;
				}
				else {
					count[num] = true;
				}
			}
		}
		// 3*3 영역 검증
		boolean[][][] count = new boolean[3][3][10];
		for (int r=0;r < N;r++) {
			for (int c=0; c<N;c++) {
				int num = sudoku[r][c];
				int i = r/3;
				int j = c/3;
				if(count[i][j][num]) {
					return false;
				}
				else {
				count[i][j][num]=true;
				}
			}
		}
		return true;
	}
}