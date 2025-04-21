import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int ans = 0;
    private static int N;
    private static List<Node>[] graph;


    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            while(st.hasMoreTokens()){
                int op1 = Integer.parseInt(st.nextToken());
                if(op1 == -1) break;
                int op2 = Integer.parseInt(st.nextToken());
                graph[n].add(new Node(op1, op2));
            }
        }

        int maxIdx = bfs(1);
        ans =0;
        bfs(maxIdx);
        System.out.println(ans);

    }

   public static int bfs(int start){
        int max = 0;
        int maxIdx = 0;
       Queue<Node> que = new LinkedList<>();
       que.add(new Node(start, 0));
       boolean [] isVisited = new boolean[N+1];
       isVisited[start] = true;

       while(!que.isEmpty()){
           Node cur = que.poll();

           if(cur.cost > max){
               max = cur.cost;
               maxIdx = cur.v;
               ans = max;

           }

           for(Node next : graph[cur.v]){
               if(isVisited[next.v]) continue;
               isVisited[next.v] = true;
               que.add(new Node(next.v, cur.cost + next.cost));
           }
       }
       return maxIdx;
   }

}


class Node{
    int v;
    int cost;

    public Node(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

}
