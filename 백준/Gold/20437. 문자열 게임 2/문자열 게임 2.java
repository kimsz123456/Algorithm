import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = stoi(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			String W = br.readLine();
			int K = stoi(br.readLine());
			
            if(K == 1) {
                System.out.println("1 1");
                continue;
            }
			
			int[] alpha = new int[26];
			for(int i=0;i<W.length();i++) {
				Character c = W.charAt(i);
				alpha[c-'a']++;
			}
			
			int min = Integer.MAX_VALUE;
			int max = -1;
			for(int i=0;i<W.length();i++) {
				Character start = W.charAt(i);
				if(alpha[start-'a']<K) continue;
				
				int count = 1;
				for(int j=i+1;j<W.length();j++) {
					Character end = W.charAt(j);
					if(start==end) count++;
					if(count == K) {
						min = Math.min(min, j-i+1);
						max = Math.max(max, j-i+1);
						break;
					}
				}
			}
			if(min == Integer.MAX_VALUE || max == -1) System.out.println("-1");
            else System.out.println(min + " " + max);
		}
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}