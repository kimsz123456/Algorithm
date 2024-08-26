import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test3_서울_05_김지승 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); // 어장 한변의 길이
			int M = Integer.parseInt(st.nextToken()); // 그물 한변의 길이
			
			// 어장을 만들때 그물크기를 고려해서 크게만든다.
			int[][] arr = new int[N+(M-1)*2][N+(M-1)*2]; // 어장
			
			// 어장 정보 입력 입력또한 가운데에 받는다.
			for(int i=M-1;i<N+M-1;i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for(int j=M-1;j<N+M-1;j++) {
					arr[i][j]=Integer.parseInt(st2.nextToken());
				}
			}
			
			// sum은 어획량
			// max는 최대어획량을 담을 변수
			int sum =0;
			int max =0; // 최대어획량이 음수이면 0 출력.
			// 커진 어장에서 배열을 순회하며 어획량을 구하고 최대어획량을 구한다.
			for(int i=0;i<N+M-1;i++) {
				for(int j=0;j<N+M-1;j++) {
					sum=0;
					
					// 커진 어장의 i,j에서 M*M크기의 그물을 펼쳐 어획량을 구함.
					for(int r=i;r<i+M;r++) {
						for(int c=j;c<j+M;c++) {
							sum+=arr[r][c];
						}
					}
					max = Math.max(max, sum);	// 최대어획량
				}
			}
			
			// 출력
			System.out.println("#"+tc+" "+max);
		}
	}
}