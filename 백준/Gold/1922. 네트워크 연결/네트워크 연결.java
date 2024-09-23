import java.io.*;
import java.util.*;

public class Main {
	static class Edge implements Comparable<Edge>{
		int A,B,W;
		
		Edge(int A, int B, int W){
			this.A = A;
			this.B = B;
			this.W = W;
		}
		
		@Override
		public int compareTo(Edge other) {
			return this.W - other.W;
		}
	}
	
	// 대표자
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		Edge[] edges = new Edge[E];
		
		for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i] = new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
		// 1. 정렬
		Arrays.sort(edges);
		
		// 2. V-1개의 간선 뽑기
		
		// make set
		p = new int[V+1];
		for (int i = 1; i <= V; i++) {
            p[i]=i;
        }
		
		//
		int ans = 0;
		int pick = 0;
		
		// union을 하기전에 대표자를 내려보내기
        for (int i = 0; i < E; i++) {
            int px = find(edges[i].A);
            int py = find(edges[i].B);
            
            // 사이클 발생하지않도록
            if (px != py) {
                union(px, py);
                ans += edges[i].W;
                pick++;
            }
             
            // 다 뽑았으면 끝
            if (pick == (V - 1))
                break;
        }
        
        System.out.println(ans);
	}
	
	
	static int find(int x) {
		if (x != p[x]) {
			p[x] = find(p[x]);
		}
		return p[x];
	}
	
	static void union(int x, int y) {
		p[y] = x;
	}
}