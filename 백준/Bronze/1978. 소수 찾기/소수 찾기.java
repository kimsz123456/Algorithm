import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 자연수 N을 입력받는다.

		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;	// 소수의 개수
		
		for (int i = 0; i < N; i++) {	// N번 반복
			int num = Integer.parseInt(st.nextToken());		// 입력된 정수
			
			if (num < 2) {	// 2 보다 작으면
				continue;	// 소수아님
			}
			boolean prime = true;
			for (int j = 2; j*j <= num; j++) {
					if (num % j == 0) {	// num을 자기보다 작은수로 나눠서 나눠지면
						prime = false;	// 소수아님
					}
				}
			if (prime) {	// 소수면
				cnt++;	// 카운트 올림
			}
		}
		System.out.println(cnt);
	}
}
