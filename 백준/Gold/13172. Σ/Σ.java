import java.io.*;
import java.util.*;

public class Main {
	static int MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int M = Integer.parseInt(in.readLine());
		long result = 0;
		int N, S;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken()) % MOD;
			S = Integer.parseInt(st.nextToken()) % MOD;
			result = (result + calc(S, N)) % MOD;
		}

		System.out.println(result);
	}

	private static long pow(int a, int b) {
		if (b == 1)
			return a;
		long res = pow(a, b / 2);
		res = res * res % MOD;
		return b % 2 != 0 ? res * a % MOD : res;
	}

	private static int gcd(int a, int b) {
		if (a < b) {
			int tmp = a;
			a = b;
			b = tmp;
		}

		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	private static long calc(int a, int b) {
		int g = gcd(a, b);
		a /= g;
		b /= g;

		return (long) a % MOD * pow(b, MOD - 2) % MOD;
	}
}