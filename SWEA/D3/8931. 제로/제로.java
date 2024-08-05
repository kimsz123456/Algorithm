import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int TC = Integer.parseInt(br.readLine()); // 테스트케이스 T를 입력받는다.
		
		for (int tc=1; tc<=TC;tc++) {
			int K = Integer.parseInt(br.readLine()); // 정수 K를 입력받는다.
			
			Stack<Integer> stack = new Stack<>(); // 정수형 스택 선언
			int sum = 0; // 스택의 합
			for(int i=0;i<K;i++) {	// K번 반복
				int a = Integer.parseInt(br.readLine()); // 입력받은 정수 저장
				if (a!=0) { // 들어온 정수가 0이아니면
					stack.push(a); // 넣기
					continue; // 다음반복으로
				}
				if (stack.isEmpty()) { // 스택이 비어있으면 0이어도 아무것도 안함
					continue;	// 아무것도 안함
				}
				stack.pop();	// 스택이 비어있지 않고 0이라면 마지막하나 꺼내기
			}
			while (!stack.isEmpty()) {	// 스택의 총합 구하는 방법 스택이 비어있을 때 까지 나오는 숫자를 다더함
	            sum += stack.pop();  // 스택에서 요소를 꺼내어 합산
	        }
			System.out.println("#"+tc+" "+sum);
		}
	}
}