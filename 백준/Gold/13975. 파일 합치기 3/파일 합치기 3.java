import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int T = nextInt();
        for(int tc=1;tc<=T;tc++) {
            int N = nextInt();
            PriorityQueue<Long> pq = new PriorityQueue<>();

            for(int i=0;i<N;i++) {
                pq.add((long) nextInt());
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

    static int nextInt() throws IOException {
        int c;
        while (!Character.isDigit(c = System.in.read()));
        int value = c & 15;
        while (Character.isDigit(c = System.in.read())) {
            value = value * 10 + (c & 15);
        }
        return value;
    }
}
