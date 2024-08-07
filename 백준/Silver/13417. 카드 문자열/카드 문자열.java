import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 정수 K를 입력받는다.
		
		Deque<String> deque = new ArrayDeque<>();
		
		for(int tc=0; tc<T;tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0;i<N;i++) {
				String str = st.nextToken();
				if (deque.isEmpty()) {
					deque.addFirst(str);
				}
				else if(deque.getFirst().compareTo(str)<0) {
					deque.addLast(str);
				}
				else {
					deque.addFirst(str);
				}
			}
			while(!deque.isEmpty()) {
				System.out.print(deque.pollFirst());
			}
			System.out.println();
		}
	}
}