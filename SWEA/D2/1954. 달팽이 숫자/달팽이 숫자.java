import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	// 우 하 좌 상 순으로 꺾어야한다.
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 테스트케이스
		
		for (int tc=0; tc<T; tc++) { // T개의 테스트케이스
			int N = sc.nextInt();
			
			int[][] arr = new int[N][N];
			
			int r=0; // 로우
			int c=0; // 컬럼
			int d=0; // 델타 0우 1하 2좌 3상
			int cnt=0; // 1부터 찍을거다.
			
			while(cnt<N*N) { // cnt가 N*N이될때까지 돌리고 종료
				cnt++;
				arr[r][c] = cnt;
				if(r+dr[d] < N && c+dc[d] < N && r+dr[d]>=0 && c+dc[d]>=0) { // 델타를 적용한 좌표가 밖으로 나가지 않을 때 델타를 적용
					if(arr[r+dr[d]][c+dc[d]] !=0) { // 델타를 쭉 돌다가 0이아닌 값을 만나면
						d= (d+1)%4; // 90도 회전!
						r = r+dr[d];
						c = c+dc[d];
					}
					else {
						r = r+dr[d];
						c = c+dc[d];
					}
				}
				else { // 델타를 더한 값이 배열의 범위를 넘어가면
					d = (d+1)%4; // 90도 회전!
					r = r+dr[d];
					c = c+dc[d];
				}
			}
			System.out.println("#"+(tc+1));
			for(int i=0;i<N;i++) {
				for(int j=0; j<N;j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}