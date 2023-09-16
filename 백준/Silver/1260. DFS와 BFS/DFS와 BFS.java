import java.awt.*;
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점의 수
        int N = Integer.parseInt(st.nextToken());
        // 간선의 개수
        int M = Integer.parseInt(st.nextToken());
        // 탐색 시작
        int V = Integer.parseInt(st.nextToken());

        Graph graph = new Graph(N+1);

        for(int i=0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.addEdge(v,w);
        }

        for(int i=0; i< N+1; i++){
            if(graph.adj[i].size() >1 ){
                // 오름차순 정렬
                graph.adj[i].sort(Comparator.naturalOrder());
            }
        }

        graph.DFS(V);
        graph.BFS(V);
    }


}
class Graph{
    int v;
    LinkedList []  adj;
    boolean [] visited;
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    Graph(int v){
        this.v = v;
        this.visited = new boolean[v+1];
        adj = new LinkedList[v];
        for(int i=0; i<v; i++){
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w){
        if(!adj[v].contains(w))
            adj[v].add(w);
        if(!adj[w].contains(v))
            adj[w].add(v);
    }

    void DFS(int value) throws IOException{
        System.out.print(value+" ");
        visited[value] = true;
        Iterator<Integer> iterator =  adj[value].iterator();
        while (iterator.hasNext()){
            int n = iterator.next();
            if(!visited[n]){
                DFS(n);
            }
        }
    }

    void BFS(int value) throws IOException {
        boolean [] visited = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        bw.write("\n");
        visited[value] = true;
        queue.add(value);

        while(!queue.isEmpty()){
            int s = queue.poll();

            bw.write(s+" ");
            Iterator<Integer> iterator = adj[s].iterator();
            while (iterator.hasNext()){
                int n = iterator.next();
                if(!visited[n]){
                    queue.add(n);
                    visited[n]= true;
                }
            }
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}

