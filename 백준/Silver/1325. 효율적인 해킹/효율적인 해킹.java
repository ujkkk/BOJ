import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static int N, M, K, X;
    public static List<Integer>[] graph;
    public static ArrayList<Integer> result = new ArrayList<>();
    public static ArrayList<Integer> maxVisited = new ArrayList<>();
    public static int max = 0;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

       StringTokenizer st = new StringTokenizer(br.readLine());
       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());

       graph = new ArrayList[N+1];
       for(int i=0; i<=N; i++){
           graph[i] = new ArrayList<>();
       }

       for(int i=0; i<M; i++){
           st = new StringTokenizer(br.readLine());
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());

           if(!graph[b].contains(a))
               graph[b].add(a);

       }

       for(int i=1; i<=N; i++){

           Queue<Integer> que = new LinkedList<>();
           que.add(i);
           int cnt = 0;
           boolean [] check = new boolean[N+1];
           check[i] = true;

           while (!que.isEmpty()){
               int cur = que.poll();

               cnt++;
               for(int next : graph[cur]){
                   if(check[next]) continue;

                   check[next] = true;
                   que.add(next);
               }
           }

           if(max < cnt){
               max = cnt;
               result = new ArrayList<>();
               result.add(i);
           }
           else if(max == cnt){
               result.add(i);
           }
       }

        Collections.sort(result);
       StringBuilder sb = new StringBuilder();
       for(int i :result){
           sb.append(i).append(" ");
       }
        System.out.println(sb);

    }


}
