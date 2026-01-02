import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        
        // id map
        HashMap<String, Integer> idMap = new HashMap();
        for(int i=0; i<id_list.length; i++){
            idMap.put(id_list[i], i);
        }
        
        HashMap<String, Node> reports = new HashMap();
        for(int i=0; i<report.length; i++){
            String str [] = report[i].split(" ");
            
            String u1 = str[0];
            int u1Id = idMap.get(u1);
            
            String u2 = str[1];
            
            
            if(reports.containsKey(u2)){
                Node node = reports.get(u2);
                // 동일한 유저가 신고했는지 확인
                if(node.isAlready(u1Id)){
                    continue;
                }
                // 새로운 유저가 신고
                node.count++;
                node.users[u1Id] = true;
            }
            else{
                boolean [] users = new boolean[idMap.size()];
                users[u1Id] = true;
                reports.put(u2, new Node(1, users));
            }
        }
        
        // 결과
        int [] counts = new int[idMap.size()];
        for(String u : reports.keySet()){
            Node node = reports.get(u);
            if(node.count >= k){
                for(int i=0; i<node.users.length; i++){
                    if(node.users[i]){
                        counts[i]++;
                    }
                }
            }
        }
        
        return counts;
    }
}

class Node{
    int count;
    boolean [] users;
    
    public Node(int count, boolean [] users){
        this.count = count;
        this.users = users;
    }
    
    boolean isAlready(int idx){
        return this.users[idx];
    }
}