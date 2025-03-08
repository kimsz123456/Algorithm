class Solution {
    static String skill;
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        this.skill=skill;
        
        for(String skillTree : skill_trees){
            if(test(skillTree)){
                answer++;
            }
        }
        return answer;
    }
    
    static boolean test(String skillTree){
        
        for(int i=1;i<skill.length();i++){
            char cur = skill.charAt(i);
            char prev = skill.charAt(i-1);
            for(int j=0;j<skillTree.length();j++){
                if(skillTree.charAt(j)==cur){
                    if(j==0){
                        return false;
                    }
                    String str = skillTree.substring(0,j);
                    if(!str.contains(""+prev)){
                        return false;
                    }
                }
            }
        }
        System.out.println(skillTree);
        return true;
    }
}