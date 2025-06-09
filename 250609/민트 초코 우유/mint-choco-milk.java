import java.util.*;
import java.io.*;

public class Main {
    static int N, T;
    static int[][] foodGrid;  // 음식 신념 (비트마스크)
    static int[][] faithGrid; // 신앙심
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static List<Leader> leaders;
    static boolean[][] visited;
    static boolean[][] defended;
    static StringBuilder sb = new StringBuilder();

    static class Leader {
        int basicFoodCount;
        int faith;
        int row, col;
        
        Leader(int basicFoodCount, int faith, int row, int col) {
            this.basicFoodCount = basicFoodCount;
            this.faith = faith;
            this.row = row;
            this.col = col;
        }
    }
    
    static class GroupMember {
        int faith;
        int row, col;
        
        GroupMember(int faith, int row, int col) {
            this.faith = faith;
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        // 1-based indexing 사용
        char[][] charMap = new char[N + 1][N + 1];
        int[][] intMap = new int[N + 1][N + 1];
        foodGrid = new int[N + 1][N + 1];
        faithGrid = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        defended = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= N; j++) {
                charMap[i][j] = str.charAt(j - 1);
            }
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                intMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 음식 신념을 비트마스크로 변환
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                char food = charMap[i][j];
                if (food == 'T') {
                    foodGrid[i][j] = 1; // 민트
                } else if (food == 'C') {
                    foodGrid[i][j] = 2; // 초코
                } else {
                    foodGrid[i][j] = 4; // 우유
                }
                faithGrid[i][j] = intMap[i][j];
            }
        }

        for (int day = 1; day <= T; day++) {
            brunch();
            dinner();
            observe();
        }
        System.out.println(sb);
    }

    public static void brunch() {
        leaders = new ArrayList<>();
        
        // visited 배열 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                visited[i][j] = false;
            }
        }
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!visited[i][j]) {
                    int targetFood = foodGrid[i][j];
                    List<GroupMember> groupMembers = new ArrayList<>();
                    int groupSize = dfsGroup(i, j, targetFood, groupMembers);
                    
                    // 그룹 멤버들을 정렬하여 대표자 선택
                    groupMembers.sort((a, b) -> {
                        if (a.faith != b.faith) return b.faith - a.faith; // 신앙심 내림차순
                        if (a.row != b.row) return a.row - b.row; // 행 오름차순
                        return a.col - b.col; // 열 오름차순
                    });
                    
                    GroupMember leader = groupMembers.get(0);
                    faithGrid[leader.row][leader.col] += groupSize;
                    
                    int basicFoodCount = countBasicFoods(foodGrid[leader.row][leader.col]);
                    leaders.add(new Leader(basicFoodCount, faithGrid[leader.row][leader.col], 
                                         leader.row, leader.col));
                }
            }
        }
    }
    
    public static int dfsGroup(int row, int col, int targetFood, List<GroupMember> groupMembers) {
        visited[row][col] = true;
        groupMembers.add(new GroupMember(faithGrid[row][col], row, col));
        int size = 1;
        
        for (int d = 0; d < 4; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];
            if (boundaryCheck(nr, nc) && !visited[nr][nc] && foodGrid[nr][nc] == targetFood) {
                size += dfsGroup(nr, nc, targetFood, groupMembers);
            }
        }
        return size;
    }
    
    public static int countBasicFoods(int foodValue) {
        int count = 0;
        if ((foodValue & 1) != 0) count++; // 민트
        if ((foodValue & 2) != 0) count++; // 초코
        if ((foodValue & 4) != 0) count++; // 우유
        return count;
    }

    public static void dinner() {
        // defended 배열 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                defended[i][j] = false;
            }
        }
        
        // 리더들을 정렬
        leaders.sort((a, b) -> {
            if (a.basicFoodCount != b.basicFoodCount) {
                return a.basicFoodCount - b.basicFoodCount; // 기본 음식 개수 오름차순
            }
            if (a.faith != b.faith) {
                return b.faith - a.faith; // 신앙심 내림차순
            }
            if (a.row != b.row) {
                return a.row - b.row; // 행 오름차순
            }
            return a.col - b.col; // 열 오름차순
        });

        for (Leader leader : leaders) {
            int leaderRow = leader.row;
            int leaderCol = leader.col;
            
            if (defended[leaderRow][leaderCol]) continue;

            int propagationDir = faithGrid[leaderRow][leaderCol] % 4;
            int remainingPower = faithGrid[leaderRow][leaderCol] - 1;
            faithGrid[leaderRow][leaderCol] = 1;
            int leaderFood = foodGrid[leaderRow][leaderCol];
            
            int currentRow = leaderRow;
            int currentCol = leaderCol;
            
            while (true) {
                currentRow += dr[propagationDir];
                currentCol += dc[propagationDir];
                
                if (!boundaryCheck(currentRow, currentCol)) {
                    break;
                }
                
                // 음식이 같으면 계속 진행
                if (foodGrid[currentRow][currentCol] == leaderFood) {
                    continue;
                }

                int targetFaith = faithGrid[currentRow][currentCol];
                
                if (remainingPower > targetFaith) {
                    // 강한 전파
                    faithGrid[currentRow][currentCol] += 1;
                    remainingPower -= (targetFaith + 1);
                    foodGrid[currentRow][currentCol] = leaderFood;
                    defended[currentRow][currentCol] = true;
                } else {
                    // 약한 전파
                    faithGrid[currentRow][currentCol] += remainingPower;
                    foodGrid[currentRow][currentCol] |= leaderFood;
                    remainingPower = 0;
                    defended[currentRow][currentCol] = true;
                }
                
                if (remainingPower == 0) break;
            }
        }
    }

    public static void observe() {
        int[] answer = new int[8]; // 인덱스 1~7 사용
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int type = foodGrid[i][j];
                answer[type] += faithGrid[i][j];
            }
        }
        
        // 출력 순서: 민트초코우유(7), 민트초코(3), 민트우유(5), 초코우유(6), 우유(4), 초코(2), 민트(1)
        sb.append(answer[7]).append(" ");
        sb.append(answer[3]).append(" ");
        sb.append(answer[5]).append(" ");
        sb.append(answer[6]).append(" ");
        sb.append(answer[4]).append(" ");
        sb.append(answer[2]).append(" ");
        sb.append(answer[1]).append("\n");
    }

    public static boolean boundaryCheck(int r, int c) {
        return r >= 1 && r <= N && c >= 1 && c <= N;
    }
}