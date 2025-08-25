import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int L = Integer.parseInt(br.readLine());

		int high = 1000;
		int low = 0;

		st = new StringTokenizer(br.readLine());

		int[] arr = new int[L];
		for (int i = 0; i < L; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < L; i++) {
			int num = arr[i];

			if (num == n) {
				System.out.println(0);
				return;
			}
			if (num < n && low < num)
				low = num;
			if (num > n && high > num)
				high = num;
		}
		int result = 0;
		for (int i = (low + 1); i <= n; i++) {
			for (int j = n; j < high; j++) {
				result++;
			}
		}
		System.out.println((result - 1));
	}

}
