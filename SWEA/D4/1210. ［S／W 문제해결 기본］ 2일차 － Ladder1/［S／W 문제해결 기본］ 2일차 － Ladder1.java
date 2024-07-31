import java.util.Scanner;

public class Solution {
    
    // 0 1 2
    // 좌 상 우
    static int[] dr = {0,-1,0};
    static int[] dc = {-1,0,1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = 10; // 테스트케이스 10개
        
        for (int a=0; a<T; a++) { // 10개의 테스트케이스
            int N = 100;
            int tc = sc.nextInt();
            int[][] arr = new int[N][N];
            
            for (int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int r = 0; // 로우
            int c = 0; // 컬럼
            for(int i=0;i<N;i++) {
            	for(int j=0;j<N;j++) {
            		if(arr[i][j]==2) {
            			r=i;
            			c=j;
            		}
            	}
            }
            
            int d = 1; // 델타
            while(r+dr[1] >= 0) { // 위로 갈 곳이 있을 때 까지 반복을 한다.
                switch(d) { // 델타 d에따라 케이스를 나눈다.
                case 0: // 왼쪽으로 간다.
                    while(c+dc[d] >=0 && arr[r+dr[d]][c+dc[d]]==1) { // 왼쪽벽에 도달하기 전까지, 0을만날 때 까지
                        r = r+dr[d]; 
                        c = c+dc[d];
                    }
                    d++;    // 왼쪽벽에 도달하거나 0을만나면 위로간다
                    break;
                case 1: // 위로 간다.
                	r = r+dr[d];
                    c = c+dc[d];
                    
                	if (c+dc[0]>=0 && arr[r+dr[0]][c+dc[0]]==1) { // 왼쪽끝 아니고 왼쪽에 1이있으면
                        d = 0; // 왼쪽으로 간다
                    }
                	
                	else if(c+dc[2]<N && arr[r+dr[2]][c+dc[2]]==1){ // 오른쪽끝 아니고 오른쪽에 1이있으면
                        d = 2; // 오른쪽으로 간다.
                    }
                	break;
                case 2: // 오른쪽으로 간다
                    while(c+dc[d] < N && arr[r+dr[d]][c+dc[d]]==1) { // 오른쪽벽에 도달할 때 까지, 0을 만날 때 까지
                        r = r+dr[d];
                        c = c+dc[d];
                    }
                    d--;    
                    break;
                }
            }
            System.out.println("#"+tc+" "+c); // 행의 합 최대값 + 열의 합 최대값 최대값
        }
    }
}