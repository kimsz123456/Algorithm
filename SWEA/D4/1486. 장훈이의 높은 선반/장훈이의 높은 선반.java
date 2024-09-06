import java.io.*;
import java.util.*;

public class Solution {
	static int N,B,min;
	static int[] height;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=1;tc<=T;tc++) {
        	st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	B = Integer.parseInt(st.nextToken());
        	
        	height = new int[N];
        	st = new StringTokenizer(br.readLine());
        	for(int i=0;i<N;i++) {
        		height[i]=Integer.parseInt(st.nextToken());
        	}
        	min = Integer.MAX_VALUE;
        	makeTeam(0,0);
        	sb.append("#").append(tc).append(" ").append(min-B).append("\n");
        }
        System.out.println(sb);
        
    }
    
    static void makeTeam(int idx,int sum) {
    	if(idx==N) {
    		if(sum>=B) {
    			min = Math.min(min, sum);
    		}
    		return;
    	}
    	if(sum>=B) {
    		min = Math.min(min, sum);
    		return;
    	}
    	makeTeam(idx+1,sum);
    	if(sum<B) {
    		makeTeam(idx+1,sum+height[idx]);
    	}
    }
}
