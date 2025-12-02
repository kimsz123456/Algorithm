import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        N = nextInt();
        M = nextInt();
        int R = nextInt();

        arr = new int[N][M];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                arr[r][c] = nextInt();
            }
        }
        for (int i = 0; i < R; i++) {
            int d = nextInt();
            switch (d) {
                case 1:
                    upDown();
                    break;
                case 2:
                    leftRight();
                    break;
                case 3:
                    turnRight();
                    break;
                case 4:
                    turnLeft();
                    break;
                case 5:
                    rotateRight();
                    break;
                case 6:
                    rotateLeft();
                    break;
            }
        }
        print();
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[0].length; c++) {
                sb.append(arr[r][c]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void upDown() {
        for (int r = 0; r < N / 2; r++) {
            int[] tmp = arr[r];
            arr[r] = arr[N - 1 - r];
            arr[N - 1 - r] = tmp;
        }
    }

    public static void leftRight() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M / 2; c++) {
                int tmp = arr[r][c];
                arr[r][c] = arr[r][M - 1 - c];
                arr[r][M - 1 - c] = tmp;
            }
        }
    }

    public static void turnRight() {
        N = arr[0].length;
        M = arr.length;
        int[][] temp = new int[N][M];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                temp[r][M - 1 - c] = arr[c][r];
            }
        }
        arr = temp;
    }

    public static void turnLeft() {
        N = arr[0].length;
        M = arr.length;
        int[][] temp = new int[N][M];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                temp[N - 1 - r][c] = arr[c][r];
            }
        }
        arr = temp;
    }

    public static void rotateRight() {
        int[][] temp = new int[N][M];
        for(int r=0;r<N;r++) {
            if(r<N/2) {
                for(int c=0;c<M;c++) {
                    if(c<M/2) {
                        temp[r][c] = arr[r+N/2][c];
                    }
                    else {
                        temp[r][c] = arr[r][c-M/2];
                    }
                }
            }
            else {
                for(int c=0;c<M;c++) {
                    if(c<M/2) {
                        temp[r][c] = arr[r][c+M/2];
                    }
                    else {
                        temp[r][c] = arr[r-N/2][c];
                    }
                }
            }
        }
        arr = temp;
    }

    public static void rotateLeft() {
        int[][] temp = new int[N][M];
        for(int r=0;r<N;r++) {
            if(r<N/2) {
                for(int c=0;c<M;c++) {
                    if(c<M/2) {
                        temp[r][c] = arr[r][c+M/2];
                    }
                    else {
                        temp[r][c] = arr[r+N/2][c];
                    }
                }
            }
            else {
                for(int c=0;c<M;c++) {
                    if(c<M/2) {
                        temp[r][c] = arr[r-N/2][c];
                    }
                    else {
                        temp[r][c] = arr[r][c-M/2];
                    }
                }
            }
        }
        arr = temp;
    }

    static int nextInt() throws IOException {
        int c;
        while (!Character.isDigit(c = System.in.read()))
            ;
        int value = c & 15;
        while (Character.isDigit(c = System.in.read())) {
            value = value * 10 + (c & 15);
        }
        return value;
    }
}