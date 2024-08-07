import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 색종이 수

		int[][] area = new int[100][100]; // 색종이가 놓일 공간배열 0: 흰색 1: 검은색
		int result = 0; // 검은 영역의 넓이

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); // 색종이 정보를 읽어온다.

			int r = Integer.parseInt(st.nextToken()); // x좌표
			int c = Integer.parseInt(st.nextToken()); // y좌표
			int width = 10; // 가로
			int length = 10;// 세로

			// area에 (r,c)에서 x=width,y=length 색종이를 붙여서 원소값을 1로 바꾼다.
			for (int a = 0; a < width; a++) {
				for (int b = 0; b < length; b++) {
					area[a + r][b + c] = 1;
				}
			}
		}
		// area에 검은색영역의 넓이를 계산.
		for (int i = 0; i < area.length; i++) {
			for (int j = 0; j < area[0].length; j++) {
					if (area[i][j] == 1) {
						result++;
					}
			}
		}
		// 결과 출력
		System.out.println(result);
	}
}