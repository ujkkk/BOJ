import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    친구 점수 : 몇 사람을 건너야 모든 사람과 알게되는지 
              -> 모든 노드를 돌기 위한 최장 거리가 몇이냐
    회장 조건 : 친구 점수가 가장 작은 사람.
    구현:
        1. bfs(완탐 가능, 구현 쉬움)로 멤버마다 친구 점수 구함
        2. 가장 작은 친구 점수 알아냄
        3. 가장 작은 친구 점수 가지는 멤버 알아냄
 */
class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<Integer>[] graph;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        while(true){
            String[] str = br.readLine().split(" ");
            int n1 = Integer.parseInt(str[0]);
            int n2 = Integer.parseInt(str[1]);
            if(n1 == -1 && n2 == -1){
                break;
            }

            graph[n1].add(n2);
            graph[n2].add(n1);
        }
        // 그래프 입력 끝

        // 친구 점수 구함
        int [] points = new int[N+1];
        int minPoint = 101;
        for(int i=1; i<=N; i++){
            // i 회원의 친구 점수
            int friendPoint = bfs(i);
            minPoint = Math.min(minPoint, friendPoint);
            points[i] = friendPoint;
        }

        // 회장 후보의 점수와 후보의 수
        int ansCount = 0;
        List<Integer> ansMembers = new ArrayList<>();

        for(int i=1; i<=N; i++){
            if(points[i] == minPoint){
                ansCount++;
                ansMembers.add(i);
            }
        }
        bw.write(minPoint + " " + ansCount +"\n");
        for(int m : ansMembers){
            bw.write(m +" ");
        }
        bw.flush();
    }

    public static int bfs(int start){
        Queue<Integer> que = new LinkedList<>();
        boolean [] isVisited = new boolean[N+1];
        int [] dist = new int[N+1];
        int max = 0;

        que.add(start);
        isVisited[start] = true;

        while(!que.isEmpty()){
            int cur = que.poll();
            max = dist[cur];

            for(int next : graph[cur]){
                if(isVisited[next])
                    continue;

                dist[next] = dist[cur] + 1;
                isVisited[next] = true;
                que.add(next);
            }
        }
        //System.out.println("멤버 " + start +"의 점수: " + max);
        return max;
    }
}
