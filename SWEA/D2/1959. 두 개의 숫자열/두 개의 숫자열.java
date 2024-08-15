import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] A = new int[N];
			int[] B = new int[M];
			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			for (int j = 0;j < M;j++) {
				B[j] = sc.nextInt();
			}
			int max = Integer.MIN_VALUE;
			int sum = 0;
			if(N>M) {
				for(int i=0;i<=(N-M);i++) {
					sum = 0;
					for(int j=0;j<M;j++) {
						sum += A[j+i]*B[j];
					}
					max = Math.max(sum,max);
				}
			}
			else {
				for(int i=0;i<=(M-N);i++) {
					sum = 0;
					for(int j=0;j<N;j++) {
						sum += A[j]*B[j+i];
					}	
					max = Math.max(sum,max);
				}
			}
			System.out.println("#"+tc+" "+max);
		}
	}
}