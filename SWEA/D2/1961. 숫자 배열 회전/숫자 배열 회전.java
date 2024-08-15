import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수
		
		for (int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println("#"+tc);
			for(int j=0;j<N;j++) {
				for(int i=0;i<N;i++) {
					System.out.print(arr[N-1-i][j]); // 90도
				}
				System.out.print(" ");
				for(int i=0;i<N;i++) {
					System.out.print(arr[N-1-j][N-1-i]); // 180도
				}
				System.out.print(" ");
				for(int i=0;i<N;i++) {
					System.out.print(arr[i][N-1-j]); // 270도
				}
				System.out.println();
			}
		}
	}
}