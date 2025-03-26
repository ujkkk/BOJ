import java.util.*;

class Solution {
    public String[] solution(String[] records) {
        
        
        HashMap<String, String> nickNames = new HashMap();  // id - 닉네임
        //HashMap<String, List<Boolean>> infos = new HashMap();    // id - in, out 정보 담김
        
        for(String record : records){
            String [] ops = record.split(" ");
            
            if(ops[0].equals("Enter")){
                String id = ops[1];
                String nickName = ops[2];
                
                // 등록되지 않은 유저
                if(!nickNames.containsKey(id)){
                    nickNames.put(id, nickName);
                    
                    ArrayList<Boolean> info = new ArrayList();
                    //info.add(true);
                    //infos.put(id, info);
                }
                else{   // 등록된 유저
                    if(!nickNames.get(id).equals(nickName)){
                        nickNames.put(id, nickName);
                        //infos.get(id).add(true);
                    }
                }
            }
            else if(ops[0].equals("Leave")){
                //infos.get(id).add(false);
            }
            else{
                String id = ops[1];
                String nickName = ops[2];
                
                nickNames.put(id, nickName);
            }
        }
        
        // 여기까지 수행하면, nickname에는 갱신된 값이 들어감
        List<String> ans = new ArrayList();
        for(String record : records){
            String [] ops = record.split(" ");
            
            String id = ops[1];
            
            if(ops[0].equals("Enter")){
                ans.add(nickNames.get(id) +"님이 들어왔습니다.");
            }
            else if(ops[0].equals("Leave")){
                ans.add(nickNames.get(id) +"님이 나갔습니다.");
            }
        }
        
        return ans.toArray(new String[0]);
    }
}