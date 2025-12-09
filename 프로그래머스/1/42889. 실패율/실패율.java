import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        int [] failCounts = new int[N+1];
        int allCleCount = 0;
        
        // 스테이지마다 실패 수 구하기
        for(int i=0; i<stages.length; i++){
            if(stages[i] == N+1){
                continue;
            }
            failCounts[stages[i]]++;
        }
        
        // 실패율 구하기
        ArrayList<Stage> list = new ArrayList();
        int failCount = 0;
        for(int i=1; i<=N; i++){
            double loss = failCounts[i] == 0? 0.0 : (double)failCounts[i] / ((stages.length) - failCount);
            failCount += failCounts[i];
            //System.out.println(i+" 스테이지 실패율 : " + loss);
            list.add(new Stage(i, loss));
        }
        
        Collections.sort(list);
        int[] answer = new int[N];
        for(int i=0; i<N; i++){
            answer[i] = list.get(i).n;
        }
        return answer;
    }
}

class Stage implements Comparable<Stage>{
    int n;
    double loss;
    
    public Stage(int n, double loss){
        this.n = n;
        this.loss = loss;
    }
    
    @Override
    public int compareTo(Stage o){
        if(this.loss == o.loss){
            return this.n - o.n;
        }
        return Double.compare(o.loss, this.loss);
    }
}