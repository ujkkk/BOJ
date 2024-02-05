import javax.print.DocFlavor;
import java.io.*;
import java.util.*;

/*
    위상 정렬 이용 : 선후 관계가 있고, 사이클이 없으면서 순서를 알아야 하기 때문ㅇ
    입력이 '[시간] [선 건물1] [선 건물2] ... [-1]' 이 주어지기에 구분 필요
    건물은 동시에 지을 수 있기에 직전 건물까지 걸린 시간을 알고 있어야 함
 */
public class Main {
    static BufferedWriter bw;
    static BufferedReader br;
    static ArrayList<Node> [] graph;
    static int V, E;


    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V+1];
        for(int i= 1; i<=V; i++){
            graph[i] = new ArrayList<>();
        }
        // 시작 노드
        int start = Integer.parseInt(br.readLine());

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        int [] result = dijkstra(new Node(start, 0));
        for(int i=1; i<=V; i++){
            if(result[i] == Integer.MAX_VALUE)
                bw.write("INF\n");
            else
                bw.write(result[i] +"\n");
        }

        bw.flush();
        br.close();
        bw.close();

    }

    public static int [] dijkstra(Node start){
        boolean [] isVisited = new boolean[V+1];
        int [] dis = new int[V+1];
        PriorityQueue<Node> que = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });

        Arrays.fill(dis, Integer.MAX_VALUE);
        que.add(start);
        dis[start.data] = 0;

        while(!que.isEmpty()){
            Node cur = que.poll();
            if(isVisited[cur.data])
                continue;

            isVisited[cur.data] = true;
            for(Node node : graph[cur.data]){
                int next = node.data;
                int weight = node.weight;

                if(dis[next] > dis[cur.data] + weight){
                    dis[next] = dis[cur.data] + weight;
                    que.add(new Node(next, dis[next]));
                }
            }
        }
        return dis;
    }



}

class Node{
    int data;
    int weight;

    public Node(int data, int weight){
        this.data = data;
        this.weight = weight;
    }

}
