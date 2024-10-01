import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		// 정렬
		Arrays.sort(A);

		int M = Integer.parseInt(br.readLine());// M 필요없음

		st = new StringTokenizer(br.readLine());

		int num;
		for (int i = 0; i < M; i++) {
			num = Integer.parseInt(st.nextToken());
			int left = 0, right = N - 1;
			boolean result = false;
			while (left <= right) {
				int mid = (left + right) >> 1;
				int halfVal = A[mid];
				if (num > halfVal) {
					left = mid + 1;
				}
				else if (num < halfVal) {
					right = mid - 1;
				}
				else if (num == halfVal) {
					result = true;
					break;
				}
			}
			if (result)
				sb.append("1\n");
			else
				sb.append("0\n");
		}

		System.out.print(sb);
	}
}