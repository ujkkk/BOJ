import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<Integer> [] graph;
    public static boolean [] visited;
    public static int count = 0;

    public static void main(String [] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<= N; i++){
            graph[i] = new ArrayList<>();
            visited[i] = false;
        }

        //간선 입력
        for(int i = 0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        if(M == 0){
            count = 1;
        }
        else{
            int idx = 1;
            //solution
            while(idx <= N){
                if(!visited[idx]){
                    dfs(idx);
                    count++;
                }
                idx++;
            }
        }
        System.out.println(count);

    }

    public static void dfs(int index){

        visited[index] = true;
        Iterator<Integer> iterator = graph[index].iterator();

        while(iterator.hasNext()){
            int child = iterator.next();
            if(!visited[child]){
                dfs(child);
            }
        }
    }

}
