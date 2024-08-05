import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int T = 10;
			
		for (int tc=1; tc<=T;tc++) {
		
			int length = Integer.parseInt(br.readLine());	// 테스트케이스의 길이를 입력받음.
			boolean result = true;
			String str = br.readLine();
			
			// ():0 []:1 {}:2 <>:3
			Stack<Character>[] stackArr = new Stack[4]; // 스택배열 선언
			for (int i = 0; i < stackArr.length; i++) {
	            stackArr[i] = new Stack<>();
			}
			// 길이가 2의 배수가 아니면 볼필요도없음
			if (length%2==1) {
				result = false;
				System.out.println("#"+tc+" 0");
			}
			
			else { // 길이가 2의 배수시작
				// 문자열을 돌면서 push,pop 진행 조건만족안하면 그대로 break;
				for (int i = 0; i < length; i++) {
                    char c = str.charAt(i);
                    
                    // 스위치문 
                    // 여는괄호 : 그대로 푸쉬
                    // 닫는괄호 : 스택이 비어있지않고, 짝이 맞으면 pop
                    // else : result = false
                    switch (c) {
                        case '(':
                            stackArr[0].push(c);
                            break;
                        case ')':
                            if (!stackArr[0].isEmpty() && stackArr[0].peek() == '(') {
                                stackArr[0].pop();
                            } else {
                                result = false;
                            }
                            break;
                        case '[':
                            stackArr[1].push(c);
                            break;
                        case ']':
                            if (!stackArr[1].isEmpty() && stackArr[1].peek() == '[') {
                                stackArr[1].pop();
                            } else {
                                result = false;
                            }
                            break;
                        case '{':
                            stackArr[2].push(c);
                            break;
                        case '}':
                            if (!stackArr[2].isEmpty() && stackArr[2].peek() == '{') {
                                stackArr[2].pop();
                            } else {
                                result = false;
                            }
                            break;
                        case '<':
                            stackArr[3].push(c);
                            break;
                        case '>':
                            if (!stackArr[3].isEmpty() && stackArr[3].peek() == '<') {
                                stackArr[3].pop();
                            } else {
                                result = false;
                            }
                            break;
                    }
				}
				for (Stack<Character> stack : stackArr) {
		            if (!stack.isEmpty()) {
		            	result = false;
		            	break;
		            }
		        }
				if (result) {
					System.out.println("#"+tc+" 1");
				}
				else {
					System.out.println("#"+tc+" 0");
				}
			}
		}
	}
}