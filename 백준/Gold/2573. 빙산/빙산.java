import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[][] iceberg;
    static boolean[][] visited;
    static Queue<int[]> iceQueue = new ArrayDeque<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        iceberg = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                iceberg[i][j] = Integer.parseInt(st.nextToken());
                if (iceberg[i][j] > 0) {
                    iceQueue.add(new int[]{i, j});
                }
            }
        }

        while (true) {
            visited = new boolean[N][M];

            if (count() >= 2) {
                System.out.println(result);
                return;
            }

            if (iceQueue.isEmpty()) {
                System.out.println(0);
                return;
            }

            melt();  // 빙산 녹이기
            result++;
        }
    }

    static int count() {
        int count = 0;
        for (int[] ice : iceQueue) {
            int r = ice[0];
            int c = ice[1];
            if (!visited[r][c] && iceberg[r][c] > 0) {
                bfs(r, c);
                count++;
            }
        }
        return count;
    }
    
    static void bfs(int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M &&
                    iceberg[nr][nc] > 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }
    static void melt() {
        int size = iceQueue.size();
        int[][] meltAmount = new int[N][M];

        for (int i = 0; i < size; i++) {
            int[] cur = iceQueue.poll();
            int r = cur[0];
            int c = cur[1];
            int melt = 0;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && iceberg[nr][nc] == 0) {
                    melt++;
                }
            }

            meltAmount[r][c] = melt;
            iceQueue.add(cur);
        }

        size = iceQueue.size();
        for (int i = 0; i < size; i++) {
            int[] cur = iceQueue.poll();
            int r = cur[0];
            int c = cur[1];

            iceberg[r][c] = Math.max(0, iceberg[r][c] - meltAmount[r][c]);

            if (iceberg[r][c] > 0) {
                iceQueue.add(cur);
            }
        }
    }
}
