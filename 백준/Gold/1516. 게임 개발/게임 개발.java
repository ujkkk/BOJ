import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int [] times;
    static int [] ans;
    static ArrayList<Integer>[] parent;
    static int [] degree;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        parent = new ArrayList[N+1];
        times = new int[N+1];
        for(int i=0; i<=N; i++){
            parent[i] = new ArrayList<>();
        }
        degree = new int[N+1];
        ans = new int[N+1];

        for(int i=1; i<=N; i++){
            String [] st =br.readLine().split(" ");
            for(int j=0; j<st.length-1; j++){
                if(j == 0){
                    times[i] = Integer.parseInt(st[j]);
                    continue;
                }
                int c = Integer.parseInt(st[j]);
                parent[c].add(i);
                degree[i]++;
            }
        }

        Queue<Integer> que = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(degree[i] == 0){
                que.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!que.isEmpty()){
            int cur = que.poll();
            ans[cur] += times[cur];

            for(int next : parent[cur]){
                ans[next] = Math.max(ans[cur], ans[next]);

                if(--degree[next] == 0){
                    que.add(next);
                }
            }
        }
        for(int i=1; i<=N; i++){
            sb.append(ans[i]).append("\n");
        }
        System.out.println(sb);
    }

}
