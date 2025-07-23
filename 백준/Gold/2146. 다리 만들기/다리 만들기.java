import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static List<List<int[]>> islandEdges = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = stoi(br.readLine());

        map = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = stoi(st.nextToken());
            }
        }

        numbering();

        int answer = makeBridge();
        System.out.print(answer);

    }
    public static int makeBridge() {
        int length = Integer.MAX_VALUE;

        for(List<int[]> edge : islandEdges) {
            boolean[][] visited = new boolean[N][N];
            Queue<int[]> q = new ArrayDeque<>();

            for(int[] pos : edge) {
                q.add(new int[] {pos[0], pos[1], 0});
                visited[pos[0]][pos[1]] = true;
            }

            int curIsland = map[edge.get(0)[0]][edge.get(0)[1]];

            while(!q.isEmpty()) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1], dist = cur[2];

                for(int d=0; d<4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if(!boundary(nr, nc) || visited[nr][nc]) continue;

                    if(map[nr][nc] == 0) {
                        visited[nr][nc] = true;
                        q.add(new int[] {nr, nc, dist + 1});
                    } else if(map[nr][nc] != curIsland) {
                        length = Math.min(length, dist);
                        q.clear(); // 더 짧은 다리는 없음
                        break;
                    }
                }
            }
        }

        return length;
    }

    public static void numbering() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        int idx = 2;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j] || map[i][j]==0) continue;
                q.add(new int[] {i,j});
                visited[i][j]=true;
                map[i][j]=idx;
                List<int[]> edge = new ArrayList<>();

                while(!q.isEmpty()) {
                    int[] cur = q.poll();
                    int r = cur[0];
                    int c = cur[1];
                    boolean isEdge = false;

                    for(int d=0;d<4;d++){
                        int nr = r+dr[d];
                        int nc = c+dc[d];
                        if(boundary(nr,nc)) {
                            if(map[nr][nc]==0) isEdge = true;
                            if(!visited[nr][nc] && map[nr][nc]==1){
                                visited[nr][nc]=true;
                                map[nr][nc]=idx;
                                q.add(new int[] {nr,nc});
                            }
                        }
                    }
                    if(isEdge) {
                        edge.add(new int[] {r, c});
                    }
                }

                islandEdges.add(edge);
                idx++;
            }
        }
    }

    public static boolean boundary(int r, int c){
        return r>=0 && r<N && c>= 0 && c<N;
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }

    public static void debug() {
        for(int i=0;i<N;i++){
            System.out.println(Arrays.toString(map[i]));
        }
    }
}