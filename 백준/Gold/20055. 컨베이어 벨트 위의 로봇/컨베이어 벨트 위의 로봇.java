import java.io.*;
import java.util.*;

public class Main {
	static int N, K, idx;
	static int[] conveyor;
	static boolean[] robots;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		conveyor = new int[2 * N];
		robots = new boolean[2 * N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++) {
			conveyor[i] = Integer.parseInt(st.nextToken());
		}
		idx = 0;
		process();
	}

	static void process() {
		int step = 1;
		while (true) {
			rotate();
			move();
			up();
			if (K < 1) {
				System.out.println(step);
				return;
			}
			step++;
		}
	}

	static void rotate() {
		idx = (idx + (2 * N - 1)) % (2 * N);
		int exit = (idx + N - 1) % (2 * N);
		robots[exit]=false;
	}

	static void move() {

		int exit = (idx + N - 1) % (2 * N);
        for (int i = N - 2; i >= 0; i--) {
            int pos = (idx + i) % (2 * N);
            int next = (pos + 1) % (2 * N);
            
            if (robots[pos] && !robots[next] && conveyor[next] > 0) {
            	robots[pos] = false;
                conveyor[next]--;
                if (conveyor[next] == 0) {
                    K--;
                }
                if (next != exit) {
                	robots[next] = true;
                }
            }
        }
	}

	static void up() {
		if (conveyor[idx] > 0) {
			robots[idx]=true;
			conveyor[idx]--;
			if (conveyor[idx] == 0) {
				K--;
			}
		}
	}
}