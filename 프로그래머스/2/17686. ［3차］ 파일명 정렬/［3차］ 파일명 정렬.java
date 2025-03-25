import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        
        ArrayList<File> fileList = new ArrayList();
        
        for(int i=0; i<files.length; i++){
            fileList.add(new File(files[i], i));
            //fileList.add(new File("F-15", i));
        }
        
        Collections.sort(fileList);
        String[] answer = new String[fileList.size()];
        int idx = 0;
        for(File file : fileList){
            answer[idx++] = files[file.idx];
        }
        return answer;
    }
}

class File implements Comparable<File>{
    
    int idx;
    String head;
    String number;
    String tail;
    
    File(String file, int idx){
        this.idx = idx;
        // 숫자까지 끊음
        int idx1 = 0;
        for(idx1 =0; idx1 < file.length(); idx1++){
            if(file.charAt(idx1) >= '0' && file.charAt(idx1) <= '9')
                break;
        }
        this.head = file.substring(0, idx1).toUpperCase();
        
        int idx2;
        for(idx2=idx1; idx2<idx1 + 5; idx2++){
            if(idx2 >= file.length()){
                break;
            }
            // 숫자가 아님
            if(file.charAt(idx2) < '0' || file.charAt(idx2) > '9')
                break;
        }
        // 공백을 제거할지
        this.number = file.substring(idx1, idx2).trim();
        this.tail = file.substring(idx2, file.length()).trim();
//         if(idx2 < file.length()){
            
//         }
        
        System.out.println(String.format("%s : %s : %s", head, number, tail));
    }
    
    @Override
    public int compareTo(File o){
        // head 비교
        if(!this.head.equals(o.head)){
            return this.head.compareTo(o.head);
        }
        // number 비교
        int n1 = Integer.parseInt(this.number);
        int n2 = Integer.parseInt(o.number);
        if(n1 != n2){
            return n1 - n2;
        }
        
        // tail비교
        return this.idx - o.idx;
    }
    
    
}