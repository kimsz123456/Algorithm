import java.util.*;
import java.io.*;

public class Solution {
    static int N;
    static boolean[][] visited;
    static int[][] arr;
    static int count;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            visited = new boolean[N][N];

            int max = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] > max) {
                        max = arr[i][j];
                    }
                }
            }

            int result = Integer.MIN_VALUE;
            for (int num = 0; num < max; num++) {
                count = 0;
                visited = new boolean[N][N];
                bfs(num);
                result = Math.max(result, count);
            }
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }

        System.out.print(sb.toString());
    }

    public static void bfs(int num) {
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] > num && !visited[i][j]) {
                    queue.offer(new int[] { i, j });
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int row = current[0];
                        int col = current[1];
                        for (int d = 0; d < dr.length; d++) {
                            int nextr = row + dr[d];
                            int nextc = col + dc[d];
                            if (nextr < 0 || nextr >= N || nextc < 0 || nextc >= N || visited[nextr][nextc] || arr[nextr][nextc] <= num) {
                                continue;
                            }
                            queue.add(new int[] { nextr, nextc });
                            visited[nextr][nextc] = true;
                        }
                    }
                    count++;
                }
            }
        }
    }
}