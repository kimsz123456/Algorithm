import java.util.*;
import java.io.*;

public class Main {
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N > 1022) { 
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < 10; i++) {
            dfs(i, 1);
        }

        Collections.sort(list);
        System.out.println(list.get(N));
    }

    public static void dfs(long num, int depth) {
        list.add(num);
        if (depth >= 10) return;

        for (int i = 0; i < 10; i++) {
            if (num % 10 > i) {
                dfs(num * 10 + i, depth + 1);
            }
        }
    }
}
