class Solution {
    public int solution(String skill, String[] skill_trees) {
        int [] in = new int[26];
        int [] parent = new int[26];
        
        for(int i=0; i<skill.length() -1; i++){
            int idx = skill.charAt(i) - 'A';
            int next = skill.charAt(i+1) - 'A';
            
            parent[idx] = next;
            in[next]++;
        }
        
        int ans = 0;
        for(int i=0; i<skill_trees.length; i++){
            if(isAvailable(skill_trees[i], in.clone(), parent.clone())){
                ans++;
            }
        }
        return ans;
    }
    
    public boolean isAvailable(String skill, int []in, int [] parent){
        // for(int i : in){
        //     System.out.print(i +" ");
        // }
        // System.out.println();
        
        for(int i=0; i<skill.length(); i++){
            int idx = skill.charAt(i) - 'A';
            
            if(in[idx] > 0){
                return false;
            }
            
            in[parent[idx]]--;
        }
        System.out.println(skill +"성공");
        return true;
    }
}