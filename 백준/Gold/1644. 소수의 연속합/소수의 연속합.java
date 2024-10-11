import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		boolean[] prime = new boolean[N+1];
		Arrays.fill(prime, true);
		prime[0]=prime[1]=false;
		for(int i=2;i*i<=N;i++) {
			if(prime[i]) {
				for(int j=i*i;j<=N;j+=i) {
					prime[j]=false;
				}
			}
		}
		List<Integer> list = new ArrayList<>();
		
		for(int i=2;i<=N;i++) {
			if(prime[i]) {
				list.add(i);
			}
		}
		
		int left = 0;
		int right = 0;
		int count = 0;
		int sum = 0;
		boolean possible = false;
		while (left < list.size() && right <= list.size()) {
			if (right == list.size()) {
				if (sum < N) {
					break;
				} else if(sum > N) {
					sum -= list.get(left);
					left++;
				}
				else {
					possible = true;
					count++;
					break;
				}
			} else {
				if (sum < N) {
					sum += list.get(right);
					right++;
				} else if(sum>N){
					sum -= list.get(left);
					left++;
				}
				else {
					possible = true;
					count++;
					sum -= list.get(left);
					left++;
				}
			}
		}

		if (possible) {
			System.out.println(count);
		} else {
			System.out.println(0);
		}
	}
}