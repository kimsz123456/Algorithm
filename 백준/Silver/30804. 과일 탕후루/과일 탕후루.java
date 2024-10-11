import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		int[] count = new int[10];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}
		
			int left =0;
			int right =0;
			int result = 0;
			while(right<N) {
				count[arr[right++]]++;
				while(count(count)>2) {
					count[arr[left++]]--;
				}
				result = Math.max(result, right-left);
			}
			System.out.println(result);
	}

	static int count(int[] count) {
		int cnt = 0;
		for (int i = 1; i <= 9; i++) {
			if (count[i] != 0) {
				cnt++;
			}
		}
		return cnt;
	}
}