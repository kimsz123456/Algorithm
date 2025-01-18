import java.util.*;
import java.io.*;

public class Main {
	static int N,K,S,X,Y;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[][] map;
    
    
    static class Node implements Comparable<Node>{
    	int r,c,n,t;
    	Node(int r, int c, int n, int t){
    		this.r=r;
    		this.c=c;
    		this.n=n;
    		this.t=t;
    	}
    	@Override
    	public int compareTo(Node other) {
    		return Integer.compare(this.n, other.n);
    	}
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        List<Node> list = new ArrayList<>();
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
        		int num = Integer.parseInt(st.nextToken());
        		map[i][j] = num;
        		if(num>0) {
        			list.add(new Node (i,j,num,0));
        		}
        	}
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken())-1;
        Y = Integer.parseInt(st.nextToken())-1;
        
        Collections.sort(list);
        Queue<Node> queue = new ArrayDeque<>();
        for(Node node:list) {
        	queue.add(node);
        }
    	while(!queue.isEmpty()) {
    		Node cur = queue.poll();
    		int r = cur.r;
    		int c = cur.c;
    		int n = cur.n;
    		int t = cur.t;
    		if(t==S) {
    			break;
    		}
    		for(int d=0;d<4;d++) {
    			int nr = r+dr[d];
    			int nc = c+dc[d];
    			if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc]==0) {
    				map[nr][nc]=cur.n;
    				queue.add(new Node (nr,nc,n,t+1));
    			}
    		}
    	}
    	System.out.println(map[X][Y]);
    }
}
