import java.io.*;
import java.util.*;

public class Main {
    static class Work {
        int deadline, score;
        Work(int d, int s) { deadline=d; score=s; }
    }

    static int[] parent;

    static int find(int x) {
        if (x <= 0) return 0;
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        List<Work> list = new ArrayList<>();
        int maxDay = 0;

        for(int i=0;i<N;i++) {
            int d = nextInt();
            int s = nextInt();
            list.add(new Work(d, s));
            maxDay = Math.max(maxDay, d);
        }

        // 점수 내림차순 정렬
        list.sort((a, b) -> b.score - a.score);

        parent = new int[maxDay+1];
        for (int i=1;i<=maxDay;i++) parent[i] = i;

        int answer = 0;
        for (Work w : list) {
            int avail = find(w.deadline);
            if (avail > 0) {
                answer += w.score;
                union(avail, avail-1); // 그 날 사용 → 바로 점프
            }
        }

        System.out.println(answer);
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
