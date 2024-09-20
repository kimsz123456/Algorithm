import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		// 해쉬맵 사용
		HashMap<String, Integer> map = new HashMap<>();

		// 숫자를 key, 개수를 value로 저장
		for (int i = 0; i < N; i++) {
			String card = br.readLine();
			map.put(card, map.getOrDefault(card, 0) + 1);
		}

		// 최대 값과 해당 카드 저장
		int maxCount = Collections.max(map.values());

		for (String key : map.keySet()) {
			if (map.get(key) == maxCount) {
				// sb가 비어있으면 추가
				if (sb.length() == 0) {
					sb.append(key);
					// sb가 차있으면 long값이 더 작은 정수를 넣음
				} else if (Long.parseLong(sb.toString()) > Long.parseLong(key)) {
					sb.delete(0, sb.length());
					sb.append(key);
				}
			}
		}
		System.out.println(sb);
	}
}
