import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1_서울_05_김지승 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());	// N개의 행
			int M = Integer.parseInt(st.nextToken());	// M개의 열
			
			Character[][] arr = new Character [N][M];	// 색깔을 담은 배열
			
			// 국기정보를 배열에 입력
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				for(int j=0;j<M;j++) {
					arr[i][j]=str.charAt(j);
				}
			}
			
			int count;
			int min = Integer.MAX_VALUE;
			
			// i는 0부터 N-2까지
			for(int i=0;i<N-1;i++) {
				// 매번 카운트를 초기화
				count = 0;
				
				// j=0부터 i까지 W가 아닌 개수를 센다.
				for(int j=0;j<=i;j++) {
					for(int k=0;k<M;k++) {
						if(arr[j][k]!='W') {
							count++;
						}
					}
				}
				// j=i+1부터 N-1까지 R이 아닌 개수를 센다.
				for(int j=i+1;j<N;j++) {
					for(int k=0;k<M;k++) {
						if(arr[j][k]!='R') {
							count++;
						}
					}
				}
				// 그래서 새로칠해야하는 개수의 최소값을 구한다.
				min = Math.min(count, min);
			}
			// 출력
			System.out.println("#"+tc+" "+min);
		}
	}
}
