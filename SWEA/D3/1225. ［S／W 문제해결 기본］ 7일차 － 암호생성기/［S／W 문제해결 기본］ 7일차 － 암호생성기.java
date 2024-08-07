import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10; // 테스트 케이스 갯수

		Queue<Integer> queue = new LinkedList<>(); // 큐 구현

		for (int tc = 1; tc <= T; tc++) { // tc동안 반복
			int num = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()); // 8개 데이터

			for (int i = 0; i < 8; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			int i = 1;
			while (true) {
				if (queue.peek() - i <= 0) { // peek해서 i뺐을때 0보다 작으면
					queue.poll(); // 제거하고
					queue.add(0); // 마지막에 0추가
					break; // 반복문 끝
				} 
				else {	// 문제없으면
					queue.add(queue.poll() - i);	// poll해서 i 빼고 뒤로보냄
					i=Math.max((i+1)%6, 1);	// i는 12345를 돌고 0이되면 1이됨
				}
			}
			System.out.print("#"+tc);
			while (!queue.isEmpty()) {
				System.out.print(" "+queue.poll());
			}
			System.out.println();
		}
	}
}
