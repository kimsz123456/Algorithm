import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] adj;
	static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adj = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj[x][y] = adj[y][x] = true;
        }

        visited = new boolean[N + 1];
        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i, N);
                result++;
            }
        }

        System.out.println(result);

    }

    static void dfs(int n, int N) {
        visited[n] = true;

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && adj[i][n])
                dfs(i, N);
        }
    }
}
