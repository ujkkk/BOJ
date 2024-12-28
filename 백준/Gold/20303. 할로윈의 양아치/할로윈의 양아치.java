import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        // 1. 그룹마다 얻을 수 있는 사탕 구하기
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] candies = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++){
            candies[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer>[] graph = new ArrayList[N+1];
        for(int i=0; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        List<Group> candyCounts = new ArrayList<>();
        boolean [] isVisited = new boolean[N+1];
        for(int i=1; i<=N; i++){
            if(isVisited[i])
                continue;

            candyCounts.add(getCandyCountOfGroup(graph, isVisited, candies, i));
        }

        // 2. 사탕 선택
        int ans = 0;
        int [] dp = new int[K+1];   // k명일 때 얻을 수 있는 최댓값

        for(Group group : candyCounts){
            for(int i=K-1; i>=0; i--){
                if(i - group.childrenCount >= 0){
                    dp[i] = Math.max(dp[i], dp[i - group.childrenCount] + group.candyCount);
                    ans = Math.max(dp[i], ans);
                }
            }
        }

        System.out.println(ans);
    }


    static private Group getCandyCountOfGroup(List<Integer>[] graph, boolean [] isVisited, int [] candies, int n){
        int candyCount = 0;
        int childrenCount = 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(n);

        while(!que.isEmpty()){
            int cur = que.poll();

            if(isVisited[cur])
                continue;

            isVisited[cur] = true;
            candyCount += candies[cur];
            childrenCount++;

            for(int next : graph[cur]){
                if(isVisited[next])
                    continue;

                que.add(next);
            }
        }
        return new Group(candyCount, childrenCount);
    }
}



class Group  {
    int candyCount;
    int childrenCount;

    public Group(int candyCount, int childrenCount) {
        this.candyCount = candyCount;
        this.childrenCount = childrenCount;
    }

}
