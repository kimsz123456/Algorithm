import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

	static int[][] synerge;
	static boolean[] selects;
	static int N;
	static int answer;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			//input
			N = Integer.parseInt(br.readLine());
			synerge = new int[N][N];
			selects = new boolean[N];
			answer = Integer.MAX_VALUE;
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					synerge[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//solve
			combination(0,0);
			
			//output
			System.out.println("#" + tc+ " " + answer);
		}
	}   
	static int cal() {
		int A=0;
		int B=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i==j) {
					continue;
				}
				if(selects[i] && selects[j]) {
					A+=synerge[i][j];
				}
				else if(!selects[i] && !selects[j]){
					B+=synerge[i][j];
				}
			}
		}
		return Math.abs(A-B);
	}
	
	static void combination(int idx, int cnt) {
		if(cnt==N/2) {
			answer = Math.min(answer,cal());
			return;
		}
		
		for(int i=idx; i< N; i++) {
			selects[i]=true;
			combination(i+1,cnt+1);
			selects[i]=false;
		}
	}
}