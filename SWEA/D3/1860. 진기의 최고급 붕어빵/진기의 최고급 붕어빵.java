import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st1.nextToken()); // 자연수 N 손님수
			int M = Integer.parseInt(st1.nextToken()); // 자연수 M 만드는데 걸리는 시간
			int K = Integer.parseInt(st1.nextToken()); // 자연수 K 만들때마다 나오는 붕어빵 갯수

			StringTokenizer st2 = new StringTokenizer(br.readLine());

			int[] arr = new int[N]; // 손님배열
			boolean result = true; // 결과값

			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st2.nextToken()); // 손님오는시간
				if (num < M) { // 오는시간이 처음만드는시간보다 작으면
					result = false; // 실패
					break;
				}
				num = (int) Math.floor((double) num / M); // 몇번만에 만들어야하는지
				arr[i] = num; // 그걸 담은 배열
			}
			Arrays.sort(arr); // 정렬
			if (result) {
				for (int i = 0; i < arr.length; i++) {
					if (K < 2) {
						if (arr[i] >= i + 1) {
							continue;
						} else {
							result = false;
							break;
						}
					}
					if (arr[i] >= ((i/K)+1)) {
						if (arr[i] >= N * K) {
							break;
						}
						continue;
					} else {
						result = false;
						break; // 조건을 만족하지 않으면 반복문을 중단합니다.
					}
				}
			}

			if (result) {
				System.out.println("#" + tc + " Possible");
			} else {
				System.out.println("#" + tc + " Impossible");
			}
		}
	}
}