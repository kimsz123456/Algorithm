import java.io.*;
import java.util.*;

public class Main {
	static long[] fibo;
	static int pisano = 1500000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        long N = Long.parseLong(br.readLine());
        
        // 피사노 주기 : 피보나치수를 K로 나눈 나머지는 항상 주기를 갖게된다
        // M=10^k일때, k>2이면 주기는 항상 15*10^(k-1)이다.
        
        // N을 pisano로 나눈 나머지 까지만 해보면 됨.
        N %= pisano;
        
        // 피보나치 수 + 메모이제이션
        fibo = new long[(int) N + 1];
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i <= N; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1000000;
        }
        System.out.println(fibo[(int) N]);
    }
}