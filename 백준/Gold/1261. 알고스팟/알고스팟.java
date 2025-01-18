import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[N][M];
        int[][] visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            Arrays.fill(visited[i], Integer.MAX_VALUE);
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) == '1';
            }
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)->Integer.compare(o1[2],o2[2]));
        queue.add(new int[]{0, 0, 0});
        visited[0][0] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int cnt = cur[2];

            if (r == N - 1 && c == M - 1) {
                System.out.println(cnt);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    int next = cnt + (map[nr][nc] ? 1 : 0);
                    if (next < visited[nr][nc]) {
                        visited[nr][nc] = next;
                        queue.add(new int[]{nr, nc, next});
                    }
                }
            }
        }
    }
}
