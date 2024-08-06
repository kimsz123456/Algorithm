import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		double score = 0;
		if(str.charAt(0)=='A') {
			score +=4;
			if (str.charAt(1)=='+') {
				score +=0.3;
			}
			else if(str.charAt(1)=='0') {
				score +=0;
			}
			else {
				score -=0.3;
			}
		}
		else if(str.charAt(0)=='B') {
			score +=3;
			if (str.charAt(1)=='+') {
				score +=0.3;
			}
			else if(str.charAt(1)=='0') {
				score +=0;
			}
			else {
				score -=0.3;
			}
		}
		else if(str.charAt(0)=='C') {
			score +=2;
			if (str.charAt(1)=='+') {
				score +=0.3;
			}
			else if(str.charAt(1)=='0') {
				score +=0;
			}
			else {
				score -=0.3;
			}
		}
		else if(str.charAt(0)=='D') {
			score +=1;
			if (str.charAt(1)=='+') {
				score +=0.3;
			}
			else if(str.charAt(1)=='0') {
				score +=0;
			}
			else {
				score -=0.3;
			}
		}
		else {
			score = 0;
		}
		System.out.println(score);
	}
}
