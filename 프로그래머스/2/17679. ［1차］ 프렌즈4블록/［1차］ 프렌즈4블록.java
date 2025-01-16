import java.util.*;

class Solution {
    static int N,M;
    static char[][] arr;
    static int answer=0;
    public int solution(int m, int n, String[] board) {
        N=n;
        M=m;
        arr = new char[M][N];
        for(int i=0;i<M;i++){
            arr[i] = board[i].toCharArray();
        }
        
        while(remove()){
            down();
        }
        
        return answer;
    }
    
    public boolean remove() {
        Set<int[]> set = new HashSet<>();
        char flag;
        for(int i=0;i<M-1;i++){
            flag=' ';
            for(int j=0;j<N;j++){
                if(arr[i][j]==' ') {
                    flag= ' ';
                    continue;
                }
                if(arr[i][j]==arr[i+1][j]){
                    if(arr[i][j]==flag){
                        set.add(new int[] {i,j});
                        set.add(new int[] {i+1,j});
                        set.add(new int[] {i,j-1});
                        set.add(new int[] {i+1,j-1});
                    }
                    flag=arr[i][j];
                }
                else{
                    flag=' ';
                }
            }
        }
        
        boolean result = !set.isEmpty();
        if (result){
            for(int[] a : set){
                if(arr[a[0]][a[1]]!=' '){
                    arr[a[0]][a[1]]=' ';
                    answer++;
                }
            }
        }
        return result;
    }
    
    public void down() {
        Stack<Character> stack = new Stack<>();
        for(int j=0;j<N;j++){
            for(int i=0;i<M;i++){
                if(arr[i][j]!=' '){
                    stack.add(arr[i][j]);
                    arr[i][j]=' ';
                }
            }    
            for(int i=M-1;i>=0;i--){
                if(!stack.isEmpty()){
                    arr[i][j]=stack.pop();
                }
            }
        }
    }
}