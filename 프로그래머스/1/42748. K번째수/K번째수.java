import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        List<Integer> list;
        int idx = 0;
        for(int[] command : commands) {
            list = new ArrayList<>();
            for(int i=command[0]-1;i<command[1];i++){
                list.add(array[i]);
            }
            list.sort((o1, o2) -> Integer.compare(o1, o2));
            answer[idx++]=list.get(command[2]-1);
        }
        return answer;
    }
}