import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		while((str = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(str);
			if(st.hasMoreTokens()) {
			int N = Integer.parseInt(st.nextToken());
			System.out.println(cantor(N));
			}
			else {
				break;
			}
		}
	}
	
	public static String cantor(int N) {
		if(N==0) {
			return "-";
		}
		else {
			StringBuilder sb = new StringBuilder();
			sb.append(cantor(N-1));
			int num = (int) Math.pow(3,N-1);
			for(int i=0;i<num;i++) {
				sb.append(" ");
			}
			sb.append(cantor(N-1));		
			return sb.toString();
		}
	}
}