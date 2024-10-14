import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] dr = { 0, 1, 0, -1 ,1,1,-1,-1};
	static int[] dc = { 1, 0, -1, 0 ,1,-1,1,-1};
	static int[] PO;
	static int[][] height;
	static char[][] town;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		town = new char[N][N];
		height = new int[N][N];
		PO = new int[2];
		List<int[]> house = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				char next = str.charAt(j);
				town[i][j] = next;
				if (next == 'P') {
					PO[0] = i;
					PO[1] = j;
				}
				if (next == 'K') {
					house.add(new int[] { i, j });
				}
			}
		}
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				height[i][j] = num;
				list.add(num);
				
				if(town[i][j]=='K' || town[i][j]=='P') {
					min=Math.min(min, num);
					max=Math.max(max, num);
				}
			}
		}
		Collections.sort(list);
		
		// list를 투포인터로 탐색
		int bottom = 0;
		int minIdx = list.indexOf(min);
		
		int top = list.indexOf(max);
		int maxIdx = list.size();
		
		int result = Integer.MAX_VALUE;
		
		while (bottom <=minIdx && bottom <= top && top <maxIdx) {
			int left = list.get(bottom);
			int right = list.get(top);
			if (bfs(PO[0], PO[1],left,right,house.size())) {
				result = Math.min(result,(right-left));
				bottom++;
			}
			else {
				top++;
			}
		}
		
		System.out.println(result);
	}

	static boolean bfs(int r, int c,int left,int right,int size) {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		queue.add(new int[] {r, c});
		visited[r][c] = true;
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			if (size==0) {
				return true;
			}
			for (int d = 0; d < 8; d++) {
				int nextr = current[0] + dr[d];
				int nextc = current[1] + dc[d];
				if (nextr >= 0 && nextr < N && nextc >= 0 && nextc < N && !visited[nextr][nextc] && height[nextr][nextc]>=left && height[nextr][nextc]<=right) {
					visited[nextr][nextc]=true;
					queue.add(new int[] {nextr,nextc});
					if(town[nextr][nextc]=='K') {
						size--;
					}
				}
			}
		}
		return false;
	}
}
