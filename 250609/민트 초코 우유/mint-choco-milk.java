import java.util.*;
import java.io.*;

public class Main {

    static class Group {
        int num,type;

        Group(int num, int type){
            this.num = num;
            this.type = type;
        }

        @Override
        public String toString(){
            return num+"&"+type;
        }
    }
    
    static int N,T;
    static Group[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static List<int[]> leaders;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        char[][] charMap = new char[N][N];
        int[][] intMap = new int[N][N];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            charMap[i] = str.toCharArray();
        }

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                intMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        map = new Group[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                char food = charMap[i][j];
                if(food=='T'){
                    map[i][j] = new Group(intMap[i][j],1);
                }
                else if(food=='C'){
                    map[i][j] = new Group(intMap[i][j],2);
                }
                else{
                    map[i][j] = new Group(intMap[i][j],4);
                }
            }
        }

        for(int day=1;day<=T;day++){
            brunch();
            dinner();
            observe();
        }
        System.out.println(sb);
    }

    public static void brunch() {

        leaders = new ArrayList<>();
        
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    int t = map[i][j].type;
                    int cnt = 0;
                    int max = map[i][j].num;
                    int[] maxPos = {i,j};

                    q.add(new int[] {i,j});
                    visited[i][j]=true;
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        int r = cur[0];
                        int c = cur[1];
                        cnt++;

                        if(map[r][c].num>max){
                            max = map[r][c].num;
                            maxPos = new int[] {r,c};
                        }
                        if(map[r][c].num==max){
                            if(maxPos[0]>r){
                                maxPos = new int[] {r,c};
                            }
                            if(maxPos[0]==r && maxPos[1]>c){
                                maxPos = new int[] {r,c};
                            }
                        }

                        for(int d=0;d<4;d++){
                            int nr = r+dr[d];
                            int nc = c+dc[d];
                            if(boundaryCheck(nr,nc) && !visited[nr][nc] && map[nr][nc].type==t){
                                q.add(new int[] {nr,nc});
                                visited[nr][nc]=true;
                            }
                        }
                    }
                    leaders.add(maxPos);
                    map[maxPos[0]][maxPos[1]].num += cnt;
                }
            }
        }
    }

    public static void dinner() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
        int r1 = a[0], c1 = a[1];
        int r2 = b[0], c2 = b[1];
        Group g1 = map[r1][c1];
        Group g2 = map[r2][c2];
        
        // 1. 그룹 타입 우선순위 (비트 개수로 판단: 단일 < 이중 < 삼중)
        int bitCount1 = Integer.bitCount(g1.type);
        int bitCount2 = Integer.bitCount(g2.type);
        if (bitCount1 != bitCount2) {
            return Integer.compare(bitCount1, bitCount2);
        }
        
        // 2. 신앙값이 큰 순서 (내림차순)
        if (g1.num != g2.num) {
            return Integer.compare(g2.num, g1.num);
        }
        
        // 3. 행 번호가 작은 순서 (오름차순)
        if (r1 != r2) {
            return Integer.compare(r1, r2);
        }
        
        // 4. 열 번호가 작은 순서 (오름차순)
        return Integer.compare(c1, c2);
    });
    
        // leaders의 모든 좌표를 PriorityQueue에 추가
        for (int[] pos : leaders) {
            pq.add(pos);
        }

        boolean[][] defended = new boolean[N][N];

        while (!pq.isEmpty()) {
            int[] pos = pq.poll();
            int r = pos[0], c = pos[1];

            if (defended[r][c]) continue;

            int original = map[r][c].num;
            int dir = original%4;

            int power = map[r][c].num-1;
            map[r][c].num = 1;

            int curType = map[r][c].type;

            int nr = r;
            int nc = c;
            
            // 현재 위치에서 시작해서 한 방향으로 쭉 전파
            while (true) {
                nr += dr[dir];
                nc += dc[dir];
                
                // 경계 체크
                if (!boundaryCheck(nr, nc)) {
                    break;
                }
                
                // 음식이 같으면 계속 진행
                if (curType == map[nr][nc].type) {
                    continue;
                }

                defended[nr][nc]=true;
                
                if (power > map[nr][nc].num) {
                    power -= (map[nr][nc].num+1);
                    map[nr][nc].num++;
                    map[nr][nc].type = curType;
                    continue;
                } 
                else {
                    map[nr][nc].type = map[nr][nc].type | curType;
                    map[nr][nc].num += power;
                    break;
                }
            }
        }
    }

    public static void observe() {
        int[] answer = new int[7];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int type = map[i][j].type;
                switch(type) {
                    case 7: answer[0] += map[i][j].num; break;
                    case 3: answer[1] += map[i][j].num; break;
                    case 5: answer[2] += map[i][j].num; break;
                    case 6: answer[3] += map[i][j].num; break;
                    case 4: answer[4] += map[i][j].num; break;
                    case 2: answer[5] += map[i][j].num; break;
                    case 1: answer[6] += map[i][j].num; break;
                }
            }
        }
        for(int i=0;i<7;i++){
            sb.append(answer[i]).append(" ");
        }
        sb.append("\n");
    }

    public static boolean boundaryCheck(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }

    public static void debug() {
        for(int i=0;i<N;i++){
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println("-------------------------");
    }
}