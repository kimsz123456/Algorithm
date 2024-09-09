import java.io.*;
import java.util.*;

public class Solution {
	static long result;
	static int N;
	static Node[] list;
	static boolean[] selected;
	public static class Node {
		long x, y;

		Node(int x, int y) {
			this.x = (long) x;
			this.y = (long) y;
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=1;tc<=T;tc++) {
        	N = Integer.parseInt(br.readLine());
        	
        	list = new Node[N];
        	selected = new boolean[N];
        	
        	for(int i=0;i<N;i++) {
        		st = new StringTokenizer(br.readLine());
        		list[i]= new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        	}
        	result = Long.MAX_VALUE;
        	perm(0,0);
        	sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
    
    static void perm(int idx, int count) {
    	if (count == N/2) {
    	    long x=0,y=0;
    	    for(int i=0;i<N;i++) {
    	        if (selected[i]) {
    	            x+= list[i].x;
    	            y+= list[i].y;
    	        }
    	        else {
    	            x-= list[i].x;
    	            y-= list[i].y;
    	        }
    	    }
    	    result = Math.min(result, x*x+y*y);
    	    return;
    	}
    	for(int i=idx;i<N;i++) {
    		if(!selected[i]) {
    			selected[i]=true;
    			perm(i+1,count+1);
    			selected[i]=false;
    		}
    	}
    }
}