import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());

		int[] course = new int[N + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			course[i] = Integer.parseInt(st.nextToken());
		}

		boolean reverse = false;
		for (int i = 1; i <= N; i++) {
			K -= course[i];
			if (K < 0) {
				System.out.println(i);
				reverse = true;
				break;
			}
		}
		if (!reverse) {
			for (int i = N ; i >= 1; i--) {
				K -= course[i];
				if (K < 0) {
					System.out.println(i);
					break;
				}
			}
		}
	}

}
