class Solution {
    static int totalCount=0;
    static int totalAmount=0;
    static int N;
    static int[][] users;
    static int[] emoticons;
    static int[] arr;
    
    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        this.N = emoticons.length;
        
        arr = new int[N];

        comb(0);
        
        int[] answer = {totalCount,totalAmount};
        return answer;
    }
    
    public void comb(int idx){
        
        if(idx==N){
            calculate();
            return;
        }
        
        for(int i=10;i<=40;i+=10){
            arr[idx]=i;
            comb(idx+1);
        }
        
    }
    
    public void calculate(){
        
        int count=0;
        int amount=0;
        
        for(int[] user:users){
            int ratio= user[0];
            int price =user[1];
            int sum=0;
            
            for(int i=0;i<N;i++){
                if(arr[i]>=ratio){
                    sum+=(emoticons[i]/100)*(100-arr[i]);
                }
            }
            
            if(sum>=price){
                count++;
            }
            else{
                amount+=sum;
            }
        }
        
        
        if(count>totalCount){
            totalCount=count;
            totalAmount=amount;
            return;
        }    
        else if(count==totalCount){
            if(totalAmount<amount){
                totalAmount=amount;
            }
        }
    }
    
}