import java.util.*;
import java.io.*;

public class Main {
    static long M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());

        if (N >= M) {
            System.out.println(0);
        } else {
        	long remainder = 1;
    		for (long i = 2; i <= N; i++) {
    	        remainder = remainder * i % M;
    	    }
    		System.out.print(remainder);
        }
    }
}
