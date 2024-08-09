import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스
 
        for (int tc = 1; tc <= T; tc++) {
        	String str = br.readLine();	// string으로 읽어온다.
        	int count = 0;	// 문자가 바뀐 횟수를 count에 기록한다.
        	
        	
        	if(str.charAt(0)-'0'==1) {
        		count++;
        	}
        	for(int i=1;i<str.length();i++) {
        		if(str.charAt(i-1)!=str.charAt(i)) {
        			count++;
        		}
        	}
        	
        	System.out.println("#"+tc+" "+count);
        }
    }
}
