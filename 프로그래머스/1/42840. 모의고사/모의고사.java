class Solution {
    static int[] p1 = {1,2,3,4,5};
    static int[] p2 = {2,1,2,3,2,4,2,5};
    static int[] p3 = {3,3,1,1,2,2,4,4,5,5};
    public int[] solution(int[] answers) {
        int[] answerCount = method(answers);
        int max = 0;
        for(int i=0;i<3;i++){
            max = Math.max(max,answerCount[i]);
        }
        int length = 0;
        for(int i=0;i<3;i++) {
            if(max==answerCount[i]) length++;
        }
        int[] answer = new int[length];
        int idx = 0;
        for(int i=0;i<3;i++) {
            if(max==answerCount[i]) answer[idx++]=i+1;
        }
        return answer;
    }
    
    public int[] method(int[] answers) {
        int[] arr = new int[3];
        for(int i=0;i<answers.length;i++) {
            if(answers[i] == p1[i%5]) arr[0]++;
            if(answers[i] == p2[i%8]) arr[1]++;
            if(answers[i] == p3[i%10]) arr[2]++;
        }
        return arr;
    }
}