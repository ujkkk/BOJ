import java.awt.*;
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Graph graph = new Graph(n+1);
        int edgeCount = Integer.parseInt(br.readLine());

        for(int i=0; i< edgeCount; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.addEdge(v,w);

        }

        System.out.println(graph.BFS(1));

    }


}
class Graph{
    int v;
    LinkedList []  adj;

    Graph(int v){
        this.v = v;
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

    int BFS(int value){
        int count = 0;
        boolean [] visited = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[value] = true;
        queue.add(value);

        while(!queue.isEmpty()){
            int s = queue.poll();
            Iterator<Integer> iterator = adj[s].iterator();
            while (iterator.hasNext()){
                int n = iterator.next();
                if(!visited[n]){
                    count++;
                    queue.add(n);
                    visited[n]= true;
                }
            }
        }
        return count;
    }
}

