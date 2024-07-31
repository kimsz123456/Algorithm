import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10; // 테스트케이스 10개
		
		for (int a=0; a<T; a++) { // 10개의 테스트케이스
			int N = 100;
			int tc = sc.nextInt();
			int[][] arr = new int[N][N];
			
			for (int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int sum = 0;
			// 행의 합
			for (int i=0;i<N;i++) {
				int temp = 0;
				for(int j=0;j<N;j++) {
					temp += arr[i][j];
					if (temp>sum) {
						sum = temp;
					}
				}
			}
			
			for (int j=0;j<N;j++) {
				int temp = 0;
				for(int i=0;i<N;i++) {
					temp += arr[i][j];
					if (temp>sum) {
						sum = temp;
					}
				}
			}
			int temp1 = 0;
			int temp2 = 0;
			for (int i=0;i<N;i++) {
				temp1 += arr[i][i];
				temp2 += arr[i][N-i-1];
				if (temp1 > sum) {
					sum = temp1;
				}
				else if (temp2 > sum) {
					sum = temp2;
				}
			}
			System.out.println("#"+tc+" "+sum); // 행의 합 최대값 + 열의 합 최대값 최대값
		}
	}
}