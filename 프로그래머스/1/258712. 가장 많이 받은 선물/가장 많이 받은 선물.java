;import java.util.*;
import java.lang.*;
import java.io.*;

// 특정 A와 B가 주고 받은 선물의 수
// 특정 A가 받은 선물의 수와 받은 선물의 수
class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        ArrayList<Friend> f_list = new ArrayList();
        for(String name : friends){
            f_list.add(new Friend(name));
        }
        
        // 주고받은 내역 관리 - A-B (A가 B에게 선물을 줌)
        for(String gift : gifts){
            String [] gift_r = gift.split(" ");
            
            for(Friend f :f_list ){
                // A가 B에게 줌
                if(f.name.equals(gift_r[0])){
                    f.addOrder(gift_r[1]);
                }
                // B가 A에게 받음
                else if(f.name.equals(gift_r[1])){
                    f.addGift(gift_r[0]);
                }
            }
        }
        
        
        // 차례대로 다음 달에 받을 수 있는 선물 구하기
        int counts [] = new int[f_list.size()];
        
        for(int i=0; i<f_list.size(); i++){
            Friend me = f_list.get(i);
            for(int j=i; j<f_list.size(); j++){
                if(i == j) 
                    continue;
                
                Friend f = f_list.get(j);
                
                // 서로 선물을 주고 받은 횟수 비교
                int me_f = me.orderGitfs.getOrDefault(f.name, 0);
                int f_me = f.orderGitfs.getOrDefault(me.name, 0);

                if(me_f ==0 && f_me==0 || me_f == f_me){
                    // 선물 지수로 비교
                    if(me.getGitfN() > f.getGitfN()){
                        counts[i]++;
                    }
                    else if(me.getGitfN() < f.getGitfN()){
                        counts[j]++;
                    } 
                }
                else{
                    // 주고받은 선물의 개수로 비교
                   if(me_f > f_me){
                        counts[i]++;
                    }
                    else if(me_f < f_me){
                        counts[j]++;
                    } 
                }
            }
        }
        
        // 총 max 비교
        int max = 0;
        for(int count : counts){
            max = Math.max(max, count);
        }
        
        return max;
    }
}

class Friend{
    String name;
    HashMap<String, Integer> getGitfs;
    HashMap<String, Integer> orderGitfs;
    int giftN;
    
    public Friend(String name){
        this.name = name;
        getGitfs = new HashMap();
        orderGitfs = new HashMap();
        giftN = 0;
    }
    
    public boolean equals(Object o){
        Friend other = (Friend)o;
        if(this.name.equals (other.name))
            return true;
        return false;
    }
    
    // 선물을 받음
    public void addGift(String n){
        getGitfs.put(n, getGitfs.getOrDefault(n, 0) +1);
        giftN--;
    }
    
    // 선물을 줌
    public void addOrder(String n){
        orderGitfs.put(n, orderGitfs.getOrDefault(n, 0) +1);
        giftN++;
    }
    public int getGitfN(){
        return this.giftN;
    }
}