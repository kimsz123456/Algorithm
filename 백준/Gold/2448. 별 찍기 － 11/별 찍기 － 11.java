import java.util.*;
import java.io.*;

public class Main {
    
	static char[][] stars;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
				
		int N = Integer.parseInt(br.readLine());
		
		stars = new char[N][N * 2 - 1]; // 꼭대기 별이 (0,N-1)에 찍힘
		for (int i = 0; i < N; i++) {
			Arrays.fill(stars[i], ' '); // 공백으로 채움
		}
		
		star(0, N-1, N);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2 * N - 1; j++) {
				sb.append(stars[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void star(int r, int c, int N) {
		if (N == 3) {
			stars[r][c] = '*';
			stars[r + 1][c - 1] = stars[r + 1][c + 1] = '*';
			stars[r + 2][c - 2] = stars[r + 2][c - 1] = stars[r + 2][c] = stars[r + 2][c + 1] = stars[r + 2][c + 2] = '*';
			return;
		} 
		else {
			int cut = N / 2;
			star(r, c, cut);
			star(r + cut, c - cut, cut);
			star(r + cut, c + cut, cut);
		}
	}
}