import java.util.*;

class Solution {
    public int[] solution(String s) {
        String [] setData = s.substring(2, s.length()-2).split("},\\{");
        
        List<MySet> sets = new ArrayList();
        
        for(String set : setData){
            String strN [] = set.split(",");
            int size = strN.length;
            int [] nums = new int[size];
            
            for(int i=0; i<size; i++){
                nums[i] = Integer.parseInt(strN[i]); 
            }
            sets.add(new MySet(size, nums));
        }
        
        Collections.sort(sets);
        
        List<Integer> ans = new ArrayList();
        HashSet<Integer> hashSet = new HashSet();
        
        for(MySet set :sets){
            
            for(int n : set.nums){
                if(hashSet.contains(n)) continue;
                ans.add(n);
                hashSet.add(n);
            }
        }
        
        int [] answar = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            answar[i] = ans.get(i);
        }
        
        return answar;
    }
}

class MySet implements Comparable<MySet>{
    int [] nums;
    int size;
    
    public MySet(int size, int []nums){
        this.size = size;
        this.nums = nums;
    }
    
    @Override
    public int compareTo(MySet o){
        return this.size - o.size;
    }
}