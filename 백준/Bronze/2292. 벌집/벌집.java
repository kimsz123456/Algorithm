import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int num=0;
		int sum=1;
		while(true) {
			if(N <= sum) {
				System.out.println(num+1);
				break;
			}
			num++;
			sum+=6*num;
		}
	}
}