import java.io.*;
import java.util.*;



public class Solution {
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N, K;
    static StringBuilder sb = new StringBuilder();
    static class information {
        int row, col, len, height;
        boolean chance;
        boolean[][] visited;  // 각 인스턴스가 가진 visited 배열

        information(int row, int col, int len, int height, boolean chance,boolean[][] visited) {
            this.row = row;
            this.col = col;
            this.len = len;
            this.height = height;
            this.chance = chance;
            this.visited = visited;  // 현재 위치 방문 처리
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 지도의 크기
            K = Integer.parseInt(st.nextToken()); // 최대 공사 가능 깊이

            map = new int[N][N];

            int max = Integer.MIN_VALUE;

            // 지도 입력 및 최대값 찾기
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] > max) {
                        max = map[i][j];
                    }
                }
            }

            // 큐 생성
            Queue<information> queue = new ArrayDeque<>();

            // 가장 높은 봉우리를 큐에 추가
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == max) {
                    	boolean[][] visited = new boolean[N][N];
                    	visited[i][j]=true;
                        queue.add(new information(i, j, 1 ,map[i][j],true,visited)); // {row, col, path_length, used_chance}
                    }
                }
            }

            int maxLength = 0;

            while (!queue.isEmpty()) {
                information cur = queue.poll();
                maxLength = Math.max(maxLength, cur.len);
                
                for (int d = 0; d < 4; d++) {
                    int nextr = cur.row + dr[d];
                    int nextc = cur.col + dc[d];

                    if (nextr >= 0 && nextr < N && nextc >= 0 && nextc < N && !cur.visited[nextr][nextc]) {
                    	if (map[nextr][nextc] < cur.height) {
                    		boolean[][] deepcopy = new boolean[N][N];
                    		for(int i=0;i<N;i++) {
                    			for(int j=0;j<N;j++) {
                    				deepcopy[i][j]=cur.visited[i][j];
                    			}
                    		}
                    		deepcopy[nextr][nextc]=true;
                    		queue.add(new information(nextr, nextc, cur.len + 1, map[nextr][nextc],cur.chance,deepcopy));
                    	}
                    	else if (cur.chance &&  map[nextr][nextc] - K < cur.height) {
                    		boolean[][] deepcopy = new boolean[N][N];
                    		for(int i=0;i<N;i++) {
                    			for(int j=0;j<N;j++) {
                    				deepcopy[i][j]=cur.visited[i][j];
                    			}
                    		}
                    		deepcopy[nextr][nextc]=true;
                    		queue.add(new information(nextr, nextc, cur.len + 1, cur.height-1,false,deepcopy));
                    	}
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(maxLength).append("\n");
        }
        System.out.print(sb);
    }
}
