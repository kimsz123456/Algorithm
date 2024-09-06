import java.util.*;
import java.io.*;
 
public class Solution {
    static int N, M, R, C, L, result;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
 
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
 
            map = new int[N][M];
            visited = new boolean[N][M];
            result = 0;
 
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    map[i][j] = num;
                }
            }
 
            // Initialize BFS
            bfs(R, C);
 
            System.out.println("#"+tc+" "+result);
        }
    }
 
    static void bfs(int startR, int startC) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startR, startC, 1});
        visited[startR][startC] = true;
        result++;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentR = current[0];
            int currentC = current[1];
            int currentT = current[2];
 
            if (currentT == L) {
                break;
            }
            switch(map[currentR][currentC]) {
            case 1:
                for(int d=0;d<4;d++) {
                    int nextR = currentR+dr[d];
                    int nextC = currentC+dc[d];
                    int nextT = currentT+1;
                    if(nextR<0 || nextR>=N || nextC<0 || nextC >=M || visited[nextR][nextC] || !canMove(d,map[nextR][nextC])) {
                        continue;
                    }
                    visited[nextR][nextC]=true;
                    queue.add(new int[] {nextR,nextC,nextT});
                    result++;
                }
                break;
            case 2:
                for(int d=0;d<4;d+=2) {
                    int nextR = currentR+dr[d];
                    int nextC = currentC+dc[d];
                    int nextT = currentT+1;
                    if(nextR<0 || nextR>=N || nextC<0 || nextC >=M || visited[nextR][nextC] || !canMove(d,map[nextR][nextC])) {
                        continue;
                    }
                    visited[nextR][nextC]=true;
                    queue.add(new int[] {nextR,nextC,nextT});
                    result++;
                }
                break;
            case 3:
            for(int d=1;d<4;d+=2) {
                int nextR = currentR+dr[d];
                int nextC = currentC+dc[d];
                int nextT = currentT+1;
                if(nextR<0 || nextR>=N || nextC<0 || nextC >=M || visited[nextR][nextC] || !canMove(d,map[nextR][nextC])) {
                    continue;
                }
                visited[nextR][nextC]=true;
                queue.add(new int[] {nextR,nextC,nextT});
                result++;
            }
            break;
            case 4:
                for(int d=0;d<2;d++) {
                    int nextR = currentR+dr[d];
                    int nextC = currentC+dc[d];
                    int nextT = currentT+1;
                    if(nextR<0 || nextR>=N || nextC<0 || nextC >=M || visited[nextR][nextC] || !canMove(d,map[nextR][nextC])) {
                        continue;
                    }
                    visited[nextR][nextC]=true;
                    queue.add(new int[] {nextR,nextC,nextT});
                    result++;
                }
                break;
                 
            case 5:
                for(int d=1;d<3;d++) {
                    int nextR = currentR+dr[d];
                    int nextC = currentC+dc[d];
                    int nextT = currentT+1;
                    if(nextR<0 || nextR>=N || nextC<0 || nextC >=M || visited[nextR][nextC] || !canMove(d,map[nextR][nextC])) {
                        continue;
                    }
                    visited[nextR][nextC]=true;
                    queue.add(new int[] {nextR,nextC,nextT});
                    result++;
                }
                break;
            case 6:
                for(int d=2;d<4;d++) {
                    int nextR = currentR+dr[d];
                    int nextC = currentC+dc[d];
                    int nextT = currentT+1;
                    if(nextR<0 || nextR>=N || nextC<0 || nextC >=M || visited[nextR][nextC] || !canMove(d,map[nextR][nextC])) {
                        continue;
                    }
                    visited[nextR][nextC]=true;
                    queue.add(new int[] {nextR,nextC,nextT});
                    result++;
                }
                break;
            case 7:
                for(int d=0;d<4;d++) {
                    if(d==1 || d==2) {
                        continue;
                    }
                    int nextR = currentR+dr[d];
                    int nextC = currentC+dc[d];
                    int nextT = currentT+1;
                    if(nextR<0 || nextR>=N || nextC<0 || nextC >=M || visited[nextR][nextC] || !canMove(d,map[nextR][nextC])) {
                        continue;
                    }
                    visited[nextR][nextC]=true;
                    queue.add(new int[] {nextR,nextC,nextT});
                    result++;
                }
                break;
            }
        }
    }
 
    static boolean canMove(int direction, int nextMap) {
        switch (direction) {
            case 0: // 상
                return nextMap == 1 || nextMap == 2 || nextMap == 5 || nextMap == 6;
            case 1: // 우
                return nextMap == 1 || nextMap == 3 || nextMap == 6 || nextMap == 7;
            case 2: // 하
                return nextMap == 1 || nextMap == 2 || nextMap == 4 || nextMap == 7;
            case 3: // 좌
                return nextMap == 1 || nextMap == 3 || nextMap == 4 || nextMap == 5;
            default:
                return false;
        }
    }
}