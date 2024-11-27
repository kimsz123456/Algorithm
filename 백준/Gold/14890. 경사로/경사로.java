import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		result = 0;
		int[][] field = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] arr1 = new int[N];
		int[] arr2 = new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr1[j] = field[i][j];
				arr2[j] = field[j][i];
			}
			airstrip(arr1, X);
			airstrip(arr2, X);
		}
		sb.append(result);
		System.out.println(sb);
	}

	static void airstrip(int[] arr, int X) {
		// 경사로 설치
		boolean[] lift = new boolean[arr.length];
		// 정방향
		for (int i = 0; i < arr.length - 1; i++) {
			// 올라갈때
			if (arr[i] < arr[i + 1] && arr[i] + 1 == arr[i + 1]) {
				// 경사로 설치해보기
				for (int j = X; j > 0; j--) {
					// 범위도 맞고, 평지일때
					if (i + 1 - j >= 0 && arr[i + 1 - j] == arr[i + 1] - 1 && !lift[i + 1 - j]) {
						lift[i + 1 - j] = true;
					}
					// 안맞으면
					else {
						return;
					}
				}
			}
			// 내려갈때
			else if (arr[i] > arr[i + 1] && arr[i] - 1 == arr[i + 1]) {
				// 경사로 설치해보기
				for (int j = 0; j < X; j++) {
					// 범위도 맞고, 평지일때
					if (i + 1 + j < arr.length && arr[i + 1 + j] == arr[i] - 1 && !lift[i + 1 + j]) {
						lift[i + 1 + j] = true;
					}
					// 안맞으면
					else {
						return;
					}
				}
			}
			// 평지
			else if (arr[i] == arr[i + 1]) {
				continue;
			}
			// 그 외
			else {
				return;
			}
		}
		result++;
	}
}
