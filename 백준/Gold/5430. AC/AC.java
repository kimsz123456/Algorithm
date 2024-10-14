import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringBuilder sb = new StringBuilder();
			String command = br.readLine();

			int N = Integer.parseInt(br.readLine());

			String input = br.readLine();
			String cleaned = input.replaceAll("[\\[\\]]", ""); // 대괄호 제거
			String[] num = cleaned.split(",");


			boolean reverse = false;
			int left = 0;
			int right = N;
			boolean error = false;
			for (int i = 0; i < command.length(); i++) {
				char next = command.charAt(i);
				if (next == 'R') {
					reverse = !reverse;
				} else {
					if (left < right) {
						if (reverse) {
							right--;
						} else {
							left++;
						}
					} else {
						error = true;
						break;
					}
				}
			}
			if (error) {
				sb.append("error");
			}
			else {
				int[] arr = new int[right-left];
				sb.append("[");
				if (reverse) {
					for (int i = right - 1; i >= left; i--) {
						arr[arr.length-1-i+left] = Integer.parseInt(num[i]); // 문자열을 정수로 변환
					}
				} else {
					for (int i = left; i < right; i++) {
						arr[i-left]=Integer.parseInt(num[i]);
					}
				}
				for(int i=0;i<arr.length;i++) {
					sb.append(arr[i]);
					if(i<arr.length-1) {
						sb.append(",");
					}
				}
				sb.append("]");
			}
			System.out.println(sb);
		}

	}
}
