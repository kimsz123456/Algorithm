import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스
		
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); // 배열의 크기
			int M = Integer.parseInt(st.nextToken()); // 파동 시작값
			int R = Integer.parseInt(st.nextToken()); // 행
			int C = Integer.parseInt(st.nextToken()); // 열
			int D = Integer.parseInt(st.nextToken()); // 증감
			
			int[][] arr = new int [N][N];
			
			int count = 0;
			if(D>0) {
				count=N;
			}
			else {
				count = -M/D +1;
			}
			for (int i=count;i>=0;i--) {
				for(int r=R-1-i;r<=R-1+i;r++) {
					for(int c=C-1-i;c<=C-1+i;c++) {
						if(r>=0&&r<N&&c>=0&&c<N)
							arr[r][c]=Math.min(Math.max(M+i*D,0),255);
					}
				}
			}
			int sum=0;
			System.out.print("#"+tc);
			for(int i=0;i<arr.length;i++) {
				sum=0;
				for(int j=0;j<arr[i].length;j++) {
					sum+=arr[i][j];
				}
				System.out.print(" "+sum);
			}
			System.out.println();
		}
	}
}
/*
3
7 5 3 3 2
10 10 7 8 -3
10 100 7 8 100
*/