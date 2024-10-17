import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int sum = Integer.MAX_VALUE;
		StringTokenizer subtraction = new StringTokenizer(br.readLine(), "-");
 
		while (subtraction.hasMoreTokens()) {
			int temp = 0;
 
			StringTokenizer addition = new StringTokenizer(subtraction.nextToken(), "+");
			 
			while (addition.hasMoreTokens()) {
				temp += Integer.parseInt(addition.nextToken());
			}
			
			if (sum == Integer.MAX_VALUE) {
				sum = temp;
			} else {
				sum -= temp;
			}
		}
		System.out.println(sum);
	}
 
}