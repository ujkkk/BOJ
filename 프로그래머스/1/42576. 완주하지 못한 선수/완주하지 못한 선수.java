import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> names = new HashMap<>();
        // 1. 입력 받기
        for(int i=0; i<participant.length; i++){
            String name = participant[i];
            if(names.get(name) == null){
                names.put(name, 1);
            }
            else{
                names.put(name, names.get(name)+1);
            }
        }
        
        // 2. 완주자 체크
        for(int i=0; i< completion.length; i++){
            String name = completion[i];
            if(names.get(name)== 1){
                names.remove(name);
            }else{
                names.replace(name, names.get(name) -1);
            }
        }
        
        return new ArrayList<>(names.keySet()).get(0);
    }
}