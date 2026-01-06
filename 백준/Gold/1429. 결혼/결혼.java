import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static boolean[][] marriage;
    static int answer = Integer.MAX_VALUE;

    static boolean[] manCovered;
    static boolean[] womanCovered;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        marriage = new boolean[N][M];
        manCovered = new boolean[N];
        womanCovered = new boolean[M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                if(str.charAt(j) == '1') {
                    marriage[i][j] = true;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            boolean canMarry = false;
            for(int j = 0; j < M; j++) {
                if(marriage[i][j]) canMarry = true;
            }
            if(!canMarry) {
                System.out.println(-1);
                return;
            }
        }

        for(int j = 0; j < M; j++) {
            boolean canMarry = false;
            for(int i = 0; i < N; i++) {
                if(marriage[i][j]) canMarry = true;
            }
            if(!canMarry) {
                System.out.println(-1);
                return;
            }
        }

        for(int rowMask = 0; rowMask < (1 << N); rowMask++) {
            for(int colMask = 0; colMask < (1 << M); colMask++) {
                if(isValid(rowMask, colMask)) {
                    answer = Math.min(answer, Integer.bitCount(rowMask) + Integer.bitCount(colMask));
                }
            }
        }

        System.out.println(answer);
    }

    static boolean isValid(int rowMask, int colMask) {
        Arrays.fill(manCovered, false);
        Arrays.fill(womanCovered, false);

        for(int i = 0; i < N; i++) {
            if((rowMask & (1 << i)) != 0) {
                manCovered[i] = true;
                for(int j = 0; j < M; j++) {
                    if(marriage[i][j]) {
                        womanCovered[j] = true;
                    }
                }
            }
        }

        for(int j = 0; j < M; j++) {
            if((colMask & (1 << j)) != 0) {
                womanCovered[j] = true;
                for(int i = 0; i < N; i++) {
                    if(marriage[i][j]) {
                        manCovered[i] = true;
                    }
                }
            }
        }

        for(int i = 0; i < N; i++) {
            if(!manCovered[i]) return false;
        }
        for(int j = 0; j < M; j++) {
            if(!womanCovered[j]) return false;
        }

        return true;
    }
}