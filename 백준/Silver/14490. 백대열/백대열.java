import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine(),":");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int d = gcd(N,M);
        
        sb.append(N/d).append(":").append(M/d);
        System.out.print(sb);
    }
    public static int gcd(int n,int m) {
    	while (m != 0) {
            int temp = n % m;
            n = m;
            m = temp;
        }
    	return n;
    }
}
