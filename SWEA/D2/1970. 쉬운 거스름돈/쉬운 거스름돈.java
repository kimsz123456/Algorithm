import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	// 델타는 우, 하
	static int[] dr = { 0, 1 };
	static int[] dc = { 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

		for (int tc = 1; tc <= T; tc++) {

			int sum = Integer.parseInt(br.readLine());

			int[] money = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
			int[] change = new int[money.length];
			for (int i = 0; i < money.length; i++) {
				change[i] = sum / money[i];
				sum = sum % money[i];
			}
			System.out.println("#"+tc);
			for(int i=0;i<change.length;i++) {
				System.out.print(change[i]+" ");
			}
			System.out.println();
		}
	}
}

