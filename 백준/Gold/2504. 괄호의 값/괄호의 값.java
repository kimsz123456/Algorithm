import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        char before = 0;
        int result = 0;
        int value = 1;
        for(int i=0;i<str.length();i++){
            char now = str.charAt(i);
            switch(now) {
                case '(': {
                    stack.add(now);
                    value*=2;
                    break;
                }
                case ')': {
                    if(stack.isEmpty() || stack.peek() != '(') {
                        result = 0;
                        System.out.println(result);
                        return;
                    }
                    if(before == '(') {
                        result += value;
                    }
                    value/=2;
                    stack.pop();
                    break;
                }
                case '[': {
                    stack.add(now);
                    value*=3;
                    break;
                }

                case ']': {
                    if(stack.isEmpty() || stack.peek() != '[') {
                        result = 0;
                        System.out.println(result);
                        return;
                    }
                    if(before == '[') {
                        result += value;
                    }
                    value/=3;
                    stack.pop();
                    break;
                }
            }
            before = now;
        }
        if(stack.isEmpty()){
            System.out.println(result);
        }
        else {
            System.out.println(0);
        }
    }
}