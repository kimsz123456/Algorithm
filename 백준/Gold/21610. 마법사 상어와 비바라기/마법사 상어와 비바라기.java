import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {0,-1,-1,-1,0,1,1,1};
    static int[] dc = {-1,-1,0,1,1,1,0,-1};
    static int N;
    static int[][] A;
    static List<int[]> clouds;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        int M = stoi(st.nextToken());
        A = new int[N][N];
        clouds = new ArrayList<>();
        int[] start = {N-1,0};
        clouds.add(start);
        for(int i=2;i<=4;i++) {
            clouds.add(new int[] {start[0]+dr[i],start[1]+dc[i]});
        }

        for(int r=0;r<N;r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<N;c++) {
                A[r][c] = stoi(st.nextToken());
            }
        }
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int d = stoi(st.nextToken())-1;
            int s = stoi(st.nextToken());
            command(d,s);
        }
        int answer = calculate();
        System.out.print(answer);
    }
    public static void command(int d, int s) {
        moveClouds(d,s);
        rain();
        magic();
        createClouds();
    }

    public static void moveClouds(int d, int s) {
        for(int[] cloud : clouds) {
            cloud[0] = ((cloud[0] + s * dr[d]) % N + N) % N;
            cloud[1] = ((cloud[1] + s * dc[d]) % N + N) % N;
        }
    }

    public static void rain() {
        for(int[] cloud : clouds) {
            A[cloud[0]][cloud[1]]++;
        }
    }

    public static void magic() {
        for(int[] cloud : clouds) {
            for(int d=1;d<8;d+=2) {
                int nr = cloud[0]+dr[d];
                int nc = cloud[1]+dc[d];
                if(boundary(nr,nc) && A[nr][nc]>0) {
                    A[cloud[0]][cloud[1]]++;
                }
            }
        }
    }

    public static void createClouds() {
        boolean[][] visited = new boolean[N][N];
        for(int[] cloud:clouds) {
            visited[cloud[0]][cloud[1]]=true;
        }
        clouds.clear();
        for(int r=0;r<N;r++) {
            for(int c=0;c<N;c++) {
                if(!visited[r][c] && A[r][c]>=2) {
                    A[r][c]-=2;
                    clouds.add(new int[] {r,c});
                }
            }
        }
    }

    public static boolean boundary(int r,int c) {
        return r>=0 && r<N && c>=0 && c<N;
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static int calculate() {
        int sum = 0;
        for(int r=0;r<N;r++) {
            for(int c=0;c<N;c++) {
                sum+=A[r][c];
            }
        }
        return sum;
    }
}