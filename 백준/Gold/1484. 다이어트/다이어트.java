import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int G = Integer.parseInt(br.readLine());
        
        
        int left = 1;
        int right = (int) Math.ceil(Math.sqrt(G));
        
        boolean possible = false;
        while(right<=100000) {
        	int a = left*left;
        	int b = right*right;
        	if(b-a>G) {
        		left++;
        	}
        	else if(b-a<G) {
        		right++;
        	}
        	else {
        		possible=true;
        		sb.append(right).append("\n");
        		right++;
        	}
        }
        if(!possible) {
        	sb.append(-1);
        }
        System.out.println(sb);
    }
}
