import java.io.*;
import java.util.*;

public class Main {

    static class Shark implements Comparable<Shark> {
        int r, c, s, t, lv;
        Shark(int r, int c, int s, int t, int lv) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.t = t;
            this.lv = lv;
        }

        @Override
        public int compareTo(Shark other) {
            if (this.t != other.t) return this.t - other.t; // 거리가 짧은 순
            if (this.r != other.r) return this.r - other.r; // 위쪽에 있는 순
            return this.c - other.c; // 왼쪽에 있는 순
        }
    }

    static int[] dr = { -1, 0, 0, 1 };
    static int[] dc = { 0, -1, 1, 0 };
    static int N;
    static int[][] map;
    static Shark baby;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num == 9) {
                    map[i][j] = 0;
                    baby = new Shark(i, j, 2, 0, 0);
                }
            }
        }

        result = 0;
        while (bfs()) {
            // 반복적으로 BFS 호출하여 먹이 찾기
        }
        System.out.println(result);
    }

    static boolean bfs() {
        PriorityQueue<Shark> queue = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][N];
        queue.add(new Shark(baby.r, baby.c, baby.s, 0, baby.lv));
        visited[baby.r][baby.c] = true;

        while (!queue.isEmpty()) {
            Shark cur = queue.poll();
            int r = cur.r;
            int c = cur.c;
            int s = cur.s;
            int t = cur.t;
            int lv = cur.lv;

            // 먹이를 찾으면 상어 위치 갱신하고 시간 추가
            if (map[r][c] != 0 && map[r][c] < s) {
                map[r][c] = 0;
                baby.r = r;
                baby.c = c;
                baby.lv = lv + 1;
                if (baby.lv == s) {
                    baby.s++;
                    baby.lv = 0;
                }
                result += t;
                return true;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] <= s) {
                    queue.add(new Shark(nr, nc, s, t + 1, lv));
                    visited[nr][nc] = true;
                }
            }
        }
        return false; // 먹이를 더 이상 찾을 수 없는 경우
    }
}
