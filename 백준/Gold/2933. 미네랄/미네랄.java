import java.io.*;
import java.util.*;

public class Main {
	static int R,C,N;
	static char[][] cave;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static List<Integer> height;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		
		// 동굴의 크기
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		// 동굴 정보
		cave = new char[R][C];
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				cave[i][j] = str.charAt(j);
			}
		}
		
		// 막대를 던진 횟수
		N = Integer.parseInt(br.readLine());
		
		// 막대를 던진 높이를 index형식으로 list에 저장.
		height = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			height.add(R-num);
		}
		
		start(0);
	}
	static void start(int num) {
		// 막대기를 던지기 시작해서 N이 되면 종료
		if(num==N) {
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					System.out.print(cave[i][j]);
				}
				System.out.println();
			}
			return;
		}
		int row = height.get(num);
		// 홀수번째에는 왼쪽에서 시작(창영이턴)
		if (num%2==0) {
			for(int i=0;i<C;i++) {
				if(cave[row][i]=='x') {
					cave[row][i]='.'; // 미네랄 파괴
					clusterCheck();
					break;
				}
			}
		}
		// 짝수번째에는 오른쪽에서 시작(상근이턴)
		else {
			for(int i=C-1;i>=0;i--) {
				if(cave[row][i]=='x') {
					cave[row][i]='.'; // 미네랄 파괴
					clusterCheck();
					break;
				}
			}
		}
		start(num+1);
	}
	static void clusterCheck() {
	    boolean[][] visited = new boolean[R][C];
	    
	    // 바닥에 붙어있는 클러스터는 떨어지지 않으므로, 바닥에 붙어있는 클러스터를 먼저 확인
	    for (int i = 0; i < C; i++) {
	        if (cave[R - 1][i] == 'x' && !visited[R - 1][i]) {
	            bfs(R - 1, i, visited);
	        }
	    }

	    // 공중에 있는 클러스터의 정보를 담을 리스트
	    List<int[]> floatingCluster = new ArrayList<>();
	    
	    // 미네랄 중 방문하지 않은 미네랄은 공중에 떠있는 클러스터임
	    for (int i = 0; i < R; i++) {
	        for (int j = 0; j < C; j++) {
	            if (cave[i][j] == 'x' && !visited[i][j]) {
	                floatingCluster.add(new int[]{i, j});
	                cave[i][j] = '.'; // 클러스터를 공중에 떠 있는 것으로 간주하고 제거
	            }
	        }
	    }
	    
	    // 클러스터가 공중에 떠 있는 경우 떨어뜨리기
	    if (!floatingCluster.isEmpty()) {
	        dropMineral(floatingCluster);
	    }
	}
	
	// 바닥부터 bfs돌면서 visited체크
	static void bfs(int r, int c, boolean[][] visited) {
	    Queue<int[]> queue = new LinkedList<>();
	    queue.add(new int[]{r, c});
	    visited[r][c] = true;
	    
	    while (!queue.isEmpty()) {
	        int[] current = queue.poll();
	        int currentr = current[0];
	        int currentc = current[1];
	        
	        for (int d = 0; d < 4; d++) {
	            int nextr = currentr + dr[d];
	            int nextc = currentc + dc[d];
	            
	            if (nextr >= 0 && nextr < R && nextc >= 0 && nextc < C && cave[nextr][nextc] == 'x' && !visited[nextr][nextc]) {
	                visited[nextr][nextc] = true;
	                queue.add(new int[]{nextr, nextc});
	            }
	        }
	    }
	}
	
	// 미네랄 떨어트리기
	static void dropMineral(List<int[]> floatingCluster) {
	    // 리스트가 있다는건 떨어트릴 수 있다는거임.
		boolean canDrop = true;
	    
	    while (canDrop) {
	        // 클러스터가 더 떨어질 수 있는지 확인
	        for (int[] mineral : floatingCluster) {
	            int r = mineral[0] + 1;
	            int c = mineral[1];
	            
	            // 바닥을 만나거나, 미네랄 만나면
	            if (r >= R || cave[r][c] == 'x') {
	                canDrop = false;
	                break;
	            }
	        }
	        
	        if (canDrop) {
	            // 한 칸씩 아래로 이동
	            for (int i = 0; i < floatingCluster.size(); i++) {
	                int[] mineral = floatingCluster.get(i);
	                floatingCluster.set(i, new int[]{mineral[0] + 1, mineral[1]});
	            }
	        }
	    }
	    
	    // 클러스터를 동굴에 다시 배치
	    for (int[] mineral : floatingCluster) {
	        cave[mineral[0]][mineral[1]] = 'x';
	    }
	}
}