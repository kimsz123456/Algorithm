import java.io.*;

public class Main {
    static int M, N;
    static int[][] map;
    static int[][] dp;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        M = nextInt();
        N = nextInt();

        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = nextInt();
                dp[i][j] = -1;
            }
        }
        int answer = dfs(0,0);
        System.out.println(answer);
    }

    static int dfs(int r, int c) {
        if (r == M - 1 && c == N - 1) return 1;
        if (dp[r][c] != -1) return dp[r][c];

        dp[r][c] = 0;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
            if (map[nr][nc] < map[r][c]) {
                dp[r][c] += dfs(nr, nc);
            }
        }
        return dp[r][c];
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
