import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[] { A, 1 });

        int result = -1;
        while (!queue.isEmpty()) {
            long[] current = queue.poll();
            long now = current[0];
            int cnt = (int) current[1];

            if (now == B) {
                result = cnt;
                break;
            }

            long nexta = now * 2;
            long nextb = now * 10 + 1;

            if (nexta <= B) {
                queue.add(new long[] { nexta, cnt + 1 });
            }
            if (nextb <= B) {
                queue.add(new long[] { nextb, cnt + 1 });
            }
        }

        System.out.println(result);
    }
}
