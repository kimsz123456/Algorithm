import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			int score = 0;
			int cnt = 0;
			String str = br.readLine();

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == 'X') {
					cnt = 0;
					continue;
				} 
				else if (str.charAt(i) == 'O') {
					score += (1 + cnt);
					cnt = cnt+1;
					continue;
				}
			}
			System.out.println(score);
		}
	}
}
