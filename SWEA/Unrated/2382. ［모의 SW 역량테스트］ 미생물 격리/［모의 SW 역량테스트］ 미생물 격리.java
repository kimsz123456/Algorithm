import java.io.*;
import java.util.*;

public class Solution {
	static int N,M,sum;
	static boolean[][] map;
	static int[] mapdr = {-1,0,1,0};
	static int[] mapdc = {0,1,0,-1};
	static int[] dr= {0,-1,1,0,0};
	static int[] dc= {0,0,0,-1,1};
	static List<worm> wormList, same;
	
	static class worm{
		int r,c,num,d;
		worm(int r, int c, int num, int d){
			this.r = r;
			this.c = c;
			this.num = num;
			this.d =d;
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=1;tc<=T;tc++) {
        	st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	int K = Integer.parseInt(st.nextToken());
        	
        	map = new boolean[N][N];
        	mapmaking();
        	
        	wormList = new ArrayList<>();
        	for(int i=0;i<K;i++) {
        		st = new StringTokenizer(br.readLine());
        		wormList.add(new worm (Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        	}
        	sum=0;
        	start(0);
        	sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
    }
    static void mapmaking() {
    	int r=0;
    	int c=0;
    	int d=1;
    	while(!map[r][c]) {
    		map[r][c]=true;
        	r=r+mapdr[d];
        	c=c+mapdc[d];
    		if(r+mapdr[d]>=0 && r+mapdr[d]<N && c+mapdc[d] >=0 && c+mapdc[d]<N) {
    		}
    		else {
    			d = (d+1)%4;
			}
    	}
    }
    static void start(int time) {
    	if(time==M) {
    		sum();
    		return;
    	}
    	move();
    	mergecheck();
    	start(time+1);
    }
    
    // 일단 이동부터함. 그리고 약품을 만나면 방향전환.
    static void move() {
    	for(worm w: wormList) {
    		w.r = w.r+dr[w.d];
    		w.c = w.c+dc[w.d];
    		if(map[w.r][w.c]) {
    			w.num = w.num/2;
    			if(w.d==1) {
    				w.d=2;
    			}
    			else if(w.d==2) {
    				w.d=1;
    			}
    			else if(w.d==3) {
    				w.d=4;
    			}
    			else {
    				w.d=3;
    			}
    		}
    	}
    }
    
    static void mergecheck() {

        for (int i = 0; i < wormList.size(); i++) {
            same = new ArrayList<>();
            int max = wormList.get(i).num;
            int dir = wormList.get(i).d;
            int sum = wormList.get(i).num;

            for (int j = i + 1; j < wormList.size(); j++) {
                if (wormList.get(i).r == wormList.get(j).r && wormList.get(i).c == wormList.get(j).c) {
                    same.add(wormList.get(j));
                }
            }

            if (same.size() > 0) {
                for (worm w : same) {
                    sum += w.num;
                    if (w.num > max) {
                        max = w.num;
                        dir = w.d;
                    }
                    wormList.remove(w);
                }
                wormList.get(i).num = sum;
                wormList.get(i).d = dir;
            }
        }
    }
    
    // 웜리스트를 순회하며 미생물숫자 더하기
    static void sum() {
    	for(worm w: wormList) {
    		sum+=w.num;
    	}
    }
}
