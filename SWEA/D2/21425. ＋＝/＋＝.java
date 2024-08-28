import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	int N = Integer.parseInt(st.nextToken());
        	
        	int count = 0;
        	while(true) {
        		if(x>N||y>N) {
        			break;
        		}
        		if(x>y) {
        			y+=x;
        			count++;
        		}
        		else {
        			x+=y;
        			count++;
        		}
        	}
        	System.out.println(count);
        }
	}
}

 