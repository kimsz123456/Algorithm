import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] tmp = new int[1000000];
	static int count = 0;
	static int result = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		int N = 1000000; // 배열의 크기
		int[] A = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		merge_sort(A, 0, N - 1);
		System.out.println(A[500000]);
	}

	static void merge_sort(int[] arr, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			merge_sort(arr, p, q);
			merge_sort(arr, q + 1, r);
			merge(arr, p, q, r);
		}
	}

	static void merge(int[] arr, int p, int q, int r) {
		int i = p;
		int j = q + 1;
		int t = 0;
		while (i <= q && j <= r) {
			if (arr[i] <= arr[j]) {
				tmp[t++] = arr[i++];
			} else {
				tmp[t++] = arr[j++];
			}
			count++;
		}
		while (i <= q) {
			tmp[t++] = arr[i++];
			count++;
		}
		while (j <= r) {
			tmp[t++] = arr[j++];
			count++;
		}
		// 병합된 결과를 원래 배열에 복사
		i = p;
		t = 0;
		while (i <= r) {
			arr[i++] = tmp[t++];
		}
	}
}