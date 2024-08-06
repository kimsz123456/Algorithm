import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String answer = "";
		for(int i=0; i<str.length();i++) {
			if (Character.isUpperCase(str.charAt(i))) {// 대문자면
				answer += Character.toLowerCase(str.charAt(i));
			}
			else {
				answer +=Character.toUpperCase(str.charAt(i));
			}
		}
		System.out.println(answer);
	}
}
