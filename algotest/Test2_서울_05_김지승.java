import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test2_서울_05_김지승 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());	// 평원의 세로길이
			int M = Integer.parseInt(st.nextToken());	// 평원의 가로길이
			
			// 평원을 나타낼 배열
			int[][] arr = new int[N][M];
			

			
			// 초기값 arr[0][0]=1;
			int r=0;
			int c=0;
			int num=1;
			arr[r][c]=num++;
			
			// 나이트가 우측으로1칸 아래로 2칸 간다고했으므로
			// 델타 지정
			int dr = 2;
			int dc = 1;
			// 다음위치 nr,nc
			int nr=r+dr;
			int nc=c+dc;
			
			// 반복횟수
			int count=1;
			
			// 나이트가 평원의 범위를 벗어나는 경우 반대쪽으로 되돌아오게끔 설정.
			while(count<N*M) {
				// 나이트 이동시 평원 안쪽
				if(nr<N && nc<M) {
					arr[nr][nc]=num++;
					nr = nr+dr;
					nc = nc+dc;
				}
				// 나이트 이동시 가로방향 넘어갈 때
				else if(nr<N && nc>=M) {
					arr[nr][nc-M]=num++;
					nr = nr+dr;
					nc = nc-M+dc;
				}
				// 나이트 이동시 세로방향 넘어갈 때
				else if(nr>=N && nc<M) {
					arr[nr-N][nc]=num++;
					nr = nr-N+dr;
					nc = nc+dc;
				}
				// 나이트 이동시 둘다 넘어갈 때
				else {
					arr[nr-N][nc-M]=num++;
					nr = nr-N+dr;
					nc = nc-M+dc;
				}
				// 제자리로 돌아오는 경우 break한다.
				if(nr==N&&nc==M) {
					break;
				}
				count++; // 카운트가 다되면 종료
			}
			
			System.out.print("#"+tc);
			for(int i=0;i<N;i++) {
				System.out.println();
				for(int j=0;j<M;j++) {
					System.out.print(arr[i][j]+" ");
				}
			}
		}
	}
}
