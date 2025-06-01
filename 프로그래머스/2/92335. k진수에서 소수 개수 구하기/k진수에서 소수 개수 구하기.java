import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String str = Integer.toString(n,k);
        StringTokenizer st = new StringTokenizer(str,"0");

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if(primeCheck(token)) answer++;
        }
        
        return answer;
    }
    
    static boolean primeCheck(String str){
        long num = Long.parseLong(str);
        if(num<2){
            return false;
        }
        else if (num <= 3) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
            
        for (long i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}