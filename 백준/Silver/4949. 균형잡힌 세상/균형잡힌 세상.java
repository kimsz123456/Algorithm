import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	while(true) {
    		String str = br.readLine();
    		if(str.equals(".")) {
    			break;
    		}
    		Stack<Character> stack = new Stack<>();
    		boolean result = true;
    		for(int i=0;i<str.length();i++) {
    			char now = str.charAt(i);
    			switch(now) {
    			case '(':
    				stack.add(now);
    				break;
    			case '[':
    				stack.add(now);
    				break;
    			case ']':
    				if(!stack.isEmpty()) {
    					if(stack.peek()=='[') {
    						stack.pop();
    					}
    					else {
    						result=false;
    					}
    				}
    				else {
    					result=false;
    				}
    				break;
    			case ')':
    				if(!stack.isEmpty()) {
    					if(stack.peek()=='(') {
    						stack.pop();
    					}
    					else {
    						result=false;
    					}
    				}
    				else {
    					result=false;
    				}
    				break;
    			}
    			if(!result) {
    				break;
    			}
    		}
    		if(!stack.isEmpty()) {
    			result=false;
    		}
    		if(result) {
    			System.out.println("yes");
    		}
    		else {
    			System.out.println("no");
    		}
    	}
    }
}
