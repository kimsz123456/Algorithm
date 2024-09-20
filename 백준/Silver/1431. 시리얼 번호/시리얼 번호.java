import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		List<String> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(br.readLine());
		}

		Collections.sort(list, (s1, s2) -> {
			int length = Integer.compare(s1.length(), s2.length());
			if (length != 0) {
				return length; // 길이로 먼저 정렬
			}
			// 숫자인것만 더해서 자리수비교
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 0; i < s1.length(); i++) {
				if (Character.isDigit(s1.charAt(i))) {
					sum1 += s1.charAt(i) - '0';
				}
			}
			for (int i = 0; i < s2.length(); i++) {
				if (Character.isDigit(s2.charAt(i))) {
					sum2 += s2.charAt(i) - '0';
				}
			}
			int sum = Integer.compare(sum1, sum2);
			if (sum!=0) {
				return sum;
			}
			return s1.compareTo(s2); // 길이가 같으면 사전순으로 정렬
		});

		// 출력
		for (String str : list) {
			System.out.println(str);
		}

	}
}