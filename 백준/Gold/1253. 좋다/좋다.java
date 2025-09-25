import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	st = new StringTokenizer(br.readLine());
    	int[] numbers = new int[N];
    	for(int i=0;i<N;i++) {
    		numbers[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(numbers);
    	int answer = 0;
    	for(int i=0;i<N;i++) {
    		int target = numbers[i];
    		int left = 0;
    		int right = N-1;
    		while(left<right) {
    			int sum = numbers[left]+numbers[right];
    			if(sum<target) {
    				left++;
    			}
    			else if(sum>target) {
    				right--;
    			}
    			else {
    				if(left==i) {
    					left++;
    				}
    				else if(right==i) {
    					right--;
    				}
    				else {
    					answer++;
    					break;
    				}
    			}
    		}
    	}
    	System.out.print(answer);
    }
}
