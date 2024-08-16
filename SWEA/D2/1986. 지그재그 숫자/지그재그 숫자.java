import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	static int[][] tree;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			int sum=0;
			for(int i=1;i<=N;i++) {
				if(i%2==1) {
					sum+=i;
				}
				else {
					sum-=i;
				}
			}
		System.out.println("#"+tc+" "+sum);
		}
		
	}
}
