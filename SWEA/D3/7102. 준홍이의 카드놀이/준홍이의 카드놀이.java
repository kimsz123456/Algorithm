import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(br.readLine()); // 테스트 케이스 갯수
    	
    	Queue<Integer> queue = new LinkedList<>();

    	for (int tc=1;tc<=T;tc++ ) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		
    		int N = Integer.parseInt(st.nextToken());
    		int M = Integer.parseInt(st.nextToken());
    		
    		int[] arr = new int[N+M+1]; // 카운팅배열
    		
    		for (int i=1;i<=N;i++) {
    			for(int j=1;j<=M;j++) {
    				arr[i+j]++;
    			}
    		}
    		
    		for (int i=0;i<arr.length;i++) {
    			if(queue.isEmpty()) {
    				queue.add(i);
    			}
    			else if(arr[queue.peek()]>arr[i]){
    				continue;
    			}
    			else if(arr[queue.peek()]==arr[i]){
    				queue.add(i);
    			}
    			else { // arr[queue.peek()]<arr[i]
    				while(!queue.isEmpty()) {
    					queue.poll();
    				}
    				queue.add(i);
    			}
    		}
    		System.out.print("#"+tc);
    		while(!queue.isEmpty()) {
    			System.out.print(" "+queue.poll());
    		}
    		System.out.println();
    	}
    	
	}
}    
