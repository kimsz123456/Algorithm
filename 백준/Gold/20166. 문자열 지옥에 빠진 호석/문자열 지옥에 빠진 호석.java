import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int count=0;
	static int[] dr = {0,1,0,-1,1,1,-1,-1};
	static int[] dc = {1,0,-1,0,1,-1,1,-1};
	static Set<String> god;
	static Map<String,Integer> map;
	static char[][] world;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		world = new char[N][M];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				world[i][j] = str.charAt(j);
			}
		}
		
		god = new HashSet<>();
		map = new HashMap<>();
		for(int i=0;i<K;i++) {
			String next = br.readLine();
			god.add(next);
		}
		for(String next: god) {
			map.put(next, 0);
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				DFS(i,j,new StringBuilder().append(world[i][j]));
			}
		}
		for(String next: god) {
			System.out.println(map.get(next));
		}
    }
	
    static void DFS(int r, int c, StringBuilder word) {
        if (god.contains(word.toString())) {
            map.put(word.toString(), map.get(word.toString()) + 1);
        }
        
        if (word.length() > 5) {
            return;
        }
        
        for (int d = 0; d < 8; d++) {
            int nextr = (r + dr[d] + N) % N;
            int nextc = (c + dc[d] + M) % M;
            word.append(world[nextr][nextc]);
            DFS(nextr, nextc, word);
            word.deleteCharAt(word.length() - 1); // 백트래킹
        }
    }
}