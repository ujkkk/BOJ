import java.awt.*;
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점의 수
        int N = Integer.parseInt(st.nextToken());

        Graph graph = new Graph(N+1);

        for(int i=0; i< N-1; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.addEdge(v,w);
        }

        graph.DFS(1, 0);

        for(int i =2; i< graph.parent.size(); i++){
            System.out.println(graph.parent.get(i));
        }
    }


}
class Graph{
    int v;
    LinkedList []  adj;
    boolean [] visited;
    ArrayList parent;

    Graph(int v){
        this.v = v;
        this.visited = new boolean[v+1];
        adj = new LinkedList[v];
        parent = new ArrayList();
        for(int i=0; i<v; i++){
            adj[i] = new LinkedList();
            parent.add(i,0);
        }
    }

    void addEdge(int v, int w){
        if(!adj[v].contains(w))
            adj[v].add(w);
        if(!adj[w].contains(v))
            adj[w].add(v);
    }

    void DFS(int child, int p) {
        visited[child] = true;
        parent.set(child, p);
        Iterator<Integer> iterator =  adj[child].iterator();
        while (iterator.hasNext()){
            int n = iterator.next();
            if(!visited[n]){
                DFS(n, child);
            }
        }
    }

}

