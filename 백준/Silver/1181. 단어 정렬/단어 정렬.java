import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 중복제거를 위해 hashset에 add
		HashSet<String> set = new HashSet<>();
		for(int i=0;i<N;i++) {
			set.add(br.readLine());
		}
		
		// 정렬을 위해 list로 변환
		List<String> list = new ArrayList<>(set);
		
		// collections.sort에 1. 길이가 짧은 것 부터, 2. 길이가 같으면 사전순으로
		Collections.sort(list, (s1, s2) -> {
            int length = Integer.compare(s1.length(), s2.length());
            if (length != 0) {
                return length; // 길이로 먼저 정렬
            } else {
                return s1.compareTo(s2); // 길이가 같으면 사전순으로 정렬
            }
        });
		
		// 출력
		for(String str : list) {
			System.out.println(str);
		}
	}
}