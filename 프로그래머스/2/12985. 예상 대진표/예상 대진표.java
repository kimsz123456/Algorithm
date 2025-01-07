class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        int div=2;
        while(true){
            if((a-1)/div == (b-1)/div){
                break;
            }
            div *=2;
            answer++;
        }

        return answer;
    }
}