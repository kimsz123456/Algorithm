import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[] prime = new boolean[M+1];
		Arrays.fill(prime, true);
		prime[0]=prime[1]=false;
		for(int i=2;i*i<=M;i++) {
			if(prime[i]) {
				for(int j=i*i;j<=M;j+=i) {
					prime[j]=false;
				}
			}
		}
		
		for(int i=N;i<=M;i++) {
			if(prime[i]) {
				System.out.println(i);
			}
		}
	}
}