import java.util.*;
import java.io.*;

public class Algo1_서울_05_김지승 {
	// 별을 체크할 boolean 배열
	static boolean[][] arr;
	// 배열의 크기
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());	// 테스트 케이스
		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());	// 배열의 크기
			
			arr = new boolean[N][N];	// 배열
			String str = br.readLine();	// 명령을 string으로 입력받음
			
			// str을 돌며 입력이 들어오면, start메서드를 실행
			for (int i = 0; i < str.length(); i++) {
				int A = Integer.valueOf(str.charAt(i) - '0');
				start(A);
			}
			// 출력(별이 놓여있으면(true) 별출력, 별이 놓여있지 않으면(false) 공백출력) 
			System.out.print("#"+tc);
			for(int i=0;i<arr.length;i++) {
				System.out.println();
				for(int j=0;j<arr[i].length;j++) {
					if(arr[i][j]) {
						System.out.print("*");
					}
					else {
						System.out.print(" ");
					}
				}
			}
		}
	}
	// start메서드
	public static void start(int A) {
		// A열에 별을 놓는다. 열을 순회하며 아래부터 false이면 별을 놓는다. 이때 모두 true이면 아무것도 실행되지 않는다(별이 꽉찬 상태이면 무시)
		for (int i = N - 1; i >= 0; i--) {
			if (arr[i][A]) {
				continue;
			} else {
				arr[i][A] = true;
				break;
			}
		}
		
		
		// 행이 꽉찼는지 체크
		boolean Break = true;
		
		// N-1행의 행을 순회하며 모두 true이면 Break변수는 true이고, 하나라도 false라면 false이다.
		for (int i = 0; i < N; i++) {
			if (!arr[N - 1][i]) {
				Break = false;
				break;
			}
		}
		
		// Break 변수가 true이면
		if (Break) {
			for (int i = 0; i < N; i++) {
				// boolean스택을 생성하고, N-2부터 0까지 열의 값을 스택에 담는다.
				Stack<Boolean> stack = new Stack<>();
				for (int j = N - 2; j >= 0; j--) {
					stack.add(arr[j][i]);
				}
				
				// 1부터 N-1까지 스택의 값을 빼내어 배열에 입력한다.
				for (int j = 1; j <= N - 1; j++) {
					arr[j][i] = stack.pop();
				}
				
				// 가장 윗줄은 다시 false로 바꾼다.
				arr[0][i] = false;
			}
		}
	}
}