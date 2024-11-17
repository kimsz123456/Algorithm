import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		String bomb = br.readLine();
		int len = bomb.length();
		
		Stack<Character> stack = new Stack<>();
		
		
		for(int i=0;i<str.length();i++) {
			stack.push(str.charAt(i));
			
			if(stack.size()>=len) {
				boolean flag = true;
				for(int j=0;j<len;j++) {
					if(stack.get(stack.size()-len+j)!=bomb.charAt(j)) {
						flag=false;
						break;
					}
				}
				if(flag) {
					for(int j=0;j<len;j++) {
						stack.pop();
					}
				}
			}
		}
		
		for(char c : stack) {
			sb.append(c);
		}
		if(sb.length()==0) {
			System.out.println("FRULA");
		}
		else {
			System.out.println(sb);
		}
	}
}