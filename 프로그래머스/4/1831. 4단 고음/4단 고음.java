class Solution {
    static int answer;
    
    public int solution(int n) {
        answer = 0;
        cal(0,n);
        return answer;
    }
    
    public void cal(int plus, int num) {
        
        if(Math.pow(3, plus/2)>num) {
            return;
        }
        
        if(num==3) {
            if(plus==2) {
               answer++;
            }
        }
        
        else if(num>3) {
            if(plus>=2 && num%3==0) {
                cal(plus-2, num/3);
            }
            cal(plus+1, num-1);
        }
    }
}
