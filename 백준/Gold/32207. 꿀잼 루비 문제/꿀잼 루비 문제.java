import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int answer = 0;
    
    static class Node {
        int val, r, c;
        Node(int val, int r, int c) {
            this.val = val;
            this.r = r;
            this.c = c;
        }
    }
    
    static List<Node> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        N = nextInt();
        M = nextInt();
        K = nextInt();
        
        int T = 5*K;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int val = nextInt();
                if (pq.size() < T) {
                    pq.offer(new Node(val, i, j));
                } else if (pq.peek().val < val) {
                    pq.poll();
                    pq.offer(new Node(val, i, j));
                }
            }
        }
        
        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }
        list.sort((a, b) -> b.val - a.val);
        
        dfs(0, 0, 0, new boolean[N][M]);
        System.out.println(answer);
    }
    
    static void dfs(int idx, int cnt, int sum, boolean[][] visited) {
        // 현재까지의 합으로 답 갱신
        answer = Math.max(answer, sum);
        
        // 종료 조건
        if (cnt == K || idx == list.size()) return;
        
        // 간단한 가지치기: 남은 개수만큼 현재 노드 값으로 채워도 현재 답을 못 넘으면 리턴
        int remain = K - cnt;
        if (idx < list.size() && sum + remain * list.get(idx).val <= answer) {
            return;
        }
        
        Node cur = list.get(idx);
        
        // 현재 위치가 선택 가능한지 확인 (4방향 인접 체크)
        boolean enable = true;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        for (int d = 0; d < 4; d++) {
            int nr = cur.r + dr[d];
            int nc = cur.c + dc[d];
            if (boundary(nr,nc) && visited[nr][nc]) {
                enable = false;
                break;
            }
        }
        
        // 선택하는 경우
        if (enable) {
            visited[cur.r][cur.c] = true;
            dfs(idx + 1, cnt + 1, sum + cur.val, visited);
            visited[cur.r][cur.c] = false;
        }
        
        // 선택하지 않는 경우
        dfs(idx + 1, cnt, sum, visited);
    }
    
    static boolean boundary(int r,int c) {
    	return r>=0 && r<N && c>=0 && c<M;
    }
    
    static int nextInt() throws IOException {
        int c;
        while (!Character.isDigit(c = System.in.read()));
        int value = c & 15;
        while (Character.isDigit(c = System.in.read())) {
            value = value * 10 + (c & 15);
        }
        return value;
    }
}