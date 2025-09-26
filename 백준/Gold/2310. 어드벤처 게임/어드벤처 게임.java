import java.io.*;
import java.util.*;

public class Main {
	static class Room {
		char status;
		int val;
		List<Integer> next;
		Room(char status,int val, List<Integer> next) {
			this.status = status;
			this.val = val;
			this.next = next;
		}
	}
	static class Player {
		int num,gold;
		Player(int num, int gold){
			this.num=num;
			this.gold=gold;
		}
	}
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	int N;
    	while((N = stoi(br.readLine()))!=0) {
    		Room[] rooms = new Room[N+1];
    		for(int i=1;i<=N;i++) {
    			st = new StringTokenizer(br.readLine());
    			char status = st.nextToken().charAt(0);
    			int val = stoi(st.nextToken());
    			List<Integer> next = new ArrayList<>();
    			int num;
    			while((num=stoi(st.nextToken()))!=0) {
    				next.add(num);
    			}
    			rooms[i]= new Room(status,val,next);
    		}
    		Queue<Player> q = new ArrayDeque<>();
    		int[] visited = new int[N+1];
    		Arrays.fill(visited, -1);
    		boolean arrived = false;
    		q.add(new Player(1,0));
    		
    		while(!q.isEmpty()) {
    			Player p = q.poll();
    			int gold = p.gold;
    			Room cur = rooms[p.num];
    			char status = cur.status;
    			int val = cur.val;
    			if(status=='L') {
    				gold = Math.max(gold, val);
    			}
    			else if(status=='T'){
    				if(gold>=val) {
    					gold-=val;
    				}
    				else continue;
    			}
    			if(p.num==N) {
    				arrived=true;
    				break;
    			}
    			for(int num : cur.next) {
					if(visited[num]<gold) {
						visited[num]=gold;
						q.add(new Player(num,gold));
					}
				}
    		}
    		if(arrived) sb.append("Yes\n");
    		else sb.append("No\n");
    	}
    	System.out.print(sb);
    }
    
    public static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}
