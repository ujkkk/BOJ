import org.w3c.dom.Node;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;


public class Main {

    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Graph graph = new Graph(n+1);
        for(int i =0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.addEdge(v, w);
        }

        int q = Integer.parseInt(br.readLine());
        boolean result;
        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // 단절점인지 확인
            if(v == 1){
                if(graph.list[w].size() ==1) {
                    result = false;
                }
                else{
                    result = true;
                }
            }

            // 단절 간선인지 확인
            else{
                result = true;
            }

            if(result){
                bw.write("yes\n");
            } else{
                bw.write("no\n");
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }

}


class Graph{
    ArrayList<Integer> [] list;
    Graph(int n){
        list = new ArrayList[n];
        for(int i=0; i<n; i++){
            list[i] = new ArrayList<>();
        }
    }

    void addEdge(int v, int w){
        if(!list[v].contains(w)){
            list[v].add(w);
        }
        if(!list[w].contains(v)){
            list[w].add(v);
        }
    }
}


