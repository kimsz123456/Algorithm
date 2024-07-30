import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스
		Stack<Integer> stack = new Stack<>(); // 스택
		
		for (int tc=0; tc<T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push":
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if (stack.empty()) {
					System.out.println(-1);
				}
				else{
					System.out.println(stack.pop());
				}
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				if(stack.empty()) {
					System.out.println(1);
				}
				else {
					System.out.println(0);
				}
				break;
			case "top":
				if(stack.empty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(stack.peek());
				}
				break;
			}
		}
	}	
}