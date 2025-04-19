import java.util.*;
import java.io.*;

public class Main {

    static class CellGroup {
        int area;
        List<int[]> cells;

        CellGroup(int area,List<int[]> cells){
            this.area = area;
            this.cells = cells;
        }
    }

    static int N,Q;
    static int[] info;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        Q = stoi(st.nextToken());

        map = new int[N][N];
        info = new int[Q][4];

        for(int i=1;i<=Q;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<4;j++){
                info[i-1][j] = stoi(st.nextToken());
            }
            simulate(i);
        }
    }

    static void simulate(int turn){
        // 1. 미생물 투입
        input(turn);
        
        // 2. 배양 용기 이동
        move();

        // 3. 실험 결과 기록
        report();

    }

    // 1. 미생물 투입
    static void input(int turn){
        int r1 = info[turn-1][0];
        int r1 = info[turn-1][0];

    }

    // 2. 배양 용기 이동
    static void move(){

    }

    // 3. 실험 결과 기록
    static void report(){

    }

    static int stoi(String str){
        return Integer.parseInt(str);
    }
}