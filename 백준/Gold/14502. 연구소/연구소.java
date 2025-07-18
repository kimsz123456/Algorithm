import java.io.*;
import java.util.*;

public class Main {
    static int N, M, area, result;
    static int[][] lab;
    static int[][] tempLab;
    static boolean[][] visited;
    static List<int[]> list = new ArrayList<>();
    static List<int[]> selected = new ArrayList<>();
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };
    static Queue<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 세로크기 N, 가로크기 M
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 연구소 지도, 방문배열
        lab = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                // 벽을 세울 수 있는 빈칸은 list에 추가
                if (lab[i][j] == 0) {
                    list.add(new int[] { i, j });
                }
            }
        }
        // 조합
        comb(0, 0);

        // 출력
        System.out.println(result);
    }

    // 빈칸에 3개의 벽을 뽑고, BFS 혹은 DFS를 진행
    static void comb(int idx, int count) {
        // 3개를 다 뽑았으면
        if (count == 3) {
            area = 0;
            tempLab = new int[N][M];
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                tempLab[i] = Arrays.copyOf(lab[i], M);
            }
            for (int[] wall : selected) {
                tempLab[wall[0]][wall[1]] = 1;
            }
            bfs();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (tempLab[i][j] == 0) {
                        area++;
                    }
                }
            }
            result = Math.max(result, area);
            return;
        }

        // 3개의 벽을 뽑기
        for (int i = idx; i < list.size(); i++) {
            selected.add(list.get(i));
            comb(i + 1, count + 1);
            selected.remove(selected.size() - 1);
        }
    }

    // BFS
    static void bfs() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 바이러스에서 시작
                if (tempLab[i][j] == 2) {
                    queue.add(new int[] { i, j });
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        for (int d = 0; d < 4; d++) {
                            int nextr = current[0] + dr[d];
                            int nextc = current[1] + dc[d];
                            if (nextr >= 0 && nextr < N && nextc >= 0 && nextc < M && !visited[nextr][nextc]
                                    && tempLab[nextr][nextc] == 0) {
                                queue.add(new int[] { nextr, nextc });
                                visited[nextr][nextc] = true;
                                // 바이러스 전파
                                tempLab[nextr][nextc] = 2;
                            }
                        }
                    }
                }
            }
        }
    }
}