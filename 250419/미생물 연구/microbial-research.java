import java.util.*;
import java.io.*;

public class Main {

    static class CellGroup implements Comparable<CellGroup> {
        int num;
        int area;
        int biasR;
        int biasC;
        Set<int[]> cells;

        CellGroup(int num, int biasR, int biasC, int area,Set<int[]> cells){
            this.biasR = biasR;
            this.biasC = biasC;
            this.num = num;
            this.area = area;
            this.cells = cells;
        }

        public void adjust(){
        	Set<int[]> newCells = new HashSet<>();
        	if(this.area==1) {
            	newCells.add(new int[] {0,0});
            	this.cells=newCells;
            	return;
            }
        	int minR = Integer.MAX_VALUE;
            int minC = Integer.MAX_VALUE;
            for(int[] cell: cells){
                minR = Math.min(cell[0],minR);
                minC = Math.min(cell[1],minC);
            }


            if(minR==0 && minC==0) return;
            
            if(minR>0){
                for(int[] cell:cells){
                    newCells.add(new int[] {cell[0]-minR,cell[1]});
                }
            }
            if(minC>0){
                for(int[] cell:cells){
                    newCells.add(new int[] {cell[0],cell[1]-minC});
                }
            }

            this.cells = newCells;
        }

        @Override
        public int compareTo(CellGroup other){
            if(this.area!=other.area){
                return -Integer.compare(this.area,other.area);
            }
            return Integer.compare(this.num,other.num);
        }
    }

    static int N,Q;
    static int[][] info;
    static int[][] map;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static CellGroup[] group;
    static boolean[] die;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        Q = stoi(st.nextToken());

        map = new int[N][N];
        info = new int[Q+1][4];
        group = new CellGroup[Q+1];
        die = new boolean[Q+1];

        for(int i=1;i<=Q;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<4;j++){
                info[i][j] = stoi(st.nextToken());
            }
            // 1. 미생물 투입
            input(i);

            // 2. 배양 용기 이동
            move(i);

            // 3. 실험 결과 기록
            report(i);
        }
    }

    // 1. 미생물 투입
    static void input(int turn){
        int x1 = info[turn][0];
        int y1 = info[turn][1];
        int x2 = info[turn][2];
        int y2 = info[turn][3];

        int area = 0;
        Set<int[]> cells = new HashSet<>();
        int cur;
        
        // 미생물 반갈죽 체크리스트
        Set<Integer> checkList = new HashSet<>();

        // 미생물 투입해서 넓이 계산, 반갈죽 체크
        for(int i=y1;i<y2;i++){
            for(int j=x1;j<x2;j++){
                cur = map[N-i-1][j];
                int ni = i-y1;
                int nj = j-x1;
                area++;
                cells.add(new int[] {ni,nj});
                
                if(cur!=0){
                    int b = i;
                    int a = j;
                    int biasR = group[cur].biasR;
                    int biasC = group[cur].biasC;
                    group[cur].area--;
                    group[cur].cells.removeIf(cell-> cell[0]== b-biasR && cell[1] == a-biasC);

                    checkList.add(cur);
                }
                map[N-i-1][j]=turn;
            }
        }
        group[turn] = new CellGroup(turn,0,0,area,cells);

        for(int num : checkList){
            if(!check(num)){
                die[num]=true;
            }
        }

    }

    static void move(int turn) {
        map = new int[N][N];
        PriorityQueue<CellGroup> pq = new PriorityQueue<>();

        for (int i = 1; i <= turn; i++) {
            if (!die[i]) {
                pq.add(group[i]);
            }
        }

        boolean[] moved = new boolean[turn + 1];

        while (!pq.isEmpty()) {
            CellGroup cg = pq.poll();
            group[cg.num].adjust();
            flag:
            for (int j = 0; j < N; j++) {
                for (int i = 0; i < N; i++) {
                    if(canMove(i, j, cg.num)) {
                        for (int[] cell : group[cg.num].cells) {
                            int r = i + cell[0];
                            int c = j + cell[1];
                            map[N - r - 1][c] = cg.num;
                            group[cg.num].biasR = i;
                            group[cg.num].biasC = j;
                        }
                        moved[cg.num] = true;
                        break flag;
                    }
                }
            }
        }

        for (int i = 1; i <= turn; i++) {
            if (!moved[i]) die[i] = true;
        }
    }


    // 3. 실험 결과 기록
    static void report(int turn) {

        boolean[][] adjacent = new boolean[Q+1][Q+1];
    
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[N-i-1][j] == 0) continue;
                for (int d = 0; d < 4; d++) {
                    int ni = N-i-1 + dr[d];
                    int nj = j + dc[d];
                    if (boundary(ni, nj) && map[ni][nj] != 0) {
                        if (map[N-i-1][j] != map[ni][nj]) {
                            int idA = map[N-i-1][j];
                            int idB = map[ni][nj];
                            adjacent[idA][idB] = true;
                            adjacent[idB][idA] = true;
                        }
                    }
                }
            }
        }
    
        int score = 0;
        for (int idA = 1; idA <= turn; idA++) {
            for (int idB = idA + 1; idB <= turn; idB++) {
                if (adjacent[idA][idB]) {
                    score += group[idA].area * group[idB].area;
                }
            }
        }
        System.out.println(score);
    }

    // 영역이 둘로 나눠졌는지 확인
    static boolean check(int num){
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new ArrayDeque<>();

        int piece = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==num && !visited[i][j]){
                    piece++;
                    q.add(new int[] {i,j});
                    visited[i][j]=true;
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        int r = cur[0];
                        int c = cur[1];
                        for(int d=0;d<4;d++){
                            int nr = r+dr[d];
                            int nc = c+dc[d];
                            if(boundary(nr,nc) && !visited[nr][nc] && map[nr][nc]==num){
                                q.add(new int[] {nr,nc});
                                visited[nr][nc]=true;
                            }
                        }
                    }
                }
            }
        }

        return piece==1;
    }

    static boolean canMove(int i, int j, int num) {
        
        for (int[] cell : group[num].cells) {
            int r = cell[0];
            int c = cell[1];
            int newR = N-r-1-i;
            int newC = j + c;
            if (!boundary(newR, newC) || map[newR][newC] != 0) {
                return false;
        }
    }
    return true;
}


    // 디버깅용
    static void debug() {
        for(int i=0;i<map.length;i++){
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println("-------------------------");
    }

    static boolean boundary(int r,int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
    
    static int stoi(String str){
        return Integer.parseInt(str);
    }
}