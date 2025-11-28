import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        int M = nextInt();

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = nextInt();
                if (num == 1) {
                    union(i, j);
                }
            }
        }
        int city = find(nextInt() - 1);
        for (int i = 1; i < M; i++) {
            int num = nextInt() - 1;
            if (city != find(num)) {
                System.out.print("NO");
                return;
            }
        }
        System.out.print("YES");
    }

    public static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]); // 경로 압축
        }
        return parent[x];
    }

    public static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        parent[pb] = pa;
    }

    static int nextInt() throws IOException {
        int c;
        while (!Character.isDigit(c = System.in.read()))
            ;
        int value = c & 15;
        while (Character.isDigit(c = System.in.read())) {
            value = value * 10 + (c & 15);
        }
        return value;
    }
}
