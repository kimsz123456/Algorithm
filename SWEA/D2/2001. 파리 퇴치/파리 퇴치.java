import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc=0; tc<T; tc++) { // T개의 테스트케이스
			int M = sc.nextInt(); // 첫번째 입력받는 배열의크기
			int N = sc.nextInt(); // 두번째 입력받는 배열의크기
			
			int[][] arrM = new int[M][M]; // M*M 배열
			
			// M*M배열을 정방향순회로 채움
			for(int i=0; i<M;i++) { 
				for(int j=0; j<M;j++) {
					arrM[i][j] = sc.nextInt();
				}
			}
			
			int sum = 0; // 배열의 합을 담을 변수.
			
			for(int i=0; i<M-N+1;i++) {  
				for (int j=0; j<M-N+1;j++) { // arrM[i][j]를 반복문을 돌린다.
					int temp = 0; // N*N 크기의 배열의 합을 담을 변수
					for (int r=0;r<N;r++) { 
						for(int c=0; c<N;c++) { // (i,j)에서 N*N 배열의 합을 구하고 temp에 저장
							temp += arrM[i+r][j+c];
							if (sum < temp) { // temp와 sum을 비교해 더 큰값을 계속 sum에 저장
								sum = temp;
							}
						}
					}
				}
			}
			System.out.println("#"+(tc+1)+" "+sum);
		}
	}
}