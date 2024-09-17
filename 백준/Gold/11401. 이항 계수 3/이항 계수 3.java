import java.io.*;
import java.util.*;

public class Main {

	static int[][] dp;
	static int div = 1000000007;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		long N = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		
		
		// 분자 N!
		long number = factorial(N) % div;

		// 분모 (K! * (N-K)!)
		long denominator = factorial(K) * factorial(N - K) % div;	
		
		// 모듈로연산에서 나눗셈연산은 없으므로 분모의 역원을 곱한다.
		// 그래서 a*b mod p = ((a mod p) * (b mod p)) mod p 를 이용한다.
		// 분모의 역원은 페르마의 소정리를 이용해 a^(p-2)형태
		System.out.println(number * pow(denominator, div - 2) % div);
		
	}
	// 팩토리얼 계산
	public static long factorial(long N) {
		long num = 1;
		
		while(N > 1) {
			num = (num * N) % div;
			N--;
		}
		return num;
	}
	
	// 분할정복으로 거듭제곱하기
	public static long pow(long base, long power) {
		long result = 1;

		while (power > 0) {

			if (power % 2 == 1) {
				result *= base;
				result %= div;
			}
			base = (base * base) % div;
			power /= 2;
		}

		return result;
	}
}