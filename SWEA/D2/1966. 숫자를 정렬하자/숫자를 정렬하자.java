import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); //
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st1.nextToken());
				}
			Arrays.sort(arr); // 정렬
			System.out.print("#"+tc);
			for (int i=0;i<arr.length;i++) {
				System.out.print(" "+arr[i]);
			}
			System.out.println();
		}
	}
}