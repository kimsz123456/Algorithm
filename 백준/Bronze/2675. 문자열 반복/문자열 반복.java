import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken()); // 반복횟수
			String str = st.nextToken();
			String result = "";
			for (int i = 0; i < str.length(); i++) {
				for (int j = 0; j < a; j++) {
					result += str.charAt(i);
				}
			}
			System.out.println(result);
		}
	}
}