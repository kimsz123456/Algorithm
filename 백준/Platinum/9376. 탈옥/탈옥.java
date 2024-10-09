import java.io.*;
import java.util.*;

public class Main {
    static int h, w;
    static char[][] map;
    static Node[] prisoners;
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };
    
    static class Node implements Comparable<Node>{
        int x, y, open;
        Node(int x, int y, int open) {
            this.x = x;
            this.y = y;
            this.open = open;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.open, o.open);
        }
    }
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new char[h+2][w+2];
            int[][] prisonerOne, prisonerTwo, out;
            prisoners = new Node[2];
            int prisonersIndex = 0;

            for (int i = 0; i < h; i++) {
                char[] row = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    if (row[j] == '$') {
                        prisoners[prisonersIndex++] = new Node(i + 1, j + 1,0);
                    }
                    map[i+1][j+1] = row[j];
                }
            }
            out = bfs(new Node(0,0,0));
            prisonerOne = bfs(prisoners[0]);
            prisonerTwo = bfs(prisoners[1]);
            System.out.println(getSum(prisonerOne, prisonerTwo, out));
        }
    }
    private static int[][] bfs(Node start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int[][] visited = new int[h+2][w+2];
        for (int[] visit: visited) {
            Arrays.fill(visit, -1);
        }
        
        queue.offer(start);
        visited[start.x][start.y] = 0;
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextr = current.x + dr[d];
                int nextc = current.y + dc[d];
                if(nextr < 0 || nextr >= h+2 || nextc < 0 || nextc >= w+2) continue;
                if(visited[nextr][nextc] != -1 || map[nextr][nextc] == '*') continue;
                if(map[nextr][nextc] == '#') {
                    visited[nextr][nextc] = visited[current.x][current.y] + 1;
                    queue.offer(new Node(nextr, nextc, current.open + 1));
                } else {
                    visited[nextr][nextc] = visited[current.x][current.y];
                    queue.offer(new Node(nextr, nextc, current.open));
                }
            }
        }
        return visited;
    }
    private static int getSum(int[][] one, int[][] two, int[][] out) {
        int minSum = h * w;
        
        for (int i = 0; i < one.length; i++)
        {
            for (int j = 0; j < one[i].length; j++)
            {
                if (map[i][j] == '*')
                    continue;
                if (one[i][j] == -1 && two[i][j] == -1 && out[i][j] == -1)
                    continue;
                int sum = one[i][j] + two[i][j] + out[i][j];
                if (map[i][j] == '#')
                {
                    sum -= 2;
                }
                if (minSum > sum)
                {
                    minSum = sum;
                }
            }
        }
        return (minSum);
    }
}