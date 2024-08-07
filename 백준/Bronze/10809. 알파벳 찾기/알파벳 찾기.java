import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int[] alphabet = new int[26];
		for(int i=0;i<alphabet.length;i++) {
			alphabet[i]=-1;
		}
		for(int i=0;i<str.length();i++) {
			if(alphabet[str.charAt(i)-'a']==-1) {
				alphabet[str.charAt(i)-'a']=i;
			}
		}
		for(int i=0;i<alphabet.length;i++){
			if(i!=alphabet.length-1) {
				System.out.print(alphabet[i]+" ");
			}
			else{
				System.out.println(alphabet[i]);
			}
		}
			
	}
}
