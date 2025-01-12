import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        Map<String,Integer> mapOne = new HashMap<>();
        Map<String,Integer> mapTwo = new HashMap<>();
        
        for(int i=0;i<str1.length()-1;i++){
            String one = str1.substring(i,i+2);
            if(Character.isLetter(one.charAt(0)) && Character.isLetter(one.charAt(1))){
                mapOne.put(one,mapOne.getOrDefault(one,0)+1);
            }
        }
        for(int i=0;i<str2.length()-1;i++){
            String two = str2.substring(i,i+2);
            if(Character.isLetter(two.charAt(0)) && Character.isLetter(two.charAt(1))){
                mapTwo.put(two,mapTwo.getOrDefault(two,0)+1);
            }
        }
        
        Map<String,Integer> union = new HashMap<>();
        Map<String,Integer> intersection = new HashMap<>();
        for (String key : mapOne.keySet()) {
            union.put(key,union.getOrDefault(key,0)+mapOne.get(key));
            if(mapTwo.containsKey(key)){
                intersection.put(key,Math.min(mapOne.get(key),mapTwo.get(key)));
            }
        }
        for (String key : mapTwo.keySet()) {
            union.put(key,(union.getOrDefault(key,0)>0?Math.max(mapOne.get(key),mapTwo.get(key)):mapTwo.get(key)));
        }
        
        int denom = 0;
        for(String key:union.keySet()){
            System.out.println("key: "+key+"value: "+union.get(key));
            denom+=union.get(key);
        }
        int numer = 0;
        for(String key:intersection.keySet()){
            System.out.println("key: "+key+"value: "+intersection.get(key));
            numer+=intersection.get(key);
        }
        System.out.println(denom);
        System.out.println(numer);
        int answer = 65536;
        if(denom==0){
            return answer;
        }
        else{
            answer = (numer*65536/denom);
        }
        return answer;
    }
}