import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

	static Map<Character, Integer> map = new HashMap<>();
	static {
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
//		map.put('(', 0);
	}

	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = 10; // 테스트 케이스 갯수
    	Stack<String> stack = new Stack<>();
    	
    	// 테스트케이스만큼 반복
    	for (int tc=1;tc<=T;tc++) {
    		int length = Integer.parseInt(br.readLine()); // 문자열의 길이 -> 중요한가?
    		String str = br.readLine();
    		System.out.println("#"+tc+" "+evaluate(str));
    	}
    }
    
    // 중위표기를 -> 후위표기로 바꾸기 -> 후위표기 계산
    static int evaluate(String expression) {
		String postfix = infixToPostfix(expression);
		return evalPostfix(postfix);
	}
    // 중위표기 -> 후위표기로 바꾸기
	static String infixToPostfix(String infix) {
		String postfix = "";
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);

			if ('0' <= c && c <= '9') {
				// 피연산자가 나오면 바로 출력
				postfix += c;
			} else if (c == '(') {
				// 여는 괄호는 스택에 push
				stack.push(c);
			} else if (c == ')') {
				// 닫는 괄호는 여는 괄호가 나올 때까지 pop
				char popItem = stack.pop();
				while (popItem != '(') {
					postfix += popItem;
					popItem = stack.pop();
				}
			} else {
				// 연산자
				// 스택의 마지막에
				// 우선순위가 낮은 연산자가 올 때까지 pop
				while (!stack.isEmpty() && stack.peek() != '(' && map.get(stack.peek()) >= map.get(c)) {

					char popItem = stack.pop();
					postfix += popItem;
				}

				stack.push(c);
			}
		}

		// 스택 비워주기
		while (!stack.isEmpty()) {
			postfix += stack.pop();
		}

		return postfix;
	}

	// 후위표기 계산하기
	static int evalPostfix(String postfix) {

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);

			if ('0' <= c && c <= '9') {
				stack.push(c - '0');
			} else {
				int num2 = stack.pop();
				int num1 = stack.pop();
				int result;

				if (c == '+') {
					result = num1 + num2;
				} else if (c == '-') {
					result = num1 - num2;
				} else if (c == '*') {
					result = num1 * num2;
				} else {
					result = num1 / num2;
				}

				stack.push(result);
			}
		}

		return stack.pop();
	}
}    
