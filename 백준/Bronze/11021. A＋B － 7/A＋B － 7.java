import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static boolean[] broken;
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for(int i=1;i<=N;i++) {
        	st = new StringTokenizer(br.readLine());
        	int A = Integer.parseInt(st.nextToken());
        	int B = Integer.parseInt(st.nextToken());
        	sb.append("Case #").append(i).append(": ").append(A+B).append("\n");
        }
        System.out.print(sb);
	}
}