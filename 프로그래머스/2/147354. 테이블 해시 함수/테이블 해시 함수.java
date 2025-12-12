import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data,(c1,c2)->{
            if(c1[col-1]!=c2[col-1]) return Integer.compare(c1[col-1],c2[col-1]);
            return -Integer.compare(c1[0],c2[0]);
        });
        for(int i=row_begin;i<=row_end;i++) {
            int S = 0;
            for(int j=0;j<data[0].length;j++) {
                S += data[i-1][j]%i;
            }
            answer ^= S;
        }
        return answer;
    }
}