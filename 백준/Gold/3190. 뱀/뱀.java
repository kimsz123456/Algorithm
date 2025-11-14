import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] dr = {0, 1, 0, -1}; // 우, 하, 좌, 상
    static int[] dc = {1, 0, -1, 0};

    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = stoi(br.readLine());
        char[][] board = new char[N][N];

        int K = stoi(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = stoi(st.nextToken()) - 1;
            int c = stoi(st.nextToken()) - 1;
            board[r][c] = 'A';
        }

        int L = stoi(br.readLine());
        Map<Integer, String> turn = new HashMap<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = stoi(st.nextToken());
            String cmd = st.nextToken();
            turn.put(time, cmd);
        }

        Deque<Node> snake = new ArrayDeque<>();
        snake.add(new Node(0, 0));
        int dir = 0;
        int time = 0;

        while (true) {
            time++;

            Node head = snake.peekFirst();
            int nr = head.r + dr[dir];
            int nc = head.c + dc[dir];

            if (!boundary(nr, nc)) break;
            boolean hit = false;
            for (Node n : snake) {
                if (n.r == nr && n.c == nc) {
                    hit = true;
                    break;
                }
            }
            if (hit) break;

            snake.addFirst(new Node(nr, nc));
            if (board[nr][nc] == 'A') {
                board[nr][nc] = '.';
            } else {
                snake.removeLast();
            }

            if (turn.containsKey(time)) {
                String cmd = turn.get(time);
                if (cmd.equals("L")) dir = (dir + 3) % 4;
                else dir = (dir + 1) % 4;
            }
        }

        System.out.println(time);
    }
    public static boolean boundary(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

}
