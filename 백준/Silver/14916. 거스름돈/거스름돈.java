import java.io.*;
import java.util.*;

public class Main {
	static int N, result;
	static int[] memory;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		memory = new int[N + 1];
		Arrays.fill(memory, -1);
		result = -1;
		dp(0, 0);
		System.out.println(result);
	}

	static void dp(int num, int count) {
		if (num > N) {
			return;
		}

		if (memory[num] != -1 && memory[num] <= count) {
			return;
		}
		memory[num] = count;
		if (num == N) {
			result = memory[num];
			return;
		}
		dp(num + 5, count + 1);
		dp(num + 2, count + 1);
	}
}