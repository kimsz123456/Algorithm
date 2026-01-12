import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] dr = {0,-1,0,1};
    static int[] dc = {-1,0,1,0};
    static int[] mask = {1, 2, 4, 8};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = stoi(st.nextToken());
        N = stoi(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }

        int[][] roomId = new int[N][M];
        for (int i = 0; i < N; i++) Arrays.fill(roomId[i], -1);
        int[] roomSize = new int[N * M];

        Queue<int[]> q = new ArrayDeque<>();
        int roomCnt = 0;
        int maxRoom = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (roomId[i][j] != -1) continue;

                q.add(new int[]{i, j});
                roomId[i][j] = roomCnt;
                int size = 0;

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int r = cur[0];
                    int c = cur[1];
                    size++;

                    int status = map[r][c];
                    for (int d = 0; d < 4; d++) {
                        if ((status & mask[d]) != 0) continue;

                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (boundary(nr, nc) && roomId[nr][nc] == -1) {
                            roomId[nr][nc] = roomCnt;
                            q.add(new int[]{nr, nc});
                        }
                    }
                }

                roomSize[roomCnt] = size;
                maxRoom = Math.max(maxRoom, size);
                roomCnt++;
            }
        }

        int maxAfterRemove = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                int status = map[r][c];

                for (int d = 0; d < 4; d++) {
                    if ((status & mask[d]) == 0) continue;

                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (!boundary(nr, nc)) continue;

                    int a = roomId[r][c];
                    int b = roomId[nr][nc];
                    if (a == b) continue;

                    maxAfterRemove = Math.max(
                            maxAfterRemove,
                            roomSize[a] + roomSize[b]
                    );
                }
            }
        }

        System.out.println(roomCnt);
        System.out.println(maxRoom);
        System.out.println(maxAfterRemove);
    }

    public static boolean boundary(int r,int c) {
        return r>=0 && r<N && c>=0 && c<M;
    }

    public static Integer stoi(String str) {
        return Integer.parseInt(str);
    }
}
