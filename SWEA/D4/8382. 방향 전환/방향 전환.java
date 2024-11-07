import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
        	st = new StringTokenizer(br.readLine());
        	int xs = Integer.parseInt(st.nextToken());
        	int ys = Integer.parseInt(st.nextToken());
        	int xe = Integer.parseInt(st.nextToken());
        	int ye = Integer.parseInt(st.nextToken());
        	
        	int width = Math.abs(xe-xs);
        	int height = Math.abs(ye-ys);
        	
        	int result = 0;
        	int min = Math.min(width, height);
        	width = width-min;
        	height = height-min;
        	result+=2*min;
        	
        	if(width!=0) {
        		if(width%2==0) {
        			result+=(width*2);
        		}
        		else {
        			result+=width*2-1;
        		}
        	}
        	if(height!=0) {
        		if(height%2==0) {
        			result+=(height*2);
        		}
        		else {
        			result+=height*2-1;
        		}
        	}
        	sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}
