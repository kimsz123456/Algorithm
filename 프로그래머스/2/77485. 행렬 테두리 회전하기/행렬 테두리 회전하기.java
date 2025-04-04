import java.util.*;

class Solution {
    static int N,M,min;
    static int[][] arr;
    public int[] solution(int rows, int columns, int[][] queries) {
        this.N = rows;
        this.M = columns;
        this.arr = new int[N][M];
        int idx = 1;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                arr[i][j] = idx++;
            }
        }
        int count = queries.length;
        int[] answer = new int[count];
        for(int i=0;i<count;i++){
            answer[i] = rotate(queries[i]);
        }
        return answer;
    }
    
    static int rotate(int[] query){
        int r1 = query[0]-1;
        int c1 = query[1]-1;
        int r2 = query[2]-1;
        int c2 = query[3]-1;
        
        min = Integer.MAX_VALUE;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int num=c1;num<c2;num++){
            min = Math.min(min,arr[r1][num]);
            stack.add(arr[r1][num]);
        }
        for(int num=r1;num<r2;num++){
            min = Math.min(min,arr[num][c2]);
            stack.add(arr[num][c2]);
        }
        for(int num=c2;num>c1;num--){
            min = Math.min(min,arr[r2][num]);
            stack.add(arr[r2][num]);
        }
        for(int num=r2;num>r1;num--){
            min = Math.min(min,arr[num][c1]);
            stack.add(arr[num][c1]);
        }
        
        for(int num=r1;num<r2;num++){
            arr[num][c1] = stack.pop();
        }
        
        for(int num=c1;num<c2;num++){
            arr[r2][num] = stack.pop();
        }
        
        for(int num=r2;num>r1;num--){
            arr[num][c2] = stack.pop();
        }
        
        for(int num=c2;num>c1;num--){
            arr[r1][num] = stack.pop();
        }
        
        return min;
    }
}