import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static ArrayList<Integer>[] graph;
    static int [] inDegree;
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        inDegree = new int[N+1];
        for(int i=0; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            String [] cmd = br.readLine().split(" ");
            int singerCount = Integer.parseInt(cmd[0]);

            for(int j=1; j<singerCount; j++){
                int s1 = Integer.parseInt(cmd[j]);
                int s2 = Integer.parseInt(cmd[j+1]);

                if(!graph[s1].contains(s2)){
                    graph[s1].add(s2);
                    inDegree[s2]++;
                }
            }
        }

        if(selectOrder(N)){
            bw.flush();
        }
        else{
            System.out.println("0");
        }
    }

    private static boolean selectOrder(int N) throws IOException {
        Queue<Integer> que = new LinkedList<>();
        int count = 0;

        // 시작점 찾기
        for(int i=1; i<N+1; i++){
            if(inDegree[i] == 0){
                que.add(i);
            }
        }

        while(!que.isEmpty()){

            int cur = que.poll();
            count++;

            bw.write(cur+"\n");

            if(count == N){
                return true;
            }

            for(int next : graph[cur]){
                inDegree[next]--;

                if(inDegree[next] == 0){
                    que.add(next);
                }
            }
        }

        return false;
    }
}

