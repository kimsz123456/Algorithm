import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

		for (int num = 1; num <= T; num++) {
			String str = String.valueOf(num);
			if (str.contains("3")||str.contains("6")||str.contains("9")) {
				for(int i =0;i<str.length();i++) {
					if(str.charAt(i)=='3'||str.charAt(i)=='6'||str.charAt(i)=='9') {
						System.out.print("-");
					}
				}
				System.out.print(" ");
			}
			else {
				System.out.print(num+" ");
			}
		}
	}
}

