import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = br.readLine();
		
		int answer = 0;
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') answer++;
		}
		
		System.out.print(answer);
    }
}
