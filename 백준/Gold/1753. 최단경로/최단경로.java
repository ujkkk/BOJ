import javax.swing.text.html.ListView;
import java.io.*;
import java.util.*;

public class Main {
    public static int [] ans;
    public static boolean [] isVisited;
    public static ArrayList<Node>[] trees;
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());
        trees = new ArrayList[V+1];
        ans = new int[V+1];
        isVisited = new boolean[V+1];
        for(int i=1; i<=V; i++){
            trees[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            Node node = new Node(v, w);
            // 단방향 간선 생성
            trees[u].add(node);
        }

        // 최소 거리를 담을 배열 초기화
        for(int i=1; i<=V; i++){
            ans[i] = Integer.MAX_VALUE;
        }

        ans[start] = 0;
        dijkstra(start);

        // 출력
        for(int i=1; i<=V; i++){
            if(i == start)
                bw.write(0+"\n");
            else if(ans[i] == Integer.MAX_VALUE)
                bw.write("INF\n");
            else
                bw.write(ans[i]+"\n");
        }

        bw.flush();
    }

    public static void dijkstra(int start){
        // 가장 가중치가 작은 값을 뽑기 위해 우선순위 큐 사용
       PriorityQueue<Node> que = new PriorityQueue<>();
       que.add(new Node(start, 0));

       while(!que.isEmpty()){
           // 방문하지 않은 노드 중 가장 적은 노드를 선택한다.
           Node curNode = que.poll();
           // 방문한 노드라면 넘어간다
           if(isVisited[curNode.value])
               continue;
           // 방문하지 않은 노드라면 방문한다.
           isVisited[curNode.value] = true;

           // (2) 해당 노드로부터 갈 수 있는 비용을 갱신한다. (작을 때만 갱신)
           for(Node node : trees[curNode.value]){
               if(ans[node.value] > ans[curNode.value] + node.weight){
                   ans[node.value] = ans[curNode.value] + node.weight;
                   que.add(new Node(node.value, ans[node.value]));
               }
           }
       }
    }

}

class Node implements Comparable<Node>{
    int value;
    int weight;

    public Node(int value, int weight){
        this.value = value;
        this.weight = weight;
    }


    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}
