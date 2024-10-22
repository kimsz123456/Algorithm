import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<int[]> dq = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int next = Integer.parseInt(st.nextToken());

            // 윈도우 범위를 벗어난 값은 제거
            if (!dq.isEmpty() && dq.peekFirst()[1] <= i - L) {
                dq.pollFirst();
            }

            // 현재 값보다 큰 값들은 덱에서 제거 (최소값을 유지하기 위해)
            while (!dq.isEmpty() && dq.peekLast()[0] > next) {
                dq.pollLast();
            }

            // 덱에 현재 값 추가
            dq.addLast(new int[]{next, i});

            // 덱의 첫 번째 값이 현재 윈도우에서의 최소값
            sb.append(dq.peekFirst()[0]).append(" ");
        }

        System.out.println(sb);
    }
}