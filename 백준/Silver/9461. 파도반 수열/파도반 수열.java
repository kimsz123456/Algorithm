import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        long[] P = new long[101];
        P[1]=1;
        P[2]=1;
        P[3]=1;
        P[4]=2;
        P[5]=2;
        P[6]=3;
        for(int i =6;i<=100;i++) {
        	P[i]=P[i-1]+P[i-5];
        }
        
        for(int tc=1;tc<=T;tc++) {
        	
        	sb.append(P[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }
}