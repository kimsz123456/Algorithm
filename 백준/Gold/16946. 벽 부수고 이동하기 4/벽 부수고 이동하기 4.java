import java.io.*;
import java.util.*;

public class Main {

	static class Node {
		int r,c;
		
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int N,M;
	static int[][] map;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	static int[][] group;
	static HashMap<Integer, Integer> hm = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		group = new int[N][M];
		int index = 1;
		
		//map 입력
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j=0; j<M;j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
	
		// 0 그룹화 하기 => 그룹 번호 부여, 같은 그룹 개수 세기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0 && group[i][j] == 0){
					hm.put(index, bfs(i, j, index));
					index++;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(mapCount(i,j));
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static int mapCount(int r, int c) {
		int sum = 1;
		HashSet<Integer> hs = new HashSet<>();
		
		if(map[r][c] == 0) {
			return 0;
		}
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			
			if(nr>= 0 && nr< N && nc >=0 && nc < M && group[nr][nc]!=0 && map[nr][nc] == 0) { // 벽이 아닐때
				hs.add(group[nr][nc]);
			}

		}
		
		for(int index : hs) {
			sum += hm.get(index);
		}
		
		return sum%10;
		
	}
	
	
	static int bfs(int i, int j, int groupNum) {
		int count = 1;
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(new Node(i, j));
		group[i][j] = groupNum;
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			int r = cur.r;
			int c = cur.c;
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr >=0 && nr< N && nc>=0 && nc<M && map[nr][nc] ==0 && group[nr][nc] == 0) {
					queue.add(new Node(nr,nc));
					group[nr][nc] = groupNum;
					count++;
				}
				
			}
		}

		return count;
	}

}