import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 첫째줄 : 원본 암호문의 길이

			StringTokenizer st1 = new StringTokenizer(br.readLine()); // 둘째줄 : 원본 암호문

			LinkedList<Integer> list = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				list.addLast(Integer.parseInt(st1.nextToken())); // 암호문을 연결리스트에 add
			}

			int num = Integer.parseInt(br.readLine()); // 셋째줄 : 명령어의 갯수

			StringTokenizer st2 = new StringTokenizer(br.readLine()); // 넷째줄 : 명령어

			for (int i = 0; i < num; i++) {
				String str = st2.nextToken(); // 명령어
				if (str.equals("I")) {
					int a = Integer.parseInt(st2.nextToken()); // 삽입위치
					int b = Integer.parseInt(st2.nextToken()); // 삽입갯수
					for (int j = 0; j < b; j++) {
						list.add(a + j, Integer.parseInt(st2.nextToken()));
					}
				}
				else if(str.equals("D")) {
					int a = Integer.parseInt(st2.nextToken()); // 삭제위치
					int b = Integer.parseInt(st2.nextToken()); // 삭제갯수
					for (int j = 1; j <= b; j++) {
						list.remove(a+j);
					}
				}
				else {
					int b = Integer.parseInt(st2.nextToken()); // 삽입갯수
					for (int j = 0; j < b; j++) {
						list.add(Integer.parseInt(st2.nextToken()));
					}
				}
			}
			System.out.print("#" + tc);
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + list.get(i));
			}
			System.out.println();
		}
	}
}
