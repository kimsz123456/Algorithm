import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static List<int[]> queens;
    static int[][] dir = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        int K = stoi(st.nextToken());

        st= new StringTokenizer(br.readLine());
        int[] king = {stoi(st.nextToken())-1,stoi(st.nextToken())-1};

        queens = new ArrayList<>();
        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            queens.add(new int[] {stoi(st.nextToken())-1,stoi(st.nextToken())-1});
        }
        boolean check = isCheck(king);
        boolean move = canMove(king);

        if (!check && move) System.out.println("NONE");
        else if (check && move) System.out.println("CHECK");
        else if (!check && !move) System.out.println("STALEMATE");
        else System.out.println("CHECKMATE");
    }

    public static boolean isCheck(int[] king) {
        for (int[] q : queens) {
            int r = q[0], c = q[1];
            if (r == king[0]) return true;
            if (c == king[1]) return true;
            if (Math.abs(r - king[0]) == Math.abs(c - king[1])) return true;
        }
        return false;
    }

    public static boolean canMove(int[] king) {
        for (int[] d : dir) {
            int nr = king[0] + d[0];
            int nc = king[1] + d[1];
            if (!boundary(nr, nc)) continue;

            boolean attacked = false;
            for (int[] q : queens) {
                int qr = q[0], qc = q[1];
                if (qr == nr || qc == nc ||
                        Math.abs(qr - nr) == Math.abs(qc - nc)) {
                    attacked = true;
                    break;
                }
            }
            if (!attacked) return true;
        }
        return false;
    }

    public static boolean boundary(int r,int c) {
        return r>=0 && r<N && c>=0 && c<N;
    }

    public static Integer stoi(String str) {
        return Integer.parseInt(str);
    }
}
