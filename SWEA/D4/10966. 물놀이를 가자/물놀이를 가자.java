import java.util.*;
import java.io.*;

public class Solution {
    static char[][] map;
    static int[][] distance;
    static int N, M;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new char[N][M];
            distance = new int[N][M];
            Queue<int[]> queue = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == 'W') {
                        distance[i][j] = 0;
                        queue.add(new int[]{i, j});
                    } else {
                        distance[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                
                for (int d = 0; d < 4; d++) {
                    int nextr = row + dr[d];
                    int nextc = col + dc[d];
                    
                    if (nextr >= 0 && nextr < N && nextc >= 0 && nextc < M && distance[nextr][nextc] == Integer.MAX_VALUE) {
                        distance[nextr][nextc] = distance[row][col] + 1;
                        queue.add(new int[]{nextr, nextc});
                    }
                }
            }

            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 'L') {
                        result += distance[i][j];
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}