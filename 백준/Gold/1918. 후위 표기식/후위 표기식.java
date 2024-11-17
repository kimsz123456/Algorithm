import java.io.*;
import java.util.*;

public class Main {
    static Map<Character, Integer> map = new HashMap<>();
    static {
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        map.put('(', 0);
        map.put(')', 0);
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String infix = br.readLine();
		System.out.println(infixToPostfix(infix));

	}
    static String infixToPostfix(String infix) {
        String postfix = "";
        Stack<Character> stack = new Stack<>();
 
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
 
            if (65 <= c && c <= 90) {
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
}