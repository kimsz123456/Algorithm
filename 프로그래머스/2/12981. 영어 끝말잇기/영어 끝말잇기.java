import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        int num = 0;
        int turn = 0;
        
        String now = words[0];
        int idx = 1;
        
        while(idx<words.length){
            String next = words[idx%words.length];
            System.out.println(now);
            System.out.println(next);
            if(now.charAt(now.length()-1)!=next.charAt(0)){
                num = idx%n+1;
                turn = idx/n+1;
                break;
            }
            
            now = next;
            idx++;
        }
        Set<String> set = new HashSet<>();
        for(int i=0;i<words.length;i++){
            String word = words[i];
            if(set.contains(word)){
                num = i%n+1;
                turn = i/n+1;
                break;
            }
            else{
                set.add(word);
            }
        }
        
        int[] answer = {num,turn};

        return answer;
    }
}