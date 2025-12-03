import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = stoi(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            int N = stoi(br.readLine());
            st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();

            for(int i=0;i<N;i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            long answer = 0;
            while(pq.size()>1) {
                long first = pq.poll();
                long second = pq.poll();

                answer += (first + second);
                pq.add(first+second);
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
