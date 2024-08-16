import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 파스칼 삼각형의 크기
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = 1;
			}

			// i=1;
			int now = 1;
			int next = 1;
			System.out.println("#"+tc);
			System.out.println(arr[0]);
			for (int i = 1; i < N; i++) {
				System.out.print(arr[0]);
				if (i >= 2) {
					for (int j = 1; j < i; j++) {
						next = arr[j];
						arr[j] = now+next;
						now = next;
						System.out.print(" "+arr[j]);
					}
				}
				System.out.print(" "+arr[N-1]);
				System.out.println();
			}
		}
	}
}