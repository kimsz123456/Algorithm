import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] adj = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visited = new boolean[N];
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;
        long result = 0;

        for (int i = 0; i < N; i++) {
            int minNode = -1;
            int minValue = Integer.MAX_VALUE;

            for (int j = 0; j < N; j++) {
                if (!visited[j] && dist[j] < minValue) {
                    minValue = dist[j];
                    minNode = j;
                }
            }

            if (minNode == -1) break;

            visited[minNode] = true;
            result += minValue;

            for (int j = 0; j < N; j++) {
                if (!visited[j] && adj[minNode][j] != 0 && adj[minNode][j] < dist[j]) {
                    dist[j] = adj[minNode][j];
                }
            }
        }

        sb.append(result).append("\n");
        System.out.print(sb);
    }
}
