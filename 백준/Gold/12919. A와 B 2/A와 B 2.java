import java.util.*;
import java.io.*;

public class Main {
	static boolean result = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		String T = br.readLine();
		
		check(S,T);
		if(result) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
	}
	public static void check(String S,String T) {
		boolean flag = true;
		if(T.length()==S.length()) {
			for(int i=0;i<T.length();i++) {
				if(T.charAt(i)!=S.charAt(i)) {
					flag = false;
					break;
				}
			}
			if(flag) {
				result = true;
			}
		}
		else {
			if(T.charAt(T.length()-1)=='A') {
				String newT=T.substring(0,T.length()-1);
				check(S,newT);
			}
			if(T.charAt(0)=='B') {
				String newT=reverse(T);
				newT=newT.substring(0,T.length()-1);
				check(S,newT);
			}
		}
	}
	
	public static String reverse(String T) {
		String newT = "";
		for(int i=0;i<T.length();i++) {
			newT +=T.charAt(T.length()-1-i);
		}
		return newT;
	}
}