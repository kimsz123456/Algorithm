import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static String palindrome;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			if(Integer.parseInt(str)==0) {
				break;
			}
			if(palindromeTest(str))
				System.out.println("yes");
			else {
				System.out.println("no");
			}
		}
	}
    public static boolean palindromeTest(String palindrome) {
        char[] charArr = new char[palindrome.length()]; // 기존 문자열을 담을 배열
         
        for (int i =0; i<palindrome.length();i++) { //반복문을 통해 문자열을 담는다.
            charArr[i] = palindrome.charAt(i);
        }
        char[] reverseArr = new char[charArr.length]; // 회문을 담을 배열 
          
        // 원본 배열을 정방향 순회하면서 새 배열의 뒤에서부터 써주기
        for(int i=0; i<charArr.length;i++) {
            reverseArr[(charArr.length-1)-i]=charArr[i];
        }
          
        boolean ans = (Arrays.equals(charArr,reverseArr));
         
        return ans;
    }
}
