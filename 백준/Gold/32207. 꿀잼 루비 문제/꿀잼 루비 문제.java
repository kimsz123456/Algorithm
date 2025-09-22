import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] mine;
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
    static int[] prefixSum;
    
    public static void main(String[] args) throws IOException {
        N = nextInt();
        M = nextInt();
        K = nextInt();
        
        mine = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                mine[i][j] = nextInt();
                list.add(new Node(mine[i][j], i, j));
            }
        }
        
        // 값 내림차순 정렬
        list.sort((a, b) -> b.val - a.val);
        
        // 더 보수적인 가지치기를 위해 상위 후보만 선택
        int T = Math.min(list.size(), 25);
        list = list.subList(0, T);
        
        // prefix sum 준비
        prefixSum = new int[T + 1];
        for (int i = 0; i < T; i++) {
            prefixSum[i + 1] = prefixSum[i] + list.get(i).val;
        }
        
        dfs(0, 0, 0, new boolean[N][M]);
        System.out.println(answer);
    }
    
    static void dfs(int idx, int cnt, int sum, boolean[][] visited) {
        // 현재까지의 합으로 답 갱신
        if (cnt <= K) {
            answer = Math.max(answer, sum);
        }
        
        // 종료 조건
        if (cnt == K || idx == list.size()) return;
        
        // 가지치기: 남은 후보들로 최대한 선택해도 현재 답보다 작으면 가지치기
        int remain = K - cnt;
        int canTake = Math.min(remain, list.size() - idx);
        if (sum + (prefixSum[idx + canTake] - prefixSum[idx]) <= answer) {
            return;
        }
        
        Node cur = list.get(idx);
        
        // 현재 위치가 선택 가능한지 확인 (4방향 인접 체크)
        boolean canSelect = true;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        for (int d = 0; d < 4; d++) {
            int nr = cur.r + dr[d];
            int nc = cur.c + dc[d];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && visited[nr][nc]) {
                canSelect = false;
                break;
            }
        }
        
        // 선택하는 경우
        if (canSelect) {
            visited[cur.r][cur.c] = true;
            dfs(idx + 1, cnt + 1, sum + cur.val, visited);
            visited[cur.r][cur.c] = false;
        }
        
        // 선택하지 않는 경우
        dfs(idx + 1, cnt, sum, visited);
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