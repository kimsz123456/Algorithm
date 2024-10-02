import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	
    	int[] queue = new int[10001];
    	
    	int N = sc.nextInt();
    	
    	int front = 0;
    	int back = 0;
    	for(int i=0;i<N;i++) {
    		String order = sc.next();
    		switch(order) {
    		case "push":
    			// 빈거임
    			int num = sc.nextInt();
    			queue[back++]=num;
    			break;
    		case "front":
    			if(front==back) {
    				System.out.println(-1);
    			}
    			else {
    				System.out.println(queue[front]);
    			}
    			break;
    		case "back":
    			if(front==back) {
    				System.out.println(-1);
    			}
    			else {
    				System.out.println(queue[back-1]);
    			}
    			break;
    		case "size":
    			System.out.println(back-front);
    			break;
    		case "empty":
    			if(front==back) {
    				System.out.println(1);
    			}
    			else {
    				System.out.println(0);
    			}
    			break;
    		case "pop":
    			if(front==back) {
    				System.out.println(-1);
    			}
    			else {
    				System.out.println(queue[front++]);
    			}
    			break;
    		}
    	}
    }
}
