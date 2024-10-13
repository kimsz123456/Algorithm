import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=1;tc<=T;tc++) {
        	
        	st = new StringTokenizer(br.readLine());
        	
        	int M = Integer.parseInt(st.nextToken());
        	int N = Integer.parseInt(st.nextToken());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	
        	int lcm = M * N / gcd(M, N);
            int num = 0;
            int result = -1;
            while (num * M < lcm) {
                if ((num * M + x - y) % N == 0) {
                    result = num * M + x;
                    break;
                }
                num++;
            }

            System.out.println(result);
        }
    }

    static int gcd(int n1, int n2) {
        if (n2 == 0)
            return n1;
        return gcd(n2, n1 % n2);
    }
}