import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = stoi(br.readLine());
        st = new StringTokenizer(br.readLine());
        boolean[] visited = new boolean[N];
        int[] height = new int[N];
        for(int i=0;i<N;i++) {
            int count = stoi(st.nextToken());
            for (int j = 0; j < N; j++) {
                if (height[j] == 0) {
                    if (count == 0) {
                        height[j] = i + 1;
                        break;
                    }
                    count--;
                }
            }
        }
        for(int i=0;i<N;i++) {
            sb.append(height[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
