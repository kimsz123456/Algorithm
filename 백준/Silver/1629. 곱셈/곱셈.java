import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        
        System.out.println(pow(A,B,C));
    }
    
	static long pow(long base, long power,long mod) {
		if(power==1) {
			return base%mod;
		}
		long temp = pow(base,power/2,mod);
		if(power%2==1) {
			return(temp*temp%mod) * base % mod;
		}
		return temp*temp%mod;
	}
}
