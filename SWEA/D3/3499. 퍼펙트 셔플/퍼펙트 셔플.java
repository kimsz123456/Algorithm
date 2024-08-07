import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 갯수

		Queue<String> queue = new LinkedList<>();	// 큐 구현

		for (int tc = 1; tc <= T; tc++) {	// tc동안 반복
			
			int num = Integer.parseInt(br.readLine());	// 카드 갯수
			StringTokenizer st = new StringTokenizer(br.readLine());	// 카드 이름

			String upper = "";	// 상단
			String lower = "";	// 하단
			
			for (int i = 0; i < num; i++) {
				if (i < Math.ceil((double) num/2)) {	// 홀수개일 경우 상단에
					upper += st.nextToken() + " ";
				} else {
					lower += st.nextToken() + " ";
				}
			}
			
			StringTokenizer st1 = new StringTokenizer(upper);	// upper 토큰화
			StringTokenizer st2 = new StringTokenizer(lower);	// lower 토큰화

			int countupper = st1.countTokens();	// 상단카드갯수
			int countlower = st2.countTokens();	// 하단카드갯수
			
			if (countupper == countlower) {	// 짝수개라서 둘다 같을때
				for (int i = 0; i < countlower; i++) {
					queue.add(st1.nextToken());
					queue.add(st2.nextToken());
				}
			}
			else {	// 홀수개라서 상단이 더 많을때
				for (int i = 0; i < countlower; i++) {
					queue.add(st1.nextToken());
					queue.add(st2.nextToken());
				}
				queue.add(st1.nextToken());	//상단하나추가
			}
			
			// 출력
			System.out.print("#"+tc);
			while(!queue.isEmpty()) {
				System.out.print(" "+queue.poll());
			}
			System.out.println();
		}
	}
}
